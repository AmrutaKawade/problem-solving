package test;
import java.util.Scanner;
//Goldman Sachs CodeSprint
//https://www.hackerrank.com/contests/gs-codesprint/challenges/bank-accounts
public class BankAccount {

    static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
        // Complete this function
    	double fee = 0;
    	for(int i=0;i<p.length;i++){
    		fee += Math.max(k, (double)(p[i]*x)/100);
    	}
    	if(fee > d){
    		return "upfront";
    	}else{
    		return "fee";
    	}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int d = in.nextInt();
            int[] p = new int[n];
            for(int p_i = 0; p_i < n; p_i++){
                p[p_i] = in.nextInt();
            }
            String result = feeOrUpfront(n, k, x, d, p);
            System.out.println(result);
        }
        in.close();
    }
}

