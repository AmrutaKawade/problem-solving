package util.array;

public class ProductExceptItSelf {
	public static void main(String[] args) {
		int[] product = {1,2,3,4};
		System.out.println(productExceptSelf(product));
	}
	public static int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];
        if(nums.length == 0){
            return output;
        }
		int[] left_product = new int[nums.length];
		int[] right_product = new int[nums.length];
		left_product[0] = 1; 
		for(int i = 1; i < left_product.length; i++) {
			left_product[i] = nums[i-1]*left_product[i-1];
		}
		right_product[nums.length-1] = 1;
		for(int i = right_product.length-2; i >= 0; i--) {
			right_product[i] = nums[i+1]*right_product[i+1];
		}
		for(int i = 0; i < nums.length; i++) {
			output[i] += left_product[i]*right_product[i];
		}
		return output;
    }
}
