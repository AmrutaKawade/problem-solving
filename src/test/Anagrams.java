package test;
/* Zapper
 * Given 2 string arrays. output int array which indicates 
 * number of characters needs to update in string
 * To make it anagram
 * can not add or delete character
 * 
 * */
public class Anagrams {
	public static void main(String[] args) {
        String[] arr1 = {"tea","tta","sport"};
        String[] arr2 = {"ate","toe","sports"};
        int[] output = findAnagrams(arr1,arr2);
        System.out.println(output);
	}
	private static int[] findAnagrams(String[] arr1, String[] arr2) {
        int[] output = new int[arr1.length];
        for(int i = 0; i < arr1.length; i++){
                String s1 = arr1[i];
                String s2 = arr2[i];
                if(s1.length() == s2.length()) {
                        int k = 0;
                        while(s1.length() != 0 && k != s1.length()) {
                                char c1 = s1.charAt(k);
                                if (s2.indexOf(c1) != -1){
                                        s1 = s1.replaceFirst(Character.toString(c1), "");
                                        s2 = s2.replaceFirst(Character.toString(c1), "");
                                } else {
                                        k++;
                                }
                        }
                        if (s1.length() == s2.length()) {
                                output[i] = s1.length();
                        }
                        else {
                                output[i] = -1;
                        }
                } else {
                        output[i] = -1;
                }
        }
        return output;
	}
}
