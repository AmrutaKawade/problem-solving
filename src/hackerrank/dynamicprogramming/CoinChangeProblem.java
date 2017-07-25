package hackerrank.dynamicprogramming;
import java.util.Arrays;
import java.util.Scanner;

/*Sample Input 0

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
	    static long getWays(long n, long[] c){
	    	long[] table = new long[(int) (n+1)];
	    	 
	        // Initialize all table values as 0
	        Arrays.fill(table, 0);   //O(n)
	 
	        // Base case (If given value is 0)
	        table[0] = 1;
	 
	        // Pick all coins one by one and update the table[]
	        // values after the index greater than or equal to
	        // the value of the picked coin
	        for (int i=0; i< c.length; i++)
	            for (int j=(int) c[i]; j<=n; j++)
	                table[j] += table[(int) (j-c[i])];
	    	return table[(int) n]; 
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
