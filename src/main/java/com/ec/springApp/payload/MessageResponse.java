package com.ec.springApp.payload;

public class MessageResponse {

	private String status;

	public MessageResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
