package test;
//Pramati
public class FindMaxDifference {
	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		System.out.println(findMaxDifference(arr));
	}

	private static int findMaxDifference(int[] arr) {
		Integer max_so_far = Integer.MIN_VALUE;
		for(int i = 1; i < arr.length; i++){
			Integer max = Integer.MIN_VALUE;
			for(int j = 0; j < i; j++){
				int temp = arr[i]-arr[j];
				if(temp > max){
					max = temp;
				}
			}
			if(max > max_so_far){
				max_so_far = max;
			}
		}
		return max_so_far;
	}
}
