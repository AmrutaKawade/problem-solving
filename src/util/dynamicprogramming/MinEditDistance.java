package util.dynamicprogramming;

import java.util.Scanner;

//CA Technologies Hiring Challange 01-02-2018
//70/100
public class MinEditDistance {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		
		System.out.println(getOperations(a,b,a.length(),b.length()));
	}

	private static int getOperations(String a, String b, int m, int n) {
		int dp[][] = new int[m+1][n+1];
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0) {
					dp[i][j] = j;
				}else if(j == 0) {
					dp[i][j] = i;
				}else if (a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
				}
			}
		}
		return dp[m][n];
	}
}
