package hackerrank.dynamicprogramming;

import java.util.Scanner;
//https://www.hackerrank.com/challenges/string-reduction/problem
/*
 * Given a string consisting of letters, 'a', 'b' and 'c', we can perform the following operation:
 * Take any two adjacent distinct characters and replace them with the third character.
 * For example, if 'a' and 'c' are adjacent, they can replaced by 'b'.
 * Find the smallest string which we can obtain by applying this operation repeatedly.
*/
public class StringReduction {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int testCases = in.nextInt();
	    for(int i = 0; i < testCases; i++){
	    	String input = in.next();
	    	int countA = 0;
	    	int countB = 0;
	    	int countC = 0;
	    	for(int j=0;j < input.length();j++){
	    		if(input.charAt(j) == 'a'){
	    			countA++;
	    		}if(input.charAt(j) == 'b'){
	    			countB++;
	    		}if(input.charAt(j) == 'c'){
	    			countC++;
	    		}
	    	}
	    	if(countA==0 && countB==0){
	    		System.out.println(countC);
	    	}
	    	else if(countB==0 && countC==0){
	    		System.out.println(countA);
	    	}
	    	else if(countC==0 && countA==0){
	    		System.out.println(countB);
	    	}
	    	else if(countA%2==0){
	    		//countA is even
	    		if(countB%2==0){
	    			//countB is even
	    			if(countC%2==0){
	    				System.out.println(2);
	    			}else{
	    				System.out.println(1);
	    			}
	    		}else{
	    			//CountB is Odd
	    			System.out.println(1);
	    		}
	    	}else{
	    		//countA is odd
	    		if(countB%2==0){
	    			//countB is even
	    			System.out.println(1);
	    		}else{
	    			//CountB is Odd
	    			if(countC%2==0){
	    				System.out.println(1);
	    			}else{
	    				System.out.println(2);
	    			}
	    		}
	    	}
	    }
	}
}
