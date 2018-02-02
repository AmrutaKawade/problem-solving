package util.strings;

import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/remove-common-characters-and-concatenate/0
public class RemoveCommonChar2Strings {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for(int i = 0; i < testCases; i++) {
			String s1 = in.next();
			String s2 = in.next();
			String output = removeCommonCharacter(s1, s2);
			System.out.println(output);
		}
	}
	//m+n+
	public static String removeCommonCharacter(String s1,String s2){
		int[] alphaArray = new int[26];
		String output2 = "";
		String output1 = s1;
		
		for(int i = 0; i < s1.length(); i++) {
			alphaArray[s1.charAt(i) - 'a']++;
		}
		for(int j = 0; j < s2.length(); j++) {
			if(alphaArray[s2.charAt(j) - 'a'] != 0) {
				//remove from the strings 1
				output1 = output1.replaceAll(String.valueOf(s2.charAt(j)), "");
			}else {
				output2 += s2.charAt(j);
			}
		}
		
		return (output1+output2).equals("") ? "-1" : output1+output2;
	}
}
