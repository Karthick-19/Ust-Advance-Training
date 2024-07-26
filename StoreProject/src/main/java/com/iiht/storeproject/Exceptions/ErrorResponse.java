package com.iiht.storeproject.Exceptions;

import java.util.Date;

public class ErrorResponse {
	
	private String message;
	private String errorCode;
	private Date time;
	
	public ErrorResponse() {
	}

	public ErrorResponse(String message, String errorCode, Date time) {
		super();
		this.message = message;
		this.errorCode = errorCode;
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", errorCode=" + errorCode + ", time=" + time + "]";
	}
}
