package util.dynamicprogramming;
/*Given an array of elements with size n. find maximum product contagious subarray
 * Input: arr[] = {6, -3, -10, 0, 2}
 * Output:   180  // The subarray is {6, -3, -10}
 * 
 * Input: arr[] = {-1, -3, -10, 0, 60}
 * Output:   60  // The subarray is {60}
 * 
 * Input: arr[] = {-2, -3, 0, -2, -40}
 * Output:   80  // The subarray is {-2, -40}
 * 
 * 1. You can get maximum product by multiplying the current element with 
    maximum product calculated so far.  (might work when current 
    element is positive).
   2. You can get maximum product by multiplying the current element with 
    minimum product calculated so far. (might work when current 
    element is negative).
   3. Current element might be a starting position for maximum product sub
     array
   
    so you have to maintain 
    max_ending_here = Max(max_ending_here*element, min_ending_here*element, element)
    min_ending_here = Min(max_ending_here*element, min_ending_here*element, element)
*/
public class MaximumProductSubarray {
	public static void main(String[] args) {
		//int[] arr = {6, -3, -10, 0, 2};
		//int[] arr = {-1, -3, -10, 0, 60};
		//int[] arr = {-2, -3, 0, -2, -40};
		int[] arr = {-2, -40, -1};
		int output = getMaxProduct(arr);
		System.out.println(output);
	}
	public static int getMaxProduct(int[] arr){
		// max positive product ending at the current position
	    int max_ending_here = arr[0];
	 
	    // min negative product ending at the current position
	    int min_ending_here = arr[0];
	 
	    // Initialize overall max product
	    int max_so_far = arr[0];
	 
	    //Traverse through the array.
	    for (int i = 1; i < arr.length; i++)
	    {
	        int temp1 = max_ending_here;
	        int temp2 = min_ending_here;
	        max_ending_here = Math.max(temp1*arr[i], Math.max(temp2*arr[i], arr[i]));
	        min_ending_here = Math.min(temp1*arr[i], Math.min(temp2*arr[i], arr[i]));
	        
	        // update max_so_far, if needed
	        if (max_so_far <  max_ending_here)
	          max_so_far  =  max_ending_here;
	    }
	 
	    return max_so_far;
	}
	public static int getMaxProduct2(int[] arr){
		int max_ending_here = 1;
		int max_so_far = 0;
		for(int i = 0; i < arr.length; i++){
			max_ending_here = max_ending_here*arr[i];
			max_ending_here = (max_ending_here == 0) ? 1 : max_ending_here;
			if(max_ending_here > max_so_far){
				max_so_far = max_ending_here;
			}
		}
		return max_so_far;
	}
}
