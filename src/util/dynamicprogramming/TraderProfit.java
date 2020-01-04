package util.dynamicprogramming;

public class TraderProfit {
	
	//space optimized k transaction solution
	public static int maxProfit(int k, int[] prices) {
	       int[][] stockProfit = new int[2][prices.length];
	       if(prices.length == 0){
	           return 0;
	       }
//	       for(int tract = 1; tract <= k; tract++){
//	           for(int stock = 1; stock < prices.length; stock++){
//	               int max = 0;
//	               for(int x = 0; x < stock; x++){
//	                   int profit = prices[stock] - prices[x] + stockProfit[0][x];
//	                   if(profit > max){
//	                       max = profit;
//	                   }
//	                }
//	                stockProfit[1][stock] = Math.max(max, stockProfit[1][stock-1]);
//	            }
//	            stockProfit[0] = stockProfit[1].clone();
//	       } 
	       
	       //if transactions are more than half of number of stock prices then profit is sum of all positive differences.
	       //prices = {1,2,3,4,5,6} then buy sell on each day will give 3 transactions
	       if(k >= prices.length/2) {
	    	   int profit = 0;
	    	   for(int stock = 1; stock < prices.length; stock++){
	    		   if (prices[stock] > prices[stock - 1])
	    			   profit += prices[stock] - prices[stock-1];
		       }
	    	   return profit;
	       }
	       
	       //rewriting above commented solution
	       //max(prices[stock] - prices[x] + stockProfit[0][x]) -> prices[stock] + max(stockProfit[0][x] - prices[x])
	       //Math.max(max, stockProfit[1][stock-1]);
	       for(int tract = 1; tract <= k; tract++){
	    	   int max = -prices[0];
	           for(int stock = 1; stock < prices.length; stock++){
	        	   stockProfit[1][stock] = Math.max(prices[stock] + max, stockProfit[1][stock-1]);
	        	   max = Math.max(max, stockProfit[0][stock-1] - prices[stock]);
	            }
	            stockProfit[0] = stockProfit[1].clone();
	       } 
	       return stockProfit[1][prices.length-1];
	}

	//2 transactions
	public int maxProfit(int[] prices) {
       int[][] stockProfit = new int[3][prices.length];
       if(prices.length == 0){
           return 0;
       }
       for(int tract = 1; tract <= 2; tract++){
           for(int stock = 1; stock < prices.length; stock++){
               int max = 0;
               for(int x = 0; x < stock; x++){
                   int profit = prices[stock] - prices[x] + stockProfit[tract-1][x];
                   if(profit > max){
                       max = profit;
                   }
               }
               stockProfit[tract][stock] = Math.max(max, stockProfit[tract][stock-1]);
           }
       } 
       return stockProfit[2][prices.length-1];
    }
    public static void main(String[] args) {
    	int k = 2;
    	
    	int[] prices = {6,1,3,2,4,7};
        System.out.println(maxProfit(k,prices));
    }
}
