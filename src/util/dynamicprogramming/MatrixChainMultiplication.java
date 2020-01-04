package util.dynamicprogramming;

import java.util.Scanner;

//https://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
//DP
//https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication/0
//Input
//1
//15
//488 357 244 492 228 366 360 437 433 52 438 229 276 408 475
//Ouput
//91364572

public class MatrixChainMultiplication {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for(int i = 0; i < testCases; i++) {
			int len = in.nextInt();
			int p[] = new int[len];
			for(int j = 0; j < len; j++) {
				p[j] = in.nextInt();
			}
			System.out.println(minCostOfMatrixMultiplication(p));
		}
	}

	private static int minCostOfMatrixMultiplication(int p[]) {
		//number matrices
		int n = p.length - 1;
		//DP matrix
		int dp[][] = new int[n][n];
		
		
		//Traverse DP matrix diagonally up
		int iP = n;
		int jP = 0;
		
		while(iP >= 0 && jP < n) {
			int i = 0;
			int j = jP;
			while(i < iP) {
				if(i == j) {
					dp[i][j] = 0;
				}else {
					dp[i][j] = Integer.MAX_VALUE;
					int sum = 0;
					for(int k = i; k < j; k++) {
						sum = dp[i][k] + dp[k+1][j] + p[i]*p[k+1]*p[j+1];
						if(sum < dp[i][j]) {
							dp[i][j] = sum;
						}
					}
				}
				i++;
				j++;
			}
			iP--;
			jP++;
		}
		return dp[iP][jP-1];
	}
}
