package com.mycompany.caas.model;

import java.time.Instant;

/**
 * @author dinesh.lohia
 */

public class JwtRefreshToken {
	private String token;

	private User user;

	private Instant expirationDateTime;

	public JwtRefreshToken() {

	}

	public JwtRefreshToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Instant getExpirationDateTime() {
		return expirationDateTime;
	}

	public void setExpirationDateTime(Instant expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}
}
