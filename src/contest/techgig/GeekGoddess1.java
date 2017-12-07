package contest.techgig;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//Longest palindromic subsequence
//Input : 12345453897
//Output: 6 (345453 after reshuffling forms palindrome)
public class GeekGoddess1 {
	static int count = 0;
	
	static String str = null;
	static int[] dp = null;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		str = in.next();
		
		dp = new int[str.length()];
		
		System.out.println(lengthofPalindrome(str));
		//System.out.println(count);
	}
	
	//Dynamic Programming O(n)
	private static int lengthofPalindrome(String str) {
		int i = 1;
		int j = 1;
		dp[0] = 0;
		while(i < str.length() && j >= 0){
			int k = 1;
			while(j-k >= 0 && i+k <= str.length()){
				count++;
				dp[i] = Math.max(dp[i], dp[i-1]);
				if(str.substring(j-k,j).equals(str.substring(i,i+k))){
					dp[i+k-1] = dp[i]+(str.substring(j-k,j).length())*2;
					i = i+k;
					j = j-k;
					k = 1;
				}else{				
					j = i;
					k++;
				}
			}
			j++;
			i++;
		}
		return dp[str.length()-1];
	}
	
	//Naive n^2
	/*private static int lengthofPalindrome(String str) {
		//int[][] lps = new int[str.length()][str.length()];
		int max = 0;
		for(int i = 0; i < str.length(); i++){
			for(int j = i+1; j <= str.length(); j++){
				count++;
				int count = isPalindrome(str.substring(i,j));
				if(count > max){
					max = count;
				}
			}
		}
		return max;
	}
	private static int isPalindrome(String input){
		//System.out.println(input);
		count += input.length()-1;
		Set<Integer> num = new HashSet<Integer>();
		int count = 0;
		for(int i = 0; i < input.length(); i++){
			int number = Integer.valueOf(input.charAt(i));
			if(!num.add(number)){
				num.remove(number);
				count += 2;
			}
		}
		return count;
	}*/
	
	//Recurrsive 2^n
	/*public static int lengthofPalindrome(String input)
    {   count++;
		//System.out.println(input);
		if(input == ""){
			return 0;
		}
		Set<Integer> num = new HashSet<Integer>();
		int count = 0;
		for(int i = 0; i < input.length(); i++){
			int number = Integer.valueOf(input.charAt(i));
			if(!num.add(number)){
				num.remove(number);
				count += 2;
			}
		}
		if(num.isEmpty()){
			return count;
		}else{
			return Math.max(lengthofPalindrome(input.substring(0,input.length()-1)),lengthofPalindrome(input.substring(1,input.length())));
		}
    }*/
}