package com.epam.unit;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class NewTest {

	String expected, actual;
	StringBuffer s2;

	@Test
	public void notANullString() {
		try {
			StringBuffer input = new StringBuffer(null);
			input.reverse();
		} catch (NullPointerException e) {
			System.out.println("Not Accepting Null values");
		}
	}

	@Test
	public void reverse() {
		expected = "abc";
		s2 = new StringBuffer("cba");
		actual = s2.reverse().toString();
		AssertJUnit.assertEquals(expected, actual);
		System.out.println("reversing() :is working");
	}

	/*@Test
	public void convertUpperCaseToLowerCase() {
		expected = "ShrAvYa";
		s2 = new StringBuffer("sHRaVyA");
		actual = s2.reverse().toString();
		AssertJUnit.assertEquals(expected, actual);
		System.out.println("reversingUpperCaseAndLowerCase() :is working");
		System.out.println("\n\n\n\n\n\n");
	}
*/
	@Test
	public void reverseEmptyString() {
		expected = "";
		s2 = new StringBuffer("");
		actual = s2.reverse().toString();
		AssertJUnit.assertEquals(expected, actual);
		System.out.println("reversingEmptyString() :is working");
	}

	@Test
	public void reverseSpaceSeparatedStrings() {
		expected = "sh ravya";
		s2 = new StringBuffer("ayvar hs");
		actual = s2.reverse().toString();
		AssertJUnit.assertEquals(expected, actual);
		System.out.println("reversingSpaceSeparatedStrings() :is working");
	}

	@Test
	public void maintainingLength() {
		expected = "sh ravya";
		int expected_length = expected.length();
		s2 = new StringBuffer("ayvar sh");
		actual = s2.reverse().toString();
		int actual_length = actual.length();
		AssertJUnit.assertEquals(expected_length, actual_length);
		System.out.println("maintainingLength() :is working");
	}

	@Test
	public void returningString() {
		expected = "sh ravya";
		s2 = new StringBuffer("ayvar sh");
		actual = s2.reverse().toString();
		AssertJUnit.assertEquals(expected.getClass().getName(), actual.getClass().getName());
		System.out.println("returningString() :is working");
	}

}
