package test;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Given String contains char, numbers and symbols
//Take array of length 26
//set character count
//String a = "abcaz"
//Output[] = [2,1,1,0,0,0,....,0]
//DailyHunt
public class CountAlphabatesInString {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        countAlphabets(s);
    }

    private static void countAlphabets(String str) {
        Integer len = str.length();
        Integer counter = 0;
        List<BigInteger> alphaCount = new ArrayList<>(26);
        initializeList(alphaCount);
        while (counter < len) {
            if (Character.isLetter(str.charAt(counter))) {
                populateAlphaCounter(alphaCount, str.charAt(counter));
            }
            counter++;
        }
        printList(alphaCount);
    }

    private static void printList(List<BigInteger> alphaCount) {
        int size = alphaCount.size();
        for (int i = 0 ; i < size ; i++) {
            System.out.print(alphaCount.get(i));
            if (i != size -1)
                System.out.print(" ");
        }
        
    }

    private static void initializeList(List<BigInteger> alphaCount) {
        for (int i = 0; i < 26; i++) {
            alphaCount.add(new BigInteger("0"));
        }
        
    }

    private static void populateAlphaCounter(List<BigInteger> alphaCount, Character inputChar) {
        
        if(isSmallCase(inputChar)) {
            alphaCount.set(inputChar - 'a', alphaCount.get(inputChar - 'a').add(BigInteger.ONE));
        } else {
            alphaCount.set(inputChar - 'A', alphaCount.get(inputChar - 'A').add(BigInteger.ONE));
        }
        
    }

    private static boolean isSmallCase(Character inputChar) {
        
        if (inputChar >= 'a' && inputChar <= 'z')
            return true;
        return false;
    }
}
