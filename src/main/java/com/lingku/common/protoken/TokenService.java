package com.lingku.common.protoken;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.lingku.common.utils.JWTUtil;
import com.lingku.xundao.user.pojo.UserInfo;

/**
 * @author NYY
 * @2019年5月28日
 * @description token生成方法
 */
@Service
public class TokenService {

	public String getToken(UserInfo user) {
		String token = "";
		try {
			token = JWTUtil.createToken(user);
			System.err.println(token);
		} catch (IllegalArgumentException e) {

			System.err.println("TokenService:" + e);
		} catch (JWTCreationException e) {

			System.err.println("TokenService:" + e);

		}

		return token;
	}
}
