package util.sorting;

public class QuickSort {
	public static void main(String[] args) {
		int arr[] = {10, 90, 30, 80, 40, 50, 70};
        
		quickSortCenterPivot(arr, 0, arr.length-1);
		printArray(arr);
        
        quickSortRightPivot(arr, 0, arr.length-1);
        printArray(arr);
	}
	
	private static void printArray(int[] arr) {
		System.out.println();
		for(int i:arr){
        	System.out.print(i+" ");
        }
	}

	private static void quickSortRightPivot(int[] arr, int low, int high) {
		if(low < high){
			//Partition 
			int pivot = high;
			int i = low-1;
			for(int j = low; j <= high; j++){
				if(arr[j] < arr[pivot]){
					i++;
					swap(arr, i, j);
				}
			}
			swap(arr,i+1,pivot);
			//Correct position of pivot after partition
			//All elements smaller than pivot are at left side and larger are at right side
			pivot = i+1;
			quickSortRightPivot(arr, low, pivot-1);
			quickSortRightPivot(arr, pivot+1, high);
		}
		
	}

	private static void quickSortCenterPivot(int[] arr, int low, int high) {
		if(low < high){
			int pivot = (int)(low+high)/2;
			int i = low;
			int j = high;
			while(i < j){
				while(arr[i] < arr[pivot]){
					i++;
				}
				while(arr[pivot] < arr[j]){
					j--;
				}
				swap(arr,i,j);
				i++;
				j--;
			}
			quickSortCenterPivot(arr,low,j);
			quickSortCenterPivot(arr,i,high);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
