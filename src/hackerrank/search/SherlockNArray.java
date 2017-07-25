package hackerrank.search;
import java.util.Scanner;
//https://www.hackerrank.com/challenges/sherlock-and-array/problem
public class SherlockNArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for(int j = 0;j <testCases; j++){
			int arrLen = in.nextInt();
			int[] arr = new int[arrLen];
			int sum = 0;
			for(int i=0;i<arrLen;i++){
				arr[i] = in.nextInt();
				sum += arr[i];
			}
            int left = 0;
            int right = sum;
			boolean check = false;
			for(int index = 0;index < arrLen; index++){
                left = (index == 0) ? 0 : left + arr[index-1];
                right = (index == arrLen-1) ? 0 : right - arr[index];
				if(left == right){
					check = true;
				}
			}
			if(check){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}	
		}
	}
}
