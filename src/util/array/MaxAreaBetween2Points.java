package util.array;

public class MaxAreaBetween2Points {
	public static void main(String[] args) {
		int[] array = {1,8,6,2,5,4,8,3,7};
		int[] tap = {0,1,0,2,1,0,1,3,2,1,2,1};
		//System.out.println(maxArea(array));	
		System.out.println(trap(tap));
	}
	
	public static int maxArea(int[] height) {
		int[] dp = new int[height.length];
		for(int i = 1; i < height.length; i++) {
			int max_sofar = 0;
			for(int j = 0; j < i; j++) {
				int area =  (i-j)*(Math.min(height[i],height[j]));
				max_sofar = Math.max(area,max_sofar);
			}
			dp[i] = Math.max(dp[i-1],max_sofar);
		}
		return dp[dp.length-1];
    }
	
	public static int trap(int[] height) {
		if(height.length == 0){
            return 0;
        }
		int[] left_max = new int[height.length];
		int[] right_max = new int[height.length];
		left_max[0] = height[0]; 
		for(int i = 1; i < left_max.length; i++) {
			left_max[i] = Math.max(height[i],left_max[i-1]);
		}
		right_max[height.length-1] = height[height.length-1];
		for(int i = right_max.length-2; i >= 0; i--) {
			right_max[i] = Math.max(height[i],right_max[i+1]);
		}
		int ans = 0;
		for(int i = 0; i < height.length; i++) {
			ans += Math.min(left_max[i],right_max[i]) - height[i];
		}
		return ans;
    }
}
