package util.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakProblem {
	static Map<String,Integer> map = new HashMap<String,Integer>();
	public static void main(String[] args) {
		//String s = "catsandog"; 
		//String s = "leetcode";
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		//String s = "applepenapple";
		List<String> wordDict = new ArrayList<String>();
		String[] words = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		for(String word: words) {
			wordDict.add(word);
		}
		//String[] words = {"apple","pen"};
		//String[] words = {"leet","leetcode"};
		//String[] words = {"cats","dog","sand","and","cat"};
		//String[] words = {"b"};
		
		System.out.println(wordBreak(s,wordDict));
	}
	public static boolean wordBreak(String s, List<String> wordDict) {
        
        for(String word: wordDict) {
        	map.put(word,1);
        }
        return wordBreakRec(s,map);
    }
	
	public static boolean wordBreakRec(String s, Map<String,Integer> wordDict) {
        int size = s.length(); 
        if (size == 0)   
        	return true; 
      
        // Create the DP table to store results of subroblems. The value wb[i] 
        // will be true if str[0..i-1] can be segmented into dictionary words, 
        // otherwise false. 
        boolean[] wb = new boolean[size+1];
      
        for (int i=1; i<=size; i++) 
        { 
            // if wb[i] is false, then check if current prefix can make it true. 
            // Current prefix is "str.substr(0, i)" 
            if (wb[i] == false && map.containsKey(s.substring(0,i))) 
                wb[i] = true; 
      
            // wb[i] is true, then check for all substrings starting from 
            // (i+1)th character and store their results. 
            if (wb[i] == true) 
            { 
                // If we reached the last prefix 
                if (i == size) 
                    return true; 
      
                for (int j = i+1; j <= size; j++) 
                { 
                    // Update wb[j] if it is false and can be updated 
                    // Note the parameter passed to dictionaryContains() is 
                    // substring starting from index 'i' and length 'j' 
                    if (wb[j] == false && map.containsKey(s.substring(i, j))) 
                        wb[j] = true; 
      
                    // If we reached the last character 
                    if (j == size && wb[j] == true) 
                        return true; 
                } 
            } 
        } 
        return false; 
    }
}
