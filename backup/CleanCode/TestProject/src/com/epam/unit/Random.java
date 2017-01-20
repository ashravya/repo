package com.epam.unit;

import java.util.Scanner;

public class Random {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] a = new int[] { -1, -1, -1, -1, -1};
		System.out.println("Values are not present at positions: ");
		for (int i = 0; i < a.length; i++) {
			if (a[i] == -1)
				System.out.println(i);
		}
		while(true){
			System.out.println("Enter the position at which data is to be inserted: ");
			int pos = Integer.parseInt(s.nextLine());
			a[pos]=Integer.parseInt(s.nextLine());
			System.out.println("Now Values are not present at positions: ");
			for (int i = 0; i < a.length; i++) {
				if (a[i] == -1)
					System.out.println(i);
			}
		}
		
	}
}