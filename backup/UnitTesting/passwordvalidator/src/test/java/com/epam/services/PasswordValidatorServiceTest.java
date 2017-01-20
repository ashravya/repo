package com.epam.services;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.epam.model.Error;
import com.epam.model.Response;
import com.epam.model.Status;
import com.epam.validators.EmptyValidator;
import com.epam.validators.MaxLengthValidator;
import com.epam.validators.MinLengthValidator;

@RunWith(MockitoJUnitRunner.class)
public class PasswordValidatorServiceTest {

	@InjectMocks
	private PasswordValidatorService passwordValidatorService;

	@Mock
	private EmptyValidator emptyValidator;

	@Mock
	private MaxLengthValidator maxLengthValidator;

	@Mock
	private MinLengthValidator minLengthValidator;

	@Test
	public void shouldDelegateToValidatorsInOrder() {
		String input = "Test";
		passwordValidatorService.validate(input);
		InOrder order = inOrder(emptyValidator, maxLengthValidator, minLengthValidator);
		order.verify(emptyValidator, times(1)).validate(eq(input), anyList());
		order.verify(maxLengthValidator, times(1)).validate(eq(input), anyList());
		order.verify(minLengthValidator, times(1)).validate(eq(input), anyList());
	}

	@Test
	public void simpleMockingExample() {
		List mockedList = Mockito.mock(ArrayList.class);
		when(mockedList.get(0)).thenReturn("Hello");
		when(mockedList.get(anyInt())).thenReturn("Hello");
		Object object = mockedList.get(99);
		verify(mockedList, atMost(1)).get(99);
		assertThat(object, is((Object) "Hello"));
		doReturn("Hello").when(mockedList).get(0);
	}
	
	@Test
	public void argumentCaptorDemo() {
		ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
		passwordValidatorService.validate("Test");
		verify(emptyValidator).validate(eq("Test"), argumentCaptor.capture());
		List<Error> value = argumentCaptor.getValue();
		assertThat(value, is(Matchers.empty()));
	}

	@Test
	public void shouldProducePassResponseWithNoErrors() {
		doCallRealMethod().when(emptyValidator).validate(anyString(), anyList());
		doCallRealMethod().when(maxLengthValidator).validate(anyString(), anyList());
		doCallRealMethod().when(minLengthValidator).validate(anyString(), anyList());
		String input = "ABCDEFGHIJKLMNOP";
		Response response = passwordValidatorService.validate(input);
		assertThat(response.getStatus(), is(Status.PASS));
		assertThat(response.getErrors(), is(Matchers.empty()));
	}

	@Test
	public void shouldProduceFailResponseWhenEmpty() {
		final Error error = mock(Error.class);
		doAnswer(new Answer() {
			public Object answer(InvocationOnMock invocation) throws Throwable {
				List list = invocation.getArgumentAt(1, List.class);
				list.add(error);
				return list;
			}
		}).when(emptyValidator).validate(anyString(), anyList());
		String input = "";
		Response response = passwordValidatorService.validate(input);
		assertThat(response.getStatus(), is(Status.FAIL));
		assertThat(response.getErrors(), hasItem(error));
	}

	@Test
	public void shouldProduceFailResponseWhenBelowMinimum() {
		final Error error = mock(Error.class);
		doAnswer(new Answer() {
			public Object answer(InvocationOnMock invocation) throws Throwable {
				List list = invocation.getArgumentAt(1, List.class);
				list.add(error);
				return list;
			}
		}).when(minLengthValidator).validate(anyString(), anyList());
		String input = "A";
		Response response = passwordValidatorService.validate(input);
		assertThat(response.getStatus(), is(Status.FAIL));
		assertThat(response.getErrors(), hasItem(error));
	}

	@Test
	public void shouldProduceFailResponseWhenAboveMaximum() {
		final Error error = mock(Error.class);
		doAnswer(new Answer() {
			public Object answer(InvocationOnMock invocation) throws Throwable {
				List list = invocation.getArgumentAt(1, List.class);
				list.add(error);
				return list;
			}
		}).when(maxLengthValidator).validate(anyString(), anyList());
		String input = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		Response response = passwordValidatorService.validate(input);
		assertThat(response.getStatus(), is(Status.FAIL));
		assertThat(response.getErrors(), hasItem(error));
	}
}
