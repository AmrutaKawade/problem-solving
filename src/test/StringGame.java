package test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//LenksKart Hiring Challenge 02-02-2018
//100/100
public class StringGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for(int i = 0; i < testCases; i++) {
			String s = in.next();
			Set<Character> charSet = findDistinctCharsInString(s);
			if(charSet.size()%2 == 0) {
				System.out.println("Player2");
			}else {
				System.out.println("Player1");
			}
		}
	}

	private static Set<Character> findDistinctCharsInString(String s) {
		Set<Character> charSet = new HashSet<>();
		for(int i = 0; i < s.length(); i++) {
			charSet.add(s.charAt(i));
		}
		return charSet;
	}
}
