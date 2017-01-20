package com.epam.model;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {
	private Status status;
	private List<Error> errors;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
}
