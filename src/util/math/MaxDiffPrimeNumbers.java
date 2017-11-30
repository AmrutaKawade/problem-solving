package util.math;

import java.util.Scanner;
//codiva
//Given range 2-10^6 find max difference of prime numbers
public class MaxDiffPrimeNumbers {
	static int maxDifference(int startVal, int endVal) {
       int i = startVal;
       int j = endVal;
       while(j >= i){
    	   boolean iIsPrime = isPrime(i);
    	   boolean jIsPrime = isPrime(j);
    	   if(iIsPrime && jIsPrime){
    		   return j-i;
    	   }else if(iIsPrime){
    		   j--;
    	   }else if(jIsPrime){
    		   i++;
    	   }else{
    		   i++;
    		   j--;
    	   }
       }
       return 0;
    }

    private static boolean isPrime(int n) {
        if (n <= 1)  return false;
        if (n <= 3)  return true;

        if (n%2 == 0 || n%3 == 0) return false;
     
        for (int i=5; i*i<=n; i=i+6)
            if (n%i == 0 || n%(i+2) == 0)
               return false;
     
        return true;
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int startVal = in.nextInt();
            int endVal = in.nextInt();
            int result = maxDifference(startVal, endVal);
            System.out.println(result);
        }
        in.close();
    }
}
