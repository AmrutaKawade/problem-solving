package contest.techgig;

import java.util.Arrays;
import java.util.Scanner;

public class GeekGoddess2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arrayLen = in.nextInt();
		int arr[] = new int[arrayLen];
		for(int i = 0; i < arrayLen; i++){
			arr[i] = in.nextInt();
		}
		int output[] = printMinCostArray(arr);
		System.out.println(output);
	}

	private static int[] printMinCostArray(int[] arr) {
		int[] output = null;
		if(arr.length == 1){
			output = new int[1];
			output[0] = 0;
		}else{
			output = new int[arr.length-1];
			Arrays.sort(arr);
			int sum = arr[0];
			for(int i = 1; i < arr.length; i++){
				sum += arr[i];
				output[i-1] = sum;
			}
		}
		return output;
	}
}