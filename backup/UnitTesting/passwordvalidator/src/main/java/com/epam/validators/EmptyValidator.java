package com.epam.validators;

import java.util.List;

import com.epam.model.Error;

public class EmptyValidator implements Validator<String> {

	public static final int EMPTY_ERROR_CODE = 1;
	public static final String EMPTY__ERROR_MESSAGE = "Password cannot be Empty";

	public void validate(String input, List<Error> errors) {
		if (input == null || "".equals(input.trim())) {
			errors.add(new Error(EMPTY_ERROR_CODE, EMPTY__ERROR_MESSAGE));
		}
	}
}
