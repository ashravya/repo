package com.epam.unit;

public class PalindromeMain {

	public boolean isPalindrome(String str) {
		
		StringBuffer input = new StringBuffer(str);
		String reverse = input.reverse().toString();

		if (str.toString().equals(reverse)) {
			return true;
		} else {
			return false;
		}
	}
}
