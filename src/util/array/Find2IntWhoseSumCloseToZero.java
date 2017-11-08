package util.array;

import java.util.Arrays;

public class Find2IntWhoseSumCloseToZero {
	public static void main(String[] args) {
		int[] array = {-85, -3, -2, -1, 4, 5, 85};
		findTwoIntegersWhoseSumIsClosestToZero(array);
	}
	public static void findTwoIntegersWhoseSumIsClosestToZero(int[] array){
		//Sort Array
		Arrays.sort(array);
		int i = 0;
		int j = array.length-1;
		int min_sum = Integer.MAX_VALUE;
		int sum = 0;
		int min_i = 0;
		int min_j = 0;
		while( i < j){
			sum = array[i] + array[j];
			if(getAbsoluteDifference(sum) < min_sum){
				min_sum = sum;
				min_i = i;
				min_j = j;
			}
			if(sum >= 0){
				j--;
			}else{
				i++;
			}
		}
		System.out.println("Elements are: "+array[min_i]+" & "+array[min_j]);
	}
	private static int getAbsoluteDifference(int min_sum) {
		return Math.abs(min_sum) - 0;
	}
}
