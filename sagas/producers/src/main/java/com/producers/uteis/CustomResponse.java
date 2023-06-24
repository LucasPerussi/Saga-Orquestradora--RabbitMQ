package com.producers.uteis;

import org.springframework.http.HttpStatus;

public class CustomResponse {
	private int status;
	private String message;
	
	public CustomResponse(HttpStatus status, String message) {
		this.status = status.value();
		this.message = message;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getMessage() {
		return message;
	}
}
