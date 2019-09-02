package codejam.y2019.qualification;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForegoneSolution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer numberOfTestCases = in.nextInt();
		for (int i = 1; i <= numberOfTestCases; ++i) {
			BigInteger number = in.nextBigInteger();
			List<BigInteger> results = getFourGoneNumbers(number);
			System.out.println("Case #" + i + ": " + results.get(0) + " " + results.get(1));
	    }
	}
	
	private static List<BigInteger> getFourGoneNumbers(BigInteger number) {
		List<BigInteger> result = new ArrayList<>();
		BigInteger num1 = BigInteger.ZERO;
		BigInteger num2 = BigInteger.ZERO;
		String inputNumber = number.toString();
		Integer numLength = inputNumber.length();
		for (int i = 0; i < numLength; i++) {
			char digit = inputNumber.charAt(i);
			if (digit == '4') {
				num1 = num1.add(new BigInteger(getStringNumber((char) (digit - 1), numLength - i)));
				num2 = num2.add(new BigInteger(getStringNumber('1', numLength - i)));
			} else {
				num1 = num1.add(new BigInteger(getStringNumber(digit, numLength - i)));
			}
		}
		result.add(num1);
		result.add(num2);
		return result;
	}
	
	private static String getStringNumber(char digit, int zeroNums) {
		StringBuilder strNum = new StringBuilder("");
		strNum.append(digit);
		for (int i = 1; i < zeroNums; i++) {
			strNum.append("0");
		}
		return strNum.toString();
	}
}


