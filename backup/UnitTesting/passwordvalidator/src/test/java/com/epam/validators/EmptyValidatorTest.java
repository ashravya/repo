package com.epam.validators;

import static com.epam.validators.EmptyValidator.EMPTY_ERROR_CODE;
import static com.epam.validators.EmptyValidator.EMPTY__ERROR_MESSAGE;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.epam.model.Error;

public class EmptyValidatorTest {

	private EmptyValidator emptyValidator;

	@Before
	public void setup() {
		emptyValidator = new EmptyValidator();
	}
	

	@Test
	public void validateShouldAddErrorWhenNull() {
		ArrayList<Error> errors = new ArrayList<Error>();
		emptyValidator.validate(null, errors);
		assertThat(errors, hasItem(new Error(EMPTY_ERROR_CODE, EMPTY__ERROR_MESSAGE)));
	}

	@Test
	public void validateShouldAddErrorWhenEmpty() {
		ArrayList<Error> errors = new ArrayList<Error>();
		emptyValidator.validate("    ", errors);
		assertThat(errors, hasItems(new Error(EMPTY_ERROR_CODE, EMPTY__ERROR_MESSAGE)));
	}
	
	@Test
	@Ignore
	public void validateShouldAddErrorWhenEmptyWithMultipleArgumentCheck() {
		ArrayList<Error> errors = new ArrayList<Error>();
		emptyValidator.validate("    ", errors);
		Error error = new Error(EMPTY_ERROR_CODE, EMPTY__ERROR_MESSAGE);
		Error error2 = new Error(100, "TEST");
		assertThat(errors, hasItems(error, error2));
	}

	@Test
	public void validateShouldNotAddErrorWhenNotNullOrEmpty() {
		ArrayList<Error> errors = new ArrayList<Error>();
		emptyValidator.validate("test", errors);
		assertThat(errors, is(Matchers.empty()));
	}

}
