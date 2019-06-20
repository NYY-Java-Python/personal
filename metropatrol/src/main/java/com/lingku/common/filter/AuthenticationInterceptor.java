//package com.lingku.common.filter;
//
//import java.lang.reflect.Method;
//import java.util.HashMap;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.lingku.common.custom.PassToken;
//import com.lingku.common.custom.UserLoginToken;
//import com.lingku.xundao.user.pojo.TestUser;
//import com.lingku.xundao.user.service.UserService;
//
///**
// * @author NYY
// * @2019年5月28日
// * @description 拦截器
// */
//public class AuthenticationInterceptor implements HandlerInterceptor {
//
//	@Autowired
//	UserService userService;
//
//	@Override
//	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//			Object object) throws Exception {
//		String token = httpServletRequest.getHeader("token");
//		// 从 http 请求头中取出token
//
//		// 如果不是映射到方法直接通过
//		if (!(object instanceof HandlerMethod)) {
//			return true;
//		}
//		HandlerMethod handlerMethod = (HandlerMethod) object;
//		Method method = handlerMethod.getMethod();
//
//		// 检查是否有passtoken注释，有则跳过认证
//		if (method.isAnnotationPresent(PassToken.class)) {
//			PassToken passToken = method.getAnnotation(PassToken.class);
//			if (passToken.required()) {
//				return true;
//			}
//		}
//
//		// 检查有没有需要用户权限的注解
//		if (method.isAnnotationPresent(UserLoginToken.class)) {
//			UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
//			if (userLoginToken.required()) {
//				// 执行认证
//				if (token == null) {
//					System.err.println("无Token,请重新登录");
//					// throw new RuntimeException("无token，请重新登录");
//				}
//				// 获取 token 中的 user id
//				String userId = "";
//				try {
//					userId = JWT.decode(token).getAudience().get(0);
//				} catch (Exception j) {
//					System.err.print("one :401" + j);
//					// throw new RuntimeException("401");
//				}
//				TestUser user = userService.findUserById(userId);
//				if (user == null) {
//					System.err.println("用户不存在");
//					// throw new RuntimeException("用户不存在，请重新登录");
//				}
//				// 验证 token
//				JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
//				try {
//					jwtVerifier.verify(token);
//				} catch (Exception e) {
//					System.err.print("two :401" + e);
//				}
//				return true;
//			}
//		}
//		return true;
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
//			ModelAndView modelAndView) throws Exception {
//
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//			Object o, Exception e) throws Exception {
//	}
//
//}
