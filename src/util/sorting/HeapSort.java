package util.sorting;

import java.util.Scanner;
/**
 * 
 * @author amruta
 * Not Stable
 * Time Complexity : nlogn
 * 
 */
public class HeapSort {
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
	public static void sort(int[] arr,int n){
		
		//Build Heap
		for(int i = (n/2)-1; i >= 0; i--){
			//This will move largest element to the start
			heapify(arr,n,i);
		}
		
		for(int i = n-1; i >=0; i--){
			//Move largest element at the start to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			//This will move largest element to the start
			heapify(arr, i, 0);
		}
	}
	public static void heapify(int arr[],int n,int i){
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if(l < n && arr[l] > arr[largest]){
			largest = l;
		}
		if(r < n && arr[r] > arr[largest]){
			largest = r;
		}
		if(largest != i){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr,n,largest);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split(" ");
		
		int n = s.length;
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(s[i]);
		}
		printArray(arr);
		sort(arr,n);
		printArray(arr);
	}
}
