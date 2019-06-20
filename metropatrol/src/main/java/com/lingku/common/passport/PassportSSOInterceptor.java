package com.lingku.common.passport;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import com.alibaba.fastjson.JSON;
import com.lingku.common.custom.RequiresLogin;
import com.lingku.common.custom.RequiresRoles;
import com.lingku.common.pojo.UserType;
import com.lingku.common.utils.JWTUtil;
import com.lingku.xundao.Premission.service.IPremissionService;
import com.lingku.xundao.user.pojo.LoginUser;

import com.lk.common.model.ResponseDataModel;

//测试拦截器1
@Component
public class PassportSSOInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(PassportSSOInterceptor.class);

	// @Value("${spring.application.name}")
	// private String appName;

	@Autowired
	private IPremissionService premissionService;

	// 进入Handler方法之前执行
	// 可以用于身份认证、身份授权。如果认证没有通过表示用户没有登陆，需要此方法拦截不再往下执行，否则就放行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String httpMethod = request.getMethod();

		// 判断是否为请求静态资源的handle
//		System.err.println("拦截到到的handle======>" + handler);

		if (handler instanceof ResourceHttpRequestHandler) {
			// 请求静态资源
			System.err.println("静态资源请求>>>>>>" + handler);
			return true;
		}

		if (httpMethod.equals(HttpMethod.GET.toString()) || httpMethod.equals(HttpMethod.POST.toString())) {
			// 转换请求的handle
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			PassportContext.clearData();

			// 不需要登录的接口，不拦截

			if (!isRequiresLogin(method)) {
				return true;
			}

			boolean hasLogin = validLogin(method, request);
			if (!hasLogin) {
				writeNeedLogin(request, response, HttpStatus.UNAUTHORIZED);
				return false;
			}

			boolean hasRole = validRole(method);
			if (!hasRole) {
				writeNeedLogin(request, response, HttpStatus.FORBIDDEN);
				return false;
			}

			boolean hasPremission = validPremission(method, request);
			if (!hasPremission) {
				writeNeedLogin(request, response, HttpStatus.FORBIDDEN);
				return false;
			}
		}
		return true;

	}

	/**
	 * @2019年6月3日
	 * @description 判断是否需要角色的某个权限
	 * @param method
	 * @param request
	 * @return
	 */
	private boolean validPremission(Method method, HttpServletRequest request) {
		String token = request.getHeader(com.lingku.common.passport.Constants.TOKEN);
		// 优先使用方法上的注解。

		RequiresPremission requiresPremission = method.getAnnotation(RequiresPremission.class);
		// 方法上没有，则使用类上的注解。
		if (requiresPremission == null) {
			requiresPremission = method.getDeclaringClass().getAnnotation(RequiresPremission.class);
		}
		// 需要登录
		if (requiresPremission == null) {
			return true;
		}

		LoginUser userInfo = PassportContext.getPassportUserInfo();

		Integer roleId = userInfo.getRole_id();
		String[] needPremmission = requiresPremission.value();

		if (roleId == null) {
			return false;
		}

		Set<String> premissionSetStr = premissionService.getPremissionName(roleId, token);

		if (requiresPremission.logical().equals(Logical.AND)) {
			return setHasAllValues(premissionSetStr, needPremmission);
		} else {
			return setHasOneValues(premissionSetStr, needPremmission);
		}
	}

	/**
	 * @2019年6月3日
	 * @description
	 * @param method
	 *            查询使用角色
	 * @return
	 */
	private boolean validRole(Method method) {
		// 优先使用方法上的注解。
		RequiresRoles requiresRoles = method.getAnnotation(RequiresRoles.class);
		// 方法上没有，则使用类上的注解。
		if (requiresRoles == null) {
			requiresRoles = method.getDeclaringClass().getAnnotation(RequiresRoles.class);
		}

		if (requiresRoles == null) {
			return true;
		}

		LoginUser userInfo = PassportContext.getPassportUserInfo();
		Integer userType = userInfo.getUser_type();

		for (UserType type : requiresRoles.value()) {
			if (type.getType().equals(userType)) {
				return true;
			}
		}

		return false;
	}

	// values 里面至所有item 属于set集合
	private boolean setHasAllValues(Set<String> set, String[] values) {
		for (String item : values) {
			if (!set.contains(item)) {
				return false;
			}
		}
		return true;
	}

	// values 里面至少有一个item 属于set集合
	private boolean setHasOneValues(Set<String> set, String[] values) {
		for (String item : values) {
			if (set.contains(item)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @2019年6月3日
	 * @description 解析验证token
	 * @param method
	 * @param request
	 * @return
	 */
	private boolean validLogin(Method method, HttpServletRequest request) {
		String token = request.getHeader(com.lingku.common.passport.Constants.TOKEN);

		LoginUser passportUserInfo = null;
		if (!StringUtils.isEmpty(token)) {
			// 刷新token
			try {
				passportUserInfo = JWTUtil.verify(token);
				if (passportUserInfo != null) {
					System.err.println("解析的用户信息");
					PassportContext.setPassportUserInfo(passportUserInfo);
				}
			} catch (Exception e) {
				LOGGER.error("token验证异常", e);
			}
		}

		boolean isLoginSuccess = passportUserInfo != null;

		LOGGER.info("Passport SSO valid result ===>  TOKEN :{} , UserInfo：{}", token,
				JSON.toJSONString(passportUserInfo));

		return isLoginSuccess;
	}

	/**
	 * @2019年6月3日
	 * @description 判断是否需要登录
	 * @param method
	 * @return
	 */
	private boolean isRequiresLogin(Method method) {
		// 优先使用方法上的注解。
		RequiresLogin requiresLogin = method.getAnnotation(RequiresLogin.class);
		// 方法上没有PassportSSO，则使用类上的。
		if (requiresLogin == null) {
			requiresLogin = method.getDeclaringClass().getAnnotation(RequiresLogin.class);
		}

		// 优先使用方法上的注解。
		RequiresRoles requiresRoles = method.getAnnotation(RequiresRoles.class);
		// 方法上没有PassportSSO，则使用类上的。
		if (requiresRoles == null) {
			requiresRoles = method.getDeclaringClass().getAnnotation(RequiresRoles.class);
		}

		// 优先使用方法上的注解。
		RequiresPremission requiresPremission = method.getAnnotation(RequiresPremission.class);
		// 方法上没有PassportSSO，则使用类上的。
		if (requiresPremission == null) {
			requiresPremission = method.getDeclaringClass().getAnnotation(RequiresPremission.class);
		}

		return requiresLogin != null || requiresRoles != null || requiresPremission != null;
	}

	/**
	 * @author NYY
	 * @2019年6月3日
	 * @description
	 * @param request
	 * @param response
	 * @param status
	 * @throws IOException
	 *             设置头信息
	 */
	private void writeNeedLogin(HttpServletRequest request, HttpServletResponse response, HttpStatus status)
			throws IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(status.value());
		// 允许跨域支持
		String origin = request.getHeader("Origin");
		if (origin == null) {
			response.addHeader("Access-Control-Allow-Origin", "*");
		} else {
			response.addHeader("Access-Control-Allow-Origin", origin);
		}
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS,DELETE");

		PrintWriter writer = response.getWriter();
		ResponseDataModel data = new ResponseDataModel();
		data.setCode(String.valueOf(status.value()));
		data.setMsg(status.getReasonPhrase());
		writer.write(JSON.toJSONString(data));
		writer.flush();
		writer.close();
	}

	/**
	 * 验证地址是否登录
	 *
	 * @param request
	 * @return
	 */
	private boolean validateAccess(HttpServletRequest request) {
		String authorization = getFromHeaderOrParameter(request, "authorization");
		/*
		 * // 有些情况，前端Header没有带“authorization”，系统可以直接从cookie里面取。 if
		 * (StringUtils.isEmpty(authorization)) { authorization =
		 * getTokenFromCookie(request); }
		 */
		String channel = getFromHeaderOrParameter(request, "chan");
		String gfga = getFromHeaderOrParameter(request, "gfga");

		// 没有带ticket
		if (StringUtils.isEmpty(authorization)) {
			// 需要登录，直接拦截, 否则放行。
			return false;
		}

		boolean validSuccess = false;
		try {

		} catch (Exception e) {
			LOGGER.error("单点登录验证验证异常", e);
		}
		return validSuccess;
	}

	private String getTokenFromCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String token = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("token".equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return token;
	}

	private String getFromHeaderOrParameter(HttpServletRequest request, String key) {
		if (request.getParameterMap().containsKey(key)) {
			return request.getParameter(key);
		} else {
			return request.getHeader(key);
		}
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {

	}

}