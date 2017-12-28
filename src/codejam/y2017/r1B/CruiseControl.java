//https://code.google.com/codejam/contest/8294486/dashboard#s=p0

package codejam.y2017.r1B;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CruiseControl {
	private static final String inputFile = "input//A-large.in";
	private static final String outputFile = "output//CruiseControl-Large.out";
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try  {
			br = new BufferedReader(new FileReader(inputFile));
			bw = new BufferedWriter(new FileWriter(outputFile));
			
			String testCases = br.readLine();
			int t = Integer.parseInt(testCases);
			
			for(int i = 0;i < t;i++){
				String[] input = br.readLine().split(" ");
				Double totalDistance = Double.parseDouble(input[0]);
				int numberOfHorses = Integer.parseInt(input[1]);
				Double maxTime = new Double(0);
				for(int j = 0;j < numberOfHorses;j++){
					String[] horsesSpeed = br.readLine().split(" ");
					Double startPoint = Double.parseDouble(horsesSpeed[0]);
					int speed = Integer.parseInt(horsesSpeed[1]);
					Double time = (totalDistance - startPoint)/speed;

					if (time > maxTime){
						maxTime = time;
					}
				}
				Double annieSpeed = totalDistance / maxTime;
				
				bw.write("Case #"+(i+1)+": "+String.format("%.6f", annieSpeed)+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();			
				if (bw != null)
					bw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
