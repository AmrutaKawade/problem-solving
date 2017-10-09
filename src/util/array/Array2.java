package util.array;
/*
 * Input:  arr[] = {10, 20, 60, 40, 50, 30}  
 * //30 and 60 are swapped
 * Output: arr[] = {10, 20, 30, 40, 50, 60}
 * 
 * Input:  arr[] = {10, 20, 40, 30, 50, 60}  
 * //30 and 40 are swapped
 * Output: arr[] = {10, 20, 30, 40, 50, 60}
 * 
 * Input:   arr[] = {1, 5, 3}
 * //3 and 5 are swapped
 * Output:  arr[] = {1, 3, 5}
 * */
public class Array2 {
	public static void main(String[] args) {
		//int arr[] = {10, 20, 60, 40, 50, 30};
		//int arr[] = {10, 20, 40, 30, 50, 60};
		int arr[] = {1, 5, 3};
		sortArray(arr);
		System.out.println(arr.toString());
	}
	public static void sortArray(int[] arr){
		int j = 0;
		for(int i=1; i<arr.length; i++){
			if(arr[i-1] > arr[i]){
				j = i-1;
				break;
			}
		}
		int k=0;
		for(int i=arr.length-1; i > j; i--){
			if(arr[i-1] > arr[i]){
				k = i;
				break;
			}
		}
		System.out.println(j+""+k);
		int temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
	}
}
