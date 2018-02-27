package test;

import java.util.Scanner;

//LenksKart Hiring Challenge 02-02-2018
//70/100 1-wrong 2-timeout
public class MaxDifferenceInArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for(int i = 0; i < testCases; i++) {
			int len = in.nextInt();
			int[] arr = new int[len];
			
			for(int j = 0; j < len; j++) {
				arr[j] = Integer.parseInt(in.next());	
			}
			System.out.println(calculateMaxMinDifferece(arr));
		}
	}
	private static int calculateMaxMinDifferece(int[] arr) {
		int max = 0;
		int second_max = 0;
		int min = Integer.MAX_VALUE;
		int second_min = Integer.MAX_VALUE;
		
		int max_index = 0;
		int min_index = 0;
		
		for(int j = 0; j < arr.length; j++) {
			if(arr[j] > max) {
				second_max = max;
				max = arr[j];
				max_index = j;
			}else if(second_max < arr[j]  && arr[j] < max) {
				second_max = arr[j];
			}
			if(arr[j] < min) {
				second_min = min;
				min = arr[j];
				min_index = j;
			}else if(second_min > arr[j] && arr[j] > min) {
				second_min = arr[j];
			}
		}
		if(min_index == arr.length-1 && max_index == 0) {
			return Math.max(max-second_min, second_max-min);
		}else {
			return (max-min);
		}
	}
}
