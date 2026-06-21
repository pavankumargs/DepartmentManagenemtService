package com.pavan.microservices.department.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	private String message;
	private int status;
	private LocalDateTime timeStamp;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String message, int status, LocalDateTime timeStamp) {
		this.message = message;
		this.status = status;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", status=" + status + ", timeStamp=" + timeStamp + "]";
	}
}
