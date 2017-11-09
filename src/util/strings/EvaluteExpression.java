package util.strings;
/*  
 * Input  : exp1 = "-(a+b+c)"
	exp2 = "-a-b-c"
	Output : Yes
	
	Input  : exp1 = "-(c+b+a)"
	exp2 = "-c-b-a"
	Output : Yes
	
	Input  : exp1 = "a-b-(c-d)"
	exp2 = "a-b-c-d"
	Output : No
	
	Input  : exp1 = "(-a-b)-c"
	exp2 = "-a+(-b-c)"
	Output : No
*/

import java.util.Stack;

public class EvaluteExpression {
	public static void main(String[] args) {
		String a = "(a-(b+c))";
		String b = "-b+(a-c)";
		boolean check = checkIfBothExpressionsAreSame(a,b);
		System.out.println(check);
	}

	private static boolean checkIfBothExpressionsAreSame(String a, String b) {
		char[] aChar = new char[26];
		char[] bChar = new char[26];
		evaluate(a,aChar);
		evaluate(b,bChar);
		return compare(aChar,bChar);
	}

	private static boolean compare(char[] aChar, char[] bChar) {
		for(int i = 0; i < aChar.length; i++){
			if(aChar[i] != bChar[i]){
				return false;
			}
		}
		return true;
	}

	private static void evaluate(String str, char[] signArray) {
		Stack<Character> stack = new Stack<Character>(); 
		int i = 0;
		while(i < str.length()){
			if(str.charAt(i) == '('){
				if(i != 0 && str.charAt(i-1) == '-'){
					stack.push(str.charAt(i-1));
				}else{
					stack.push('+');
				}
				i++;
			}else if(str.charAt(i) == ')'){
				char sign = stack.pop();
				changeSigns(i-1,str,signArray,sign);
				i++;
			}else if(str.charAt(i) == '-' || str.charAt(i) == '+'){
				i++;
				continue;
			}else{
				signArray[str.charAt(i)-'a'] = (i != 0 && str.charAt(i-1) == '-') ? '-' : '+';
				i++;
			}
		}
	}

	private static void changeSigns(int i, String str, char[] signArray, char sign) {
		while(i >=0 && str.charAt(i) != '('){
			if(str.charAt(i) == '-' || str.charAt(i) == '+' || str.charAt(i) == ')'){
				i--;
				continue;
			}
			if(sign == '-'){
				signArray[str.charAt(i)-'a'] = (signArray[str.charAt(i)-'a'] == '+') ? '-' : '+';
			}else{
				signArray[str.charAt(i)-'a'] = (signArray[str.charAt(i)-'a'] == '+') ? '+' : '-';
			}
			i--;
		}
	}
}
