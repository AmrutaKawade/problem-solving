package util.dynamicprogramming;

public class EggDropProblem {
	 public static void main(String[] args) {
		int k = 2;
		int N = 6;
		System.out.println(superEggDrop1(k,N));
	 }
	 
	 //DP solution
	 public static int superEggDrop(int K, int N) {
         int[][] memoization = new int[K+1][N+1];
        
        //number of attempts when only 1 egg is available
        for(int floor=0; floor <= N; floor++){
            memoization[1][floor] = floor;
        }
        
        //number of attempts for 1 floor
        for(int egg=1; egg <= K; egg++){
            memoization[egg][1] = 1;
        }
        //if from xth floor egg is dropped 
        //1: if it breaks, we need to check x-1 floors with egg-1 eggs
        //2: if it doesn't break, we need to check (floor-x) floors with (egg) eggs
        //1+MAX(1,2) = no of attempts for xth floor
        //find floor with min attempts
        int res = 0;
        for(int egg=2; egg <= K; egg++){
            for(int floor=2; floor <= N; floor++){
                memoization[egg][floor] = Integer.MAX_VALUE;
                for(int x=1; x <= floor; x++){
                    res = 1 + Math.max(memoization[egg-1][x-1],memoization[egg][floor-x]);
                    if(res < memoization[egg][floor]){
                        memoization[egg][floor] = res;
                    }
                }
            }
        }
        return memoization[K][N];
    }
	 
	//Optimized
	//fill matrix with max number of floor that can be checked with m attempts and k eggs
	//	 So I consider this problem in a different way:
	//	 dp[M][K]means that, given K eggs and M moves,
	//	 what is the maximum number of floor that we can check.
	//
	//	 The dp equation is:
	//	 dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1,
	//	 which means we take 1 move to a floor,
	//	 if egg breaks, then we can check dp[m - 1][k - 1] floors.
	//	 if egg doesn't breaks, then we can check dp[m - 1][k - 1] floors.
	public static int superEggDrop1(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            ++m;
            for (int k = 1; k <= K; ++k)
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
        }
        return m;
    }
}
