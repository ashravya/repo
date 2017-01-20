package com.epam.unit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.ISuiteParser;

public class PalindromeTest {
	
	/*@Test
	public void convertToArray() {
		String str = string.toString();
		char[] charArray = str.toCharArray();
		for (int position = 0; position < charArray.length; position++) {
			System.out.println(charArray[position]);
		}
	}*/
	
	@Test
	public void testDataTypeString()
	{
		PalindromeMain palindromeMainObject=new PalindromeMain();
		boolean isPalindrome=palindromeMainObject.isPalindrome("redivider");
		Assert.assertTrue(isPalindrome);
	}
}
