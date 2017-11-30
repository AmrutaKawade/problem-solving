package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
//Pramati
//Given array of string count max ocurring string.
//If 2 strings have same count
//print alphabatically last one
public class Sweet {
	public static void main(String[] args) {
		String[] votes = {"Gulab","Gulab","Gulab","Laddu","Laddu","Jalebi","Jalebi","Barfi","Barfi","Barfi","Barfi","Gajar","Gajar","Gajar"};
		System.out.println(whichSweet(votes));
	}

	private static String whichSweet(String[] votes) {
		Arrays.sort(votes);
	    int max = 0;
	    int count = 1;
	    String sweet = votes[0];
	    for(int i = 1; i < votes.length; i++){
	        if(votes[i] != votes[i-1]){
	            if(count == max){
	                if(sweet.compareTo(votes[i-1]) < 0){
	                    sweet = votes[i-1];
	                }
	            }
	            else if(count >  max){
	              max = count;
	              sweet = votes[i-1];
	            }
	            count = 1;
	        }else{
	            count++;
	        }
	    }
	    if(count == max){
            if(sweet.compareTo(votes[votes.length-1]) < 0){
                sweet = votes[votes.length-1];
            }
        }
        else if(count >  max){
          max = count;
          sweet = votes[votes.length-1];
        }
	    return sweet;
	}

	/*private static String whichSweet(String[] votes) {
		Map<String,Integer> sweetMap = new HashMap<>();
		populateSweetMap(votes,sweetMap);
		Integer max = 0;
		Set<String> sweets = new TreeSet<>();
		for(Entry<String, Integer> entry: sweetMap.entrySet()){
			if(entry.getValue() > max){
				max = entry.getValue();
				sweets.removeAll(sweets);
				sweets.add(entry.getKey());
			}else if(entry.getValue() == max){
				sweets.add(entry.getKey());
			}
		}
		Integer size = sweets.size();
		List<String> maxSweetList = new ArrayList<>();
		maxSweetList.addAll(sweets);
		return maxSweetList.get(size - 1);
	}

	private static void populateSweetMap(String[] votes, Map<String, Integer> sweetMap) {
		for(String vote:votes){
			if(null == sweetMap.get(vote)){
				sweetMap.put(vote, 1);
			}else{
				Integer temp = sweetMap.get(vote);
				sweetMap.put(vote, temp+1);
			}
		}
		
	}*/
}
