package util.sorting;

import java.util.Scanner;

/**
 * 
 * @author amruta
 * Time Complexity n^2
 * 
 * arr[] = 64 25 12 22 11
 * Find the minimum element in arr[0...4]
 * and place it at beginning
 * 11 25 12 22 64

 * Find the minimum element in arr[1...4]
 * and place it at beginning of arr[1...4]
 * 11 12 25 22 64

 * Find the minimum element in arr[2...4]
 * and place it at beginning of arr[2...4]
 * 11 12 22 25 64

 * Find the minimum element in arr[3...4]
 * and place it at beginning of arr[3...4]
 * 11 12 22 25 64 
 *
 */
public class SelectionSort {
	public static void selectionSort(int[] arr){
		for(int i=0;i < arr.length;i++){
			int min = i;
			int j = i+1;
			for(j=i+1;j < arr.length;j++){
				if(arr[j] < arr[min]){
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] numbers = in.nextLine().split(" ");

		int[] arr = new int[numbers.length];
        for(int i=0;i < numbers.length;i++){
        	arr[i] = Integer.parseInt(numbers[i]);
        }
        selectionSort(arr);
        
        for(int i:arr){
        	System.out.println(i);
        }
	}
}
