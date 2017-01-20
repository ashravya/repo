package com.epam.services;

import java.util.ArrayList;
import java.util.List;

import com.epam.model.Error;
import com.epam.model.Response;
import com.epam.model.Status;
import com.epam.validators.EmptyValidator;
import com.epam.validators.MaxLengthValidator;
import com.epam.validators.MinLengthValidator;

public class PasswordValidatorService {

	private EmptyValidator emptyValidator;
	private MaxLengthValidator maxLengthValidator;
	private MinLengthValidator minLengthValidator;

	public PasswordValidatorService(EmptyValidator emptyValidator, MaxLengthValidator maxLengthValidator,
			MinLengthValidator minLengthValidator) {
		super();
		this.emptyValidator = emptyValidator;
		this.maxLengthValidator = maxLengthValidator;
		this.minLengthValidator = minLengthValidator;
	}

	public Response validate(String input) {
		List<Error> errors = new ArrayList<Error>();
		emptyValidator.validate(input, errors);
		maxLengthValidator.validate(input, errors);
		minLengthValidator.validate(input, errors);
		Response response = new Response();
		response.setErrors(errors);
		if (errors.isEmpty()) {
			response.setStatus(Status.PASS);
		} else {
			response.setStatus(Status.FAIL);
		}
		return response;
	}
}
