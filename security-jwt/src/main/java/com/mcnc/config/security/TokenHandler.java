package com.mcnc.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.core.userdetails.User;

import com.mcnc.app.Account;
import com.mcnc.app.user.UserService;

public final class TokenHandler {
	private final String secret;
	private final UserService userService;

	public TokenHandler(String secret, UserService userService) {
		this.secret = secret;
		this.userService = userService;
	}

	public User parseUserFromToken(String token) {
		String username = Jwts.parser().setSigningKey(secret)
				.parseClaimsJws(token).getBody().getSubject();
		return userService.loadUserByUsername(username);
	}

	public String createTokenForUser(User user) {
		return Jwts.builder().setSubject(user.getUsername())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public String createTokenForAccount(Account account) {
		return Jwts.builder().setSubject(account.getUsername())
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}
