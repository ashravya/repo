package com.epam.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JunitMockitoTestCases {
	@Mock
	private List<String> list;

	@Before
	public void setup() {
		when(list.get(anyInt())).thenReturn("A");
	}

	@Test
	public void simpleTestToDemoMockingBehaviors() {
		assertThat(list.get(0), is("A"));
	}

	@Test
	public void simpleTestToDemoMockitoVerificationOnMockedInstance() {
		list.get(0);
		verify(list).get(0);
	}

	@Test
	public void simpleTestToDemoArgumentCaptorForMockedInstance() {
		ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
		String output = list.get(99);
		verify(list).get(argumentCaptor.capture());
		assertThat(output, is("A"));
		assertThat(argumentCaptor.getValue(), is(99));
	}
}
