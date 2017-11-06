package util.strings;

public class MaxOccurCharInString {
	public static void main(String[] args) {
		String a = "aaaaaa";
		String b = "abcda";
		String c = "abcd";
		String d = "aaab";
		
		char[] array = new char[256];
		int count = maxOccuringCharacterInString(array,d);
		System.out.println(count);
	}

	private static int maxOccuringCharacterInString(char[] array, String str) {
		int max = 0;
		if(str == null || str == ""){
			return 0;
		}else{
			for(int i = 0; i < str.length(); i++){
				int temp = (++array[str.charAt(i)]);
				if(temp > max){
					max = temp;
				}
			}
		}
		return max;
	}
}
