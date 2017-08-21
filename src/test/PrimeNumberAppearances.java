package test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
//Goldman Sachs
//Find Largest Number which occurred prime number of times and more than or equal to minOccurences given
public class PrimeNumberAppearances {
	//static int primeNumbers[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
	
	static int getLargestNumberWithPrimeOccurences(int[] inputArray, int minOccurence) {
		Arrays.sort(inputArray);
		int count = 1;
		for(int i = (inputArray.length-1); i > 0; i--){
			if(inputArray[i] == inputArray[i-1]){
				count++;
			}else{
				if(isPrime(count) && count >= minOccurence){
					return inputArray[i];
				}
				count = 1;
			}
		}
		if(isPrime(count) && count >= minOccurence){
			return inputArray[0];
		}
		return -1;
    }
	private static boolean isPrime(int count) {  
		int m=count/2;    
		for(int i=2;i<=m;i++){    
		   if(count%i==0){    
			   return false;
		   }    
		}    
		return true;
		/*if(Arrays.binarySearch(primeNumbers, count) != -1){
			return true;
		}
		return false;*/
	}
	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        /*final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }*/

        int res;
        int inputArray_size = 0;
        inputArray_size = Integer.parseInt(in.nextLine().trim());

        int[] inputArray = new int[inputArray_size];
        for(int i = 0; i < inputArray_size; i++) {
            int inputArray_item;
            inputArray_item = Integer.parseInt(in.nextLine().trim());
            inputArray[i] = inputArray_item;
        }

        int minOccurence;
        minOccurence = Integer.parseInt(in.nextLine().trim());

        res = getLargestNumberWithPrimeOccurences(inputArray, minOccurence);
        System.out.println(res);
        /*bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();*/
    }
}
