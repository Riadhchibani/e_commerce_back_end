package com.ec.springApp.payload;

public class JwtResponse {

	private String token;
	private String type = "Basic";
	private String username;
	private String password;

	public JwtResponse(String jwt, Long id, String username, String password) {

		this.token = jwt;
		this.username = username;
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
