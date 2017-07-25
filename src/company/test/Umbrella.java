package company.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
//dataxu
public class Umbrella {
	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int res;
        int _n;
        //Number of people to shelter
        _n = Integer.parseInt(in.nextLine().trim());

        int _p_size = 0;
        //Types of umbrellas
        _p_size = Integer.parseInt(in.nextLine().trim());
        int[] _p = new int[_p_size];
        //No of people that one umbrella can cover
        int _p_item;
        for (int _p_i = 0; _p_i < _p_size; _p_i++) {
            _p_item = Integer.parseInt(in.nextLine().trim());
            _p[_p_i] = _p_item;
        }
        //get Number of umbrellas required to cover n people
        //Example 1 : n=8 p=[8,3,5] ans = 1
        //Example 2 : n=4 p=[5] ans = -1, exact match required
        res = getUmbrellas(_n, _p);
        System.out.println(res);
    }

    static int getUmbrellas(int n, int[] p) {
    	int[] table = new int[(n+1)];
   	 	Arrays.sort(p);
        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)
 
        for (int i=0; i< p.length; i++)
            for (int j=p[i]; j<=n; j++){
            	if((j%p[i])==0){
            		table[j] = j/p[i];
            	}else{
            		if(table[j%p[i]]!=0)
            			table[j] = (j/p[i] + table[(j%p[i])]);
            	}
            }
        		
    	return (table[n]==0) ? -1 : table[n]; 
    }
}
