package test;

import java.util.Scanner;
import java.util.TreeSet;
//Here Hiring Challenge - 30-01-2018
public class ConvertArrToPrimeArray {
	
	static TreeSet<Integer> primeNumbers = new TreeSet<Integer>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		calculatePrimeNumbers(100);
		
		int k = in.nextInt();
		int n = in.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.next());
		}
		
		if(isAllArrayElementsPrime(arr, k)) {
			System.out.println(1);
		}else {
			System.out.println(-1);
		}
	}
	//40 Marks
	private static boolean isAllArrayElementsPrime(int[] arr, int k) {
		
		for(int i = 0; i < arr.length; i++) {
			int nearestMaxPrime = primeNumbers.ceiling(arr[i]);
			int nearestMinPrime = arr[i] > 1 ? primeNumbers.floor(arr[i]) : 2;
			
			int diffSub = nearestMaxPrime - arr[i];
			int diffAdd = arr[i] - nearestMinPrime;
			
			if(primeNumbers.contains(arr[i])) {
				continue;
			}
			if((i+k) < arr.length && diffSub != 0 && primeNumbers.contains(arr[i+k]-diffSub)) {
					arr[i] = nearestMaxPrime;	
					arr[i+k] = arr[i+k] - diffSub;
			}else if((i+k) < arr.length && diffAdd != 0 && primeNumbers.contains(arr[i+k] + diffAdd)) {
					arr[i] = nearestMinPrime;
					arr[i+k] = arr[i+k] + diffAdd;
			}else if((i-k) >= 0 && diffSub != 0 && primeNumbers.contains(arr[i-k]- diffSub)) {
					arr[i] = nearestMaxPrime;
					arr[i-k] = arr[i-k] - diffSub;
			}else if((i-k) >= 0 && diffAdd != 0 && primeNumbers.contains(arr[i-k] + diffAdd)) {
					arr[i] = nearestMinPrime;
					arr[i-k] = arr[i-k] + diffAdd;
			}else {
				return false;
			}
		}
		
		return true;
	}
	
	//Calculate Prime Numbers till 100
	private static void calculatePrimeNumbers(int n) {
		for(int i = 2; i <= n; i++) {
			if(isPrime(i)) {
				primeNumbers.add(i);
			}
		}
	}
	
	//Check if number is prime or not
	private static boolean isPrime(int n) {
        if (n <= 1)  return false;
        if (n <= 3)  return true;

        if (n%2 == 0 || n%3 == 0) return false;
     
        for (int i=5; i*i<=n; i=i+6)
            if (n%i == 0 || n%(i+2) == 0)
               return false;
     
        return true;
	}
	  
   /*40 Marks
    * private static boolean isAllArrayElementsPrime(int[] arr, int k) {
		for(int i = 0; i < arr.length; i++) {
			if(primeNumbers.contains(arr[i])) {
				continue;
			}else {
				int nearestMaxPrime = primeNumbers.ceiling(arr[i]);
				int nearestMinPrime = arr[i] > 1 ? primeNumbers.floor(arr[i]) : 2;
				
				int diffSub = nearestMaxPrime - arr[i];
				int diffAdd = arr[i] - nearestMinPrime;
				if((i+k) < arr.length) {
					if(primeNumbers.contains(arr[i+k]-diffSub)) {
						arr[i] = nearestMaxPrime;
						arr[i+k] = arr[i+k] - diffSub;
					}else if(primeNumbers.contains(arr[i+k] + diffAdd)) {
						arr[i] = nearestMinPrime;
						arr[i+k] = arr[i+k] + diffAdd;
					}else {
						return false;
					}
				}else {
					return false;
				} 
			}
		}
		return true;
	}*/
}
