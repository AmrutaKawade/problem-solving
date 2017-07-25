package hackerrank.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/* https://www.hackerrank.com/challenges/equal/problem
 * For every operation, she can choose one of her colleagues and can do one of the three things.
She can give one chocolate to every colleague other than chosen one.
She can give two chocolates to every colleague other than chosen one.
She can give five chocolates to every colleague other than chosen one.

Calculate minimum number of such operations needed to ensure that every colleague has the same number of chocolates. 

Sample Input

1
4
2 2 3 7

Sample Output

2

Explanation

1st operation: Christy increases all elements by 1 except 3rd one
2 2 3 7 -> 3 3 3 8
2nd operation: Christy increases all element by 5 except last one
3 3 3 8 -> 8 8 8 8
*/

public class Equal {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        //TestCases
		int t = in.nextInt();
		for (int i = 0;i < t; i++){
			//colleagues
	        int n = in.nextInt();
	        //Chocolates each colleague have
	        int[] c = new int[n];
	        for(int c_i=0; c_i < n; c_i++){
	            c[c_i] = in.nextInt();
	        }
	        int noOfOps = getOperations(c);
	        System.out.println(noOfOps);
		}
	}

	private static int getOperations(int[] c) {
		Arrays.sort(c);
		int min = 10000*1000;
		for(int j = -3; j <= c[0]; j++){
			int ops = 0;
			for(int i = 0; i < c.length; i++){
				ops += ((c[i]-j)/5 + ((c[i]-j)%5)/2 + (((c[i]-j)%5)%2)/1);
			}
			if(ops < min){
				min = ops;
			}
		}
		return min;
	}
}
