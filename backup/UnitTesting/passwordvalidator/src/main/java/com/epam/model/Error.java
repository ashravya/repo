package com.epam.model;

public class Error {
	private int code;
	private String message;

	public Error(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if (obj instanceof Error) {
			Error error = (Error) obj;
			equals = this.code == error.code && (this.message == error.message || this.message.equals(error.message));
		}
		return equals;
	}

	@Override
	public int hashCode() {
		return code + message.hashCode();
	}
}
