package util.strings;

public class ReverseString {
	public static void main(String[] args) {
		String s = "getting good at coding needs a lot of practice";
		char[] strArray = convertToCharArray(s);
		reverseEachWord(strArray);
		reverseString(strArray,0,strArray.length-1);
		printString(strArray);
	}

	private static void reverseEachWord(char[] strArray) {
		int wordStartIndex = 0;
		int wordEndIndex = 0;
		while(wordEndIndex < strArray.length){
			wordEndIndex++;
			if(wordEndIndex == strArray.length){
				reverseString(strArray, wordStartIndex, wordEndIndex-1);
				break;
			}
			if(strArray[wordEndIndex] == ' '){
				reverseString(strArray, wordStartIndex, wordEndIndex-1);
				wordStartIndex = wordEndIndex+1;
			}
		}
	}

	private static void printString(char[] strArray) {
		String temp = "";
		for(int i = 0; i < strArray.length; i++){
			temp += strArray[i];
		}
		System.out.println(temp);
	}

	private static char[] convertToCharArray(String s) {
		char[] array = s.toCharArray();
		return array;
	}

	private static void reverseString(char[] str, int i, int j) {
		while(i<j){
			swap(str,i,j);
			i++;
			j--;
		}
	}

	private static void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
}
