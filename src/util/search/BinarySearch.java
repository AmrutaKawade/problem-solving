package util.search;

public class BinarySearch {
	public static void main(String[] args) {
		int[] array = {1,1,2,2,3,3,3,4};
		int index = binarySearch(array,4,0,array.length);
		System.out.println(index);
	}
	//Gives first occurrence index of key
	private static int binarySearch(int[] array, int key, int start, int end) {
		while(start <= end){
			int mid = (start+end)/2;
			if(array[mid] == key && (mid == 0 || array[mid-1] != key)){
				return mid;
			}
			if(array[mid] >= key){
				end = mid;
			}if(array[mid] < key){
				start = mid;
			}
		}
		return -1;
	}
}
