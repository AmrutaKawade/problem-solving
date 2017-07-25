package hackerrank.strings;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
public class SherlockAndValidString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		
		//Charaters vs count map
		Map<Character,Integer> charMap = new HashMap<Character,Integer>();
		for(int i=0;i<input.length();i++){
			if(charMap.containsKey(input.charAt(i))){
				Integer value = charMap.get(input.charAt(i));
				value++;
				charMap.put(input.charAt(i), value);
			}else{
				charMap.put(input.charAt(i), 1);
			}
		}
		
		
		//Count Vs Freq of Count Map
		Collection<Integer> values = charMap.values();
		Map<Integer,Integer> occurenceMap = new HashMap<Integer,Integer>();
		for(Integer value:values){
			if(occurenceMap.containsKey(value)){
				Integer count = occurenceMap.get(value);
				count++;
				occurenceMap.put(value, count);
			}else{
				occurenceMap.put(value, 1);
			}
		}
		
		//If all charaters have equal count. occurenceMap will have 1 entry
		if(occurenceMap.size()==1){
			System.out.println("YES");
		}
		else if(occurenceMap.size()==2){
			Collection<Integer> occurences = occurenceMap.values();
			Integer[] arr = occurences.toArray(new Integer[occurenceMap.size()]);
			Set<Integer> keySet = occurenceMap.keySet();
			Integer[] arr1 = keySet.toArray(new Integer[occurenceMap.size()]);
			int diff = arr1[1]-arr1[0];
			if(occurenceMap.containsKey(1) && occurenceMap.get(1).equals(1)){
				System.out.println("YES");
			}	
			else if((arr[1] == 1 || arr[0]==1) && (Math.abs(diff)<=1)){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}else{
			System.out.println("NO");
		}
	}
}


