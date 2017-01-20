package com.epam.validators;

import java.util.List;

import com.epam.model.Error;

public class MinLengthValidator implements Validator<String> {
	public static final int MIN_LEN_ERROR_CODE = 2;
	public static final int MIN_LENGTH = 8;
	public static final String MIN_LEN_ERROR_MESSAGE = String.format("Password cannot be less than %s chars",
			MIN_LENGTH);

	public void validate(String input, List<Error> errors) {
		if (input.trim().length() < MIN_LENGTH) {
			errors.add(new Error(MIN_LEN_ERROR_CODE, MIN_LEN_ERROR_MESSAGE));
		}
	}
}
