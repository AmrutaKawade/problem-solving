package util.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class Strings1 {
	public static void main(String args[]){
		/*String s1 = "aacdb";
		String s2 = "gafd";*/
		String s1 = "abcs";
        String s2 = "cxzca";
		String output = removeCommonCharacter(s1, s2);
		System.out.println(output);
	}
	public static String removeCommonCharacter(String s1,String s2){
		Map<Character,Integer> charMap = new LinkedHashMap<Character,Integer>();
		String s = s1.concat(s2);
		String output = "";
		for(int i = 0; i < s.length(); i++){
			if(charMap.containsKey(s.charAt(i))){
				Integer count = charMap.get(s.charAt(i));
				count++;
				charMap.put(s.charAt(i),count);
			}else{
				charMap.put(s.charAt(i),1);
			}
		}
		for(Map.Entry<Character, Integer> charCount : charMap.entrySet()){
			if(charCount.getValue().equals(1)){
				output += charCount.getKey();
			}
		}
		return output;
	}
}
