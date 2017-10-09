package util.strings;

public class Strings2 {
	public static void main(String args[]){
		//String s = "1A0B1";
		String s = "1C1B1B0A0";
		while(s.length()!=1){
			int i = 0;
			if(s.charAt(1) == 'A'){
				i = Integer.valueOf(s.substring(0,1)) & Integer.valueOf(s.substring(2,3));
			}
			if(s.charAt(1) == 'B'){
				i = Integer.valueOf(s.substring(0,1)) | Integer.valueOf(s.substring(2,3));
			}
			if(s.charAt(1) == 'C'){
				i = Integer.valueOf(s.substring(0,1)) ^ Integer.valueOf(s.substring(2,3));
			}
			s = String.valueOf(i) + s.substring(3,s.length());
		}
		System.out.println(s);
	}
}
