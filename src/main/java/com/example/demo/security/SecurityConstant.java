package com.example.demo.security;
public class SecurityConstant {
	public static final String SIGN_UP_URLS = "/api/users/**";
	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final long EXPIRATION_TIME = 30000_000;
}
