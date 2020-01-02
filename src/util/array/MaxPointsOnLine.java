package util.array;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {
	public static void main(String[] args) {
		int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};//{{0,0},{1,1},{1,-1}};//{{1,1},{2,2},{3,3}};//{{0,0},{94911151,94911150},{94911152,94911151}};//{{0,0},{-1,-1},{2,2}};//{{1,1},{2,2},{3,3}};//{{0,-12},{5,2},{2,5},{0,-5},{1,5},{2,-2},{5,-4},{3,4},{-2,4},{-1,4},{0,-5},{0,-8},{-2,-1},{0,-11},{0,-9}};//{{0,0},{1,1},{0,0}};//{{2,3},{3,3},{-5,3}};//{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};//{{2,3},{3,3},{-5,3}};//{{1,1},{2,1},{2,2},{1,4},{3,3}};//{{0,0}};//
		System.out.println(maxPoints(points));
	}
	public static int maxPoints(int[][] points) {
        
        Map<String,Integer> map = new HashMap<String,Integer>();
        int maxPoint = 0;
        //if there is only one point
        if(points.length < 2) {
        	return points.length;
        }
        for(int i = 0; i < points.length; i++){
        	int curMax = 0; 
        	int verticalPoints = 0;
        	int horizontalPoints = 0;
        	int overlapPoints = 0;
            for(int j = i+1; j < points.length; j++){
            	
            	if ((points[i][0] == points[j][0]) && (points[i][1] == points[j][1])) {
                    overlapPoints++;
            	}
            	else if((points[j][0] - points[i][0]) == 0) {
            		verticalPoints++;
            	}
            	else if (points[j][1] == points[i][1]) {
            		horizontalPoints++;
            	}
            	else {
            		int yDiff = (points[j][1] - points[i][1]);
            		int xDiff = (points[j][0] - points[i][0]);
            		
	        		int g = __gcd(xDiff, yDiff); 
	        		  
	                // reducing the difference by their gcd 
	                yDiff /= g; 
	                xDiff /= g; 
            		
                    if (xDiff < 0) {
                    	yDiff = yDiff*-1;
                    	xDiff = xDiff*-1;
                    }
                    
            		String slope1 = yDiff+"_"+xDiff;
            		int freq = 1;
                    if(map.containsKey(slope1)){
                    	freq = map.get(slope1);
                    	freq++;
                    }
                    map.put(slope1,freq);
            		curMax = Math.max(curMax, map.get(slope1));
            	}
            	curMax = Math.max(curMax, verticalPoints);
            	curMax = Math.max(curMax, horizontalPoints);
            	maxPoint = Math.max(maxPoint, curMax + overlapPoints + 1); 
            }
            map.clear();
        }
        
        return maxPoint;
    }
	private static int __gcd(int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
	    BigInteger b2 = BigInteger.valueOf(b);
	    BigInteger gcd = b1.gcd(b2);
	    return gcd.intValue();
	}
}
