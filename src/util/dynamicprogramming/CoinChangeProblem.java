package util.dynamicprogramming;
import java.util.Arrays;
import java.util.Scanner;

/* https://www.hackerrank.com/challenges/coin-change/problem
 * Sample Input 0
4 3
1 2 3

Sample Output 0

4

Explanation 0

There are four ways to make change for n= 4 using coins with values given by c = [1,2,3]:
{1,1,1,1}
{1,1,2}
{2,2}
{3,1}
Thus, we print 4 as our answer.
*/
public class CoinChangeProblem {
	    static int getWays(long n, long[] c){
	    	int[] coinChange = new int[(int)n+1];
	    	coinChange[0] = 1;
	    	for(int coin = 0; coin < c.length; coin++){
	    		for(int i = (int) c[coin]; i < coinChange.length; i++){    		
	    			coinChange[i] = coinChange[i] + coinChange[(int) (i-c[coin])];
	    		}
	    	}
	    	return coinChange[(int)n];
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        //size of array of coins
	        int m = in.nextInt();
	        
	        long[] c = new long[m];
	        for(int c_i=0; c_i < m; c_i++){
	            c[c_i] = in.nextLong();
	        }
	        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
	        long ways = getWays(n, c);
	        System.out.println(ways);
	    }
}
