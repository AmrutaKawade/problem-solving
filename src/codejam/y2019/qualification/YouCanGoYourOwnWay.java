package codejam.y2019.qualification;
import java.util.Scanner;

//Solution
public class YouCanGoYourOwnWay {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer numberOfTestCases = in.nextInt();
		for (int i = 1; i <= numberOfTestCases; ++i) {
			Integer mazeSize = in.nextInt();
			String mazePath = in.next();
			String result = getMirrorPath(mazePath);
			System.out.println("Case #" + i + ": " + result);
	    }
	}

	private static String getMirrorPath(String givenPath) {
		Integer pathLength = givenPath.length();
		StringBuilder mirrorPath = new StringBuilder();	
		for (int i = 0; i < pathLength; i++) {
			if (givenPath.charAt(i) == 'E')
				mirrorPath.append('S');
			else
				mirrorPath.append('E');
		}
		return mirrorPath.toString();
	}
}