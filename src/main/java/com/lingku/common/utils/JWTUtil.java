package com.lingku.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lingku.xundao.user.pojo.UserInfo;

@Component
public class JWTUtil {

	private static String jwtSecret = "asfddasf32412353453";

	private static final String USER_INFO_KEY = "USER_INFO_KEY";

	@Value("${jwtSecret}")
	public static void setJwtSecret(String jwtSecret) {
		JWTUtil.jwtSecret = jwtSecret;
	}

	// 过期时间3小时
	private static final long EXPIRE_TIME = 3 * 60 * 60 * 1000;

	/**
	 * 校验token是否正确
	 * 
	 * @param token
	 *            密钥
	 * @return 是否正确
	 */
	public static UserInfo verify(String token) {
		try {

			DecodedJWT jwt = JWT.decode(token);
			String userInfoStr = jwt.getClaim(USER_INFO_KEY).asString();
			Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
			JWTVerifier verifier = JWT.require(algorithm).withClaim(USER_INFO_KEY, userInfoStr).build();
			verifier.verify(token);
			return JSON.parseObject(userInfoStr, UserInfo.class);
		} catch (Exception exception) {
			return null;
		}
	}

	/**
	 * 生成签名,5min后过期
	 * 
	 * @return 加密的token
	 */
	public static String createToken(UserInfo passportUserInfo) {
		try {
			Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
			Algorithm algorithm = Algorithm.HMAC256(jwtSecret);

			// 附带username信息
			return JWT.create().withClaim(USER_INFO_KEY, JSON.toJSONString(passportUserInfo)).withExpiresAt(date)
					.sign(algorithm);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
}
