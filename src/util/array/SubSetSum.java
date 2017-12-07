package util.array;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {
	private static List<Integer> solution = new ArrayList<>();
    
    static void getSolution(boolean[][] part, int[] arr, int i, int j) {
        if(!part[i][j] || i==0)
            return;

        if(part[i][j-1])
            getSolution(part,arr,i,j-1);
        else {
            getSolution(part,arr,i-arr[j-1],j-1);
            solution.add(arr[j-1]);
        }
    }

    static List<Integer> getSubsetSum(int[] arr, int sum) {
    	
        int n = arr.length;

        boolean[][] part = new boolean[sum+1][n+1];

        for(int i=1;i<sum+1;i++)
            part[i][0] = false;

        for(int j=0;j<n+1;j++)
            part[0][j] = true;

        for(int i=1;i<sum+1;i++) {
            for(int j=1;j<n+1;j++) {
                part[i][j] = part[i][j-1];
                if(i >= arr[j-1])
                    part[i][j] = part[i][j] || part[i-arr[j-1]][j-1];
            }
        }
        
        while(sum > 0 && !part[sum][n])
            sum--;
        if(sum > 0)
            getSolution(part,arr,sum,n);
        else
            return null;

        return solution;
    }

    static void printArray(List<Integer> arr) {
        for(Integer i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {     
    	int[] arr = {3, 34, 4, 12, 5, 2};
    	List<Integer> tempSol = getSubsetSum(arr,9);
    	printArray(tempSol);
    }
}
