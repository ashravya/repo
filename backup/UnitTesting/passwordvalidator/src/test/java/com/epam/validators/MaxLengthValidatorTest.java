package com.epam.validators;

import static com.epam.validators.MaxLengthValidator.MAX_LEN_ERROR_CODE;
import static com.epam.validators.MaxLengthValidator.MAX_LEN_ERROR_MESSAGE;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.epam.model.Error;

public class MaxLengthValidatorTest {
	private MaxLengthValidator maxLengthValidator;

	@Before
	public void setup() {
		maxLengthValidator = new MaxLengthValidator();
	}

	@Test
	public void validateShouldAddErrorWhenAboveMaxLength() {
		ArrayList<Error> error = new ArrayList<Error>();
		maxLengthValidator.validate("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", error);
		assertThat(error, hasItem(new Error(MAX_LEN_ERROR_CODE, MAX_LEN_ERROR_MESSAGE)));
	}

	@Test
	public void validateShouldNotAddErrorWhenBelowMaxLength() {
		ArrayList<Error> error = new ArrayList<Error>();
		maxLengthValidator.validate("test", error);
		assertThat(error, is(Matchers.empty()));
	}

	@Test(expected = NullPointerException.class)
	public void validateShouldThrowNullPointerExceptionWhenInputIsNull() {
		ArrayList<Error> error = new ArrayList<Error>();
		maxLengthValidator.validate(null, error);
		assertThat(error, is(Matchers.empty()));
	}

	@Test
	public void validateShouldNotAddErrorWhenInputIsEmptyStringWithLengthGreaterThanMaxLength() {
		ArrayList<Error> error = new ArrayList<Error>();
		maxLengthValidator.validate("                                                          " + "", error);
		assertThat(error, is(Matchers.empty()));
	}
}
