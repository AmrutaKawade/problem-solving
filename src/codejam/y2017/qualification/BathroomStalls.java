//https://code.google.com/codejam/contest/3264486/dashboard#s=p2
package codejam.y2017.qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class BathroomStalls {
	private static final String inputFile = "input//C-large.in";
	private static final String outputFile = "output//C-large-output.out";
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try  {
			br = new BufferedReader(new FileReader(inputFile));
			bw = new BufferedWriter(new FileWriter(outputFile));
			
			String testCases = br.readLine();
			int t = Integer.parseInt(testCases);
			BigInteger[] output = new BigInteger[2];
			for(int i = 0;i < t;i++){
				String[] input = br.readLine().split(" ");
				BigInteger n = new BigInteger(input[0]);
				BigInteger k = new BigInteger(input[1]);
				output = recBathroomStalls(n,k);
				bw.write("Case #"+(i+1)+": "+output[0]+" "+output[1]+"\n");
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
	
	private static BigInteger[] recBathroomStalls(BigInteger n,BigInteger k){
		//Even
		BigInteger min = n.divide(BigInteger.valueOf(2));
		BigInteger max = n.divide(BigInteger.valueOf(2));
		if(n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)){
			min = min.subtract(BigInteger.ONE);
			if(k.equals(BigInteger.ONE)) {
				return new BigInteger[]{max,min};
			}else if(k.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)){
				return recBathroomStalls(max, k.divide(BigInteger.valueOf(2)));
			}else{
				return recBathroomStalls(min, k.divide(BigInteger.valueOf(2)));
			}
		}else{
			if(k.equals(BigInteger.ONE)){
				return new BigInteger[]{max,min};
			}else if(k.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)){
				return recBathroomStalls(max, k.divide(BigInteger.valueOf(2)));
			}else{
				return recBathroomStalls(min, k.divide(BigInteger.valueOf(2)));
			}
		}
	}
}
