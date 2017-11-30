package util.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//codiva
//https://www.hackerrank.com/contests/adobe-codiva/challenges/camera-purchase
public class FindCameras {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] brands = new int[n];
        for(int brands_i = 0; brands_i < n; brands_i++){
            brands[brands_i] = in.nextInt();
        }
        int[] prices = new int[n];
        Map<Integer,List<Integer>> brandVsPrices = new HashMap<>();
        for(int prices_i = 0; prices_i < n; prices_i++){
            prices[prices_i] = in.nextInt();
            if(brandVsPrices.containsKey(brands[prices_i])){
				List<Integer> pricesList = brandVsPrices.get(brands[prices_i]);
				pricesList.add(prices[prices_i]);
			}else{
				List<Integer> pricesList = new ArrayList<>();
				pricesList.add(prices[prices_i]);
				brandVsPrices.put(brands[prices_i], pricesList);
			}
        }
        //Map<Integer,List<Integer>> brandVsPrices = createMap(brands,prices);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int d = in.nextInt();
            int[] cameras = new int[d];
            for(int cameras_i = 0; cameras_i < d; cameras_i++){
                cameras[cameras_i] = in.nextInt();
            }
            int k = in.nextInt();
            System.out.println(findKthBestPrice(k,cameras,brandVsPrices));
        }
        in.close();
    }

	private static int findKthBestPrice(int k, int[] cameras, Map<Integer, List<Integer>> brandVsPrices) {
		List<Integer> prices = new ArrayList<>();
		for(int i = 0; i < cameras.length; i++){
			if(brandVsPrices.containsKey(cameras[i])){
				prices.addAll(brandVsPrices.get(cameras[i]));
			}else{
				return -1;
			}
		}
		Collections.sort(prices);
		if(k > prices.size()){
			return -1;
		}
		return prices.get(k-1);
	}

	/*private static Map<Integer, List<Integer>> createMap(int[] brands, int[] prices) {
		Map<Integer,List<Integer>> brandVsPrices = new HashMap<>();
		for(int i = 0; i < prices.length; i++){
			
		}
		return brandVsPrices;
	}*/
}
