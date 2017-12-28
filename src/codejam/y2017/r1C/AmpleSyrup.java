package codejam.y2017.r1C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class AmpleSyrup {
	public static final String DIR = "//home//amruta//Desktop//CodeJam//Round1C//A//";
	private static final String inputFile = "input//A-small-practice.in";
	private static final String outputFile = "output//A-small-practice-2.out";
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try  {
			br = new BufferedReader(new FileReader(DIR+inputFile));
			bw = new BufferedWriter(new FileWriter(DIR+outputFile));
			
			String testCases = br.readLine();
			int t = Integer.parseInt(testCases);
			
			for(int i = 0;i < t;i++){
				String[] input = br.readLine().split(" ");
				int N = Integer.parseInt(input[0]);
				int K = Integer.parseInt(input[1]);
				
				//RH list
				Map<Double,Double> areaVsSide = new TreeMap<>(Collections.reverseOrder());
				ArrayList<Double> sidesList = new ArrayList<>();
				
				for(int j = 0; j < N; j++){
					String[] RvsH = br.readLine().split(" ");
					Double r = Double.parseDouble(RvsH[0]);
					Double h = Double.parseDouble(RvsH[1]);
					
					Double side = r*h;
					Double area = r*r + 2*side;
					
					areaVsSide.put(area, side);
					
					sidesList.add(side);
				}				
				
				Double area = new Double(0);
				
				//Get max area element
				Double maxAreaSide = null;
				Double maxTotalArea = null;
				for(Map.Entry<Double, Double> maxArea:areaVsSide.entrySet()){
					maxTotalArea = maxArea.getKey();
					maxAreaSide = maxArea.getValue();
					break;
				}
				
				if(sidesList.contains(maxAreaSide)){
					sidesList.remove(maxAreaSide);
				}
				Collections.sort(sidesList,Collections.reverseOrder());
				
				for(int j = 0; j < K-1; j++){	
					area += (sidesList.get(j)*2*Math.PI);
				}				
				area += (maxTotalArea*Math.PI);
				//area = area * Math.PI;
				bw.write("Case #"+(i+1)+": "+area+"\n");
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
