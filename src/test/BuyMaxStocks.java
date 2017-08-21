package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
//Goldman Sachs Codesprint
//https://www.hackerrank.com/contests/gs-codesprint/challenges/buy-maximum-stocks/problem
public class BuyMaxStocks {
	static long buyMaximumProducts(int n, long k, int[] a) {
        // Complete this function
		Map<Integer,List<Integer>> priceVsDayMap = new TreeMap<Integer,List<Integer>>();
		for(int i = 0; i < a.length; i++){
			//If stock price is already present then sort by days
			if(priceVsDayMap.containsKey(a[i])){
				List<Integer> days = priceVsDayMap.get(a[i]);
				days.add(i+1);
				Collections.sort(days);
				priceVsDayMap.put(a[i], days);
			}else{
				List<Integer> days = new ArrayList<Integer>();
				days.add(i+1);
				priceVsDayMap.put(a[i], days);
			}
		}
		long ans = 0;
		for(Map.Entry<Integer, List<Integer>> priceVsDay : priceVsDayMap.entrySet()){
			for(Integer numberOfStocks:priceVsDay.getValue()){
				ans += Math.min(numberOfStocks, k/priceVsDay.getKey());
				//Total Amount = Total amount - CostOfStock*NumberOfStocks
				k -= priceVsDay.getKey()*Math.min(numberOfStocks, k/priceVsDay.getKey());
			}
		}
		return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long k = in.nextLong();
        long result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }
}
