package util.array;

import java.util.Scanner;

public class LongestIncreasingSubsquence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arrLen = Integer.parseInt(in.next());
		int[] array = new int[arrLen];	
		for(int i=0; i<arrLen; i++){
			array[i] = Integer.parseInt(in.next());
		}
		int[] lis = new int[arrLen];
		initialiseArray(lis);
		int lisLen = longestIncreasingSubsequence(array);
		System.out.println(lisLen);
	}

	private static void initialiseArray(int[] array) {
		for(int i=0; i < array.length;i++){
			array[i] = 1;
		}
	}
	private static void print(int[] array, int len){
		for(int i=0; i < len;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	private static int ceilIndex(int input[], int T[], int end, int s){
        int start = 0;
        int middle;
        int len = end;
        while(start <= end){
            middle = (start + end)/2;
            if(middle < len && input[T[middle]] < s && s <= input[T[middle+1]]){
                return middle+1;
            }else if(input[T[middle]] < s){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return end;
	 }
	    
	 public static int longestIncreasingSubsequence(int input[]){
	        int T[] = new int[input.length];
	        int R[] = new int[input.length];
	        for(int i=0; i < R.length ; i++) {
	            R[i] = -1;
	        }
	        T[0] = 0;
	        int len = 0;
	    try{
	        for(int i=1; i < input.length; i++){
	            if(input[T[0]] >= input[i]){ //if input[i] is less than 0th value of T then replace it there.
	                T[0] = i;
	            }else if(input[T[len]] <= input[i]){ //if input[i] is greater than last value of T then append it in T
	                len++;
	                T[len] = i;
	                R[T[len]] = T[len-1];
	            }else{ //do a binary search to find ceiling of input[i] and put it there.
	                int index = ceilIndex(input, T, len,input[i]);
	                T[index] = i;
	                R[T[index]] = T[index-1];
	            }
	        }
	    }catch(Exception e){
	    	print(T,len);
	    }

	        //this prints increasing subsequence in reverse order.
	        /*System.out.print("Longest increasing subsequence ");
	        int index = T[len];
	        while(index != -1) {
	            System.out.print(input[index] + " ");
	            index = R[index];
	        }

	        System.out.println();*/
	        return len+1;
	    }
}
