package test;

import java.util.Scanner;
//Given String contains char, numbers, spaces and symbols
//Print numbers in string
//DailyHunt
public class PrintOnlyNumbersFromString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		Integer len = str.length();
        Integer counter = 0;
        while (counter < len - 1) {
            StringBuilder temp = new StringBuilder();
            while (counter < len &&!Character.isDigit(str.charAt(counter))) {
                counter++;
            }
            while (counter < len && Character.isDigit(str.charAt(counter))) {
                temp.append(str.charAt(counter));
                counter++;
            }
            if (temp.length() > 0)
                System.out.println(temp);
        }
    }
}
