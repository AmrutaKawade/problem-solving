package util.sorting;

import java.util.Scanner;

/**
 * 
 * @author amruta
 * Time Complexity: O(n*n)
 * Auxiliary Space: O(1)
 * Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.
 * Algorithmic Paradigm: Incremental Approach
 * Sorting In Place: Yes
 * Stable: Yes
 * 
 */
public class InsertionSort {
	public static void insertionSort(int[] arr){
		for(int i=1;i<arr.length;i++){
			int key = arr[i];
			int j = i-1;
			while(j >= 0 && key < arr[j]){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] numbers = in.nextLine().split(" ");

		int[] arr = new int[numbers.length];
        for(int i=0;i < numbers.length;i++){
        	arr[i] = Integer.parseInt(numbers[i]);
        }
        insertionSort(arr);
        
        for(int i:arr){
        	System.out.println(i);
        }
	}
}
