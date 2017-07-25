package util.sorting;

import java.util.Scanner;
/**
 * 
 * @author amruta
 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * Sorting In Place: Yes
 * Stable: Yes
 */
public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < (arr.length-i-1); j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] numbers = in.nextLine().split(" ");

		int[] arr = new int[numbers.length];
        for(int i=0;i < numbers.length;i++){
        	arr[i] = Integer.parseInt(numbers[i]);
        }
        bubbleSort(arr);
        
        for(int i:arr){
        	System.out.println(i);
        }
	}
}
