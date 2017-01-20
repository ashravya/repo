package com.epam.validators;

import java.util.List;

import com.epam.model.Error;

public interface Validator<T> {
	public void validate(T input, List<Error> errors);
}
