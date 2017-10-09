package hackerrank.dynamicprogramming;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SamAndSubStrings {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		BigInteger sum = null;
		
		sum = getCandies(input);
		System.out.println(sum);
	}

	private static BigInteger getCandies(String input){
		BigInteger sumTable[] = new BigInteger[input.length()];
		sumTable[0] = new BigInteger(String.valueOf(input.charAt(0)));
		BigInteger sum = sumTable[0];
		for(int i = 1; i < input.length(); i++){
			sumTable[i] = ((new BigInteger(String.valueOf(input.charAt(i))).multiply(new BigInteger(String.valueOf(i)).add(BigInteger.ONE))).add(sumTable[i-1].multiply(BigInteger.TEN))).mod(BigInteger.TEN.pow(9).add(new BigInteger("7")));
			sum = sum.add(sumTable[i]).mod(BigInteger.TEN.pow(9).add(new BigInteger("7")));
		}
		return sum;
	}
}
