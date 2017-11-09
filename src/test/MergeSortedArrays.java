package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Daily Hunt
public class MergeSortedArrays {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer len1 = Integer.parseInt(in.next());
		List<Integer> array1 = new ArrayList<Integer>();
		for(int i=0; i < len1; i++){
			array1.add(i, Integer.parseInt(in.next()));
		}
		Integer len2 = Integer.parseInt(in.next());
		List<Integer> array2 = new ArrayList<Integer>();
		for(int i=0; i < len2; i++){
			array2.add(i, Integer.parseInt(in.next()));
		}
		List<Integer> output = merge(array1, array2, len1, len2);
		for(int i = 0; i < (len1+len2); i++){
			System.out.print(output.get(i) + " ");
		}
	}
	private static List<Integer> merge(List<Integer> array1, List<Integer> array2, Integer len1, Integer len2) {
		List<Integer> b = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < len1 && j < len2){
			if(array1.get(i) <= array2.get(j)){
				b.add(k,array1.get(i));
				i++;
				k++;
			}
			if(array1.get(i) > array2.get(j)){
				b.add(k,array2.get(j));
				j++;
				k++;
			}
		}
		while( i < len1){
			b.add(k,array1.get(i));
			i++;
			k++;
		}
		while( j < len2){
			b.add(k,array2.get(j));
			j++;
			k++;
		}
		return b;
	}
}
