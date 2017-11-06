package util.matrix;

public class PrintMatrixSpirally {
	public static void main(String[] args) {
		int[][] mat= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
		int i = (mat.length)/2;
		int j = (mat[0].length)/2;
		int k = 1;
		
		int totalElements = (mat.length)*(mat[0].length);
		int countEle = 1;
		System.out.print(mat[i][j]+" ");
		
		while(i < mat.length && j < mat[0].length){
			int count = 0;
			while(count != k && countEle < totalElements){
				j--;
				System.out.print(mat[i][j]+" ");
				count++;
				countEle++;
			}
			count = 0;
			while(count != k && countEle < totalElements){
				i--;
				System.out.print(mat[i][j]+" ");
				count++;
				countEle++;
			}
			k++;
			count = 0;
			while(count != k && countEle < totalElements){
				j++;
				System.out.print(mat[i][j]+" ");
				count++;
				countEle++;
			}
			count = 0;
			while(count != k && countEle < totalElements){
				i++;
				System.out.print(mat[i][j]+" ");
				count++;
				countEle++;
			}
			k++;
		}
	}
}
