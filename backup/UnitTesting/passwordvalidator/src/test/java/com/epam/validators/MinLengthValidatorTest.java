package com.epam.validators;

import static com.epam.validators.MinLengthValidator.MIN_LEN_ERROR_CODE;
import static com.epam.validators.MinLengthValidator.MIN_LEN_ERROR_MESSAGE;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.epam.model.Error;
import com.epam.validators.MinLengthValidator;

public class MinLengthValidatorTest {
	private MinLengthValidator minLengthValidator;

	@Before
	public void setup() {
		minLengthValidator = new MinLengthValidator();
	}

	@Test
	public void validateShouldAddErrorWhenBelowMinLength() {
		ArrayList<Error> errors = new ArrayList<Error>();
		minLengthValidator.validate("test", errors);
		assertThat(errors, hasItem(new Error(MIN_LEN_ERROR_CODE, MIN_LEN_ERROR_MESSAGE)));
	}

	@Test
	public void validateShouldNotAddErrorWhenAtOrAboveMinLeng() {
		ArrayList<Error> errors = new ArrayList<Error>();
		minLengthValidator.validate("AAAAAAAAAAAAAAAAAAAAAAAAAAA", errors);
		assertThat(errors, is(Matchers.empty()));
	}

	@Test(expected = NullPointerException.class)
	public void validateShouldThrowNullPointerExceptionWhenInputIsNull() {
		ArrayList<Error> errors = new ArrayList<Error>();
		minLengthValidator.validate(null, errors);
		assertThat(errors, is(Matchers.empty()));
	}

	@Test
	public void validateShouldAddErrorWhenEmptyStringWithLengthGreaterThanMinLength() {
		ArrayList<Error> errors = new ArrayList<Error>();
		minLengthValidator.validate("                           ", errors);
		assertThat(errors, hasItem(new Error(MIN_LEN_ERROR_CODE, MIN_LEN_ERROR_MESSAGE)));
	}
}
