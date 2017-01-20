package com.epam.validators;

import java.util.List;

import com.epam.model.Error;

public class MaxLengthValidator implements Validator<String> {
	public static final int MAX_LEN_ERROR_CODE = 3;
	public static final int MAX_LENGTH = 32;
	public static final String MAX_LEN_ERROR_MESSAGE = String.format("Password cannot be less than %s chars",
			MAX_LENGTH);

	public void validate(String input, List<Error> errors) {
		if (input.trim().length() > MAX_LENGTH) {
			errors.add(new Error(MAX_LEN_ERROR_CODE, MAX_LEN_ERROR_MESSAGE));
		}
	}
}
