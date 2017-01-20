package com.epam.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class JunitStructure {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Rule
	public Timeout timeout = Timeout.millis(1000);

	@BeforeClass
	public static void beforeInit() {
		// Before All Tests
	}

	@AfterClass
	public static void afterInit() {
		// After All Tests
	}

	@Before
	public void setUp() {
		// Before Each Test
	}

	@After
	public void tearDown() {
		// After Each Test
	}

	@Test
	public void simpleJUnitTestCase() {
		Assert.assertTrue("Should be True", true);
	}

	@Test(timeout = 1000)
	public void simpleJUnitTestCaseWithTimeOut() {
		try {
			Thread.sleep(999);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void simpleJUnitTestCaseWithTimeOutRule() {
		try {
			TimeUnit.MILLISECONDS.sleep(1001);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = Exception.class)
	public void simpleJUnitTestCaseToCheckException() {
		throw new RuntimeException();
	}

	@Test
	public void simpleJUnitTestCaseToCheckExceptionWithRule() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("I am a RunTime Error");
		throw new RuntimeException("I am a RunTime Error");
	}

	@Test
	public void simpleAssertsForJUnits() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		Assert.assertEquals(10, 10);
		Assert.assertNotEquals(10, 9);
	}

	@Test
	public void matcherBasedAssertsForJUnitTestCases() {
		assertThat(1, is(1));
		assertThat(new ArrayList<String>(), is(emptyCollectionOf(String.class)));
		assertThat(new ArrayList<String>(), is(empty()));
	}

	@Test
	public void collectionContainsHamcrestMatcherBasedAssertsForJUnitTestCases() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		assertThat(list, contains("A", "B", "C"));
	}

	@Test
	public void collectionHasItemsHamcrestMatcherBasedAssertsForJUnitTestCases() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		assertThat(list, hasItems("A"));
		assertThat(list, hasItems("A", "B"));
		assertThat(list, hasItems("A", "B", "C"));
	}
}
