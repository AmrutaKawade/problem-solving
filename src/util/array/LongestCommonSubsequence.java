package util.array;

import java.util.Scanner;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String[] lengths = in.nextLine().split(" ");
		int len1 = Integer.parseInt(lengths[0]);
		int len2 = Integer.parseInt(lengths[1]);
		int[] s1 = new int[len1];
		for(int i = 0; i < len1; i++){
			s1[i] = Integer.parseInt(in.next());
		}
		int[] s2 = new int[len2];
		for(int i = 0; i < len2; i++){
			s2[i] = Integer.parseInt(in.next());
		}
		int L[][] = new int[len1+1][len2+1];
		initializeLookup(L,len1+1,len2+1);
		int lcs = lcs(L,s1,s2,len1,len2);
		//System.out.println(lcs);
		printArr(L, s1, s2, len1, len2);
	}

	private static void initializeLookup(int[][] l, int l1, int l2) {
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				l[i][j] = -1;
			}
		}
	}

	private static int lcs(int[][] lookup, int[] array1, int[] array2, int i, int j) {
		if(i == 0 || j == 0){
			lookup[i][j] = 0;
			return 0;
		}
		if(array1[i-1] == array2[j-1]){
			lookup[i][j] =  (1 + ((lookup[i-1][j-1] == -1) ? lcs(lookup,array1,array2,i-1,j-1) : lookup[i-1][j-1]));
		}else{
			lookup[i][j] = Math.max((lookup[i][j-1] == -1) ? lcs(lookup,array1,array2,i,j-1) : lookup[i][j-1], (lookup[i-1][j] == -1) ? lcs(lookup,array1,array2,i-1,j) : lookup[i-1][j]);
		}
		return lookup[i][j];
	}

	private static void printArr(int[][] L, int[] X, int[]  Y, int m, int n) {
	   int i = m, j = n;
	   int[] lcs = new int[L[m][n]];
	   int index = lcs.length;
	   while (i > 0 && j > 0)
	   {
	      // If current character in X[] and Y are same, then
	      // current character is part of LCS
	      if (X[i-1] == Y[j-1])
	      {
	    	  lcs[index-1] = X[i-1]; 
	          i--; 
	          j--;
	          index--;
	      }
	 
	      // If not same, then find the larger of two and
	      // go in the direction of larger value
	      else if (L[i-1][j] > L[i][j-1])
	         i--;
	      else
	         j--;
	   }
	   for(int k=0; k < lcs.length;k++){
		   System.out.print(lcs[k]+" ");
	   }
	}
}
