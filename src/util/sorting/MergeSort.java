package util.sorting;

import java.util.Scanner;
/**
 * 
 * @author amruta
 * Stable
 * Time Complexity nlogn
 */
public class MergeSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] numbers = in.nextLine().split(" ");

		int[] arr = new int[numbers.length];
        for(int i=0;i < numbers.length;i++){
        	arr[i] = Integer.parseInt(numbers[i]);
        }
        
        mergeSort(arr, 0, arr.length-1);
        for(int i:arr){
        	System.out.println(i);
        }
	}
	private static void mergeSort(int[] arr,int start,int end){
		if(start < end){
			int mid = (int)(start+end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr,start,mid,end);
		}
	}
	private static void merge(int[] arr, int start, int mid, int end) {
		int[] b = new int[arr.length];
		int i = start;
		int j = mid+1;
		int k = 0;
		while(i <= mid && j <= end){
			if(arr[i] <= arr[j]){
				b[k] = arr[i];
				i++;
				k++;
			}
			if(arr[i] > arr[j]){
				b[k] = arr[j];
				j++;
				k++;
			}
		}
		while( i <= mid){
			b[k] = arr[i];
			i++;
			k++;
		}
		while( j <= end){
			b[k] = arr[j];
			j++;
			k++;
		}
		for(int l = end;l>=start;l--){
			arr[l] = b[--k];
		}
	}
}
