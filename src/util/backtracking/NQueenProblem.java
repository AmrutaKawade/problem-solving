package util.backtracking;

import java.util.Scanner;

public class NQueenProblem {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[][] board = new int[N][N];
		if(NQueen_Problem(board,N)) {
			System.out.println("YES");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}else {
			System.out.println("NO");
		}
	}

	private static boolean NQueen_Problem(int[][] board, int n) {
		//no queen left
		if(n == 0) {
			return true;
		}
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(is_safe(i,j, board)) {
					board[i][j] = 1;
					if(!NQueen_Problem(board, n-1)) {
						board[i][j] = 0;
					}else {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean is_safe(int i, int j, int[][] board) {
		//check in column j if any cell is 1
		for(int row = 0; row < board.length; row ++) {
			if(board[row][j] == 1) {
				return false;
			}
		}
		//check in row i any cell is 1
		for(int col = 0; col < board.length; col ++) {
			if(board[i][col] == 1) {
				return false;
			}
		}
		//check diagonally if any cell is 1
		int row = i;
		int col = j;
		while(row > 0 && col > 0) {
			if(board[--row][--col] == 1) {
				return false;
			}
		}
		row = i;
		col = j;
		while(row < board.length-1 && col < board.length-1) {
			if(board[++row][++col] == 1) {
				return false;
			}
		}
		row = i;
		col = j;
		while(row > 0 && col < board.length-1) {
			if(board[--row][++col] == 1) {
				return false;
			}
		}
		row = i;
		col = j;
		while(row < board.length-1 && col > 0) {
			if(board[++row][--col] == 1) {
				return false;
			}
		}
		return true;
	}
}
