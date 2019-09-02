package util.backtracking;
import java.util.Scanner;
public class Sudoku {
	private static boolean sudoku_solve1(int [][] grid){
		int i = -1;
		int j = -1;
		boolean isEmpty = true;
		for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
            	if(grid[row][col] == 0) {
            		i = row;
            		j = col;
            		isEmpty = false;
            		break;
            	}
            }
            if(!isEmpty) {
            	break;
            }
        }
		if(isEmpty) {
			return true;
		}
		
		for(int val = 1; val <= 9; val++) {
			if(isSafeToPlace(grid, i, j, val)) {
				grid[i][j] = val;
				if(!sudoku_solve1(grid)) {
					grid[i][j] = 0;
				}else {
					return true;
				}
			}
		}
		return false;
    }

	private static boolean isSafeToPlace(int[][] board, int i, int j, int val) {
    	//check in column j if any cell is 1
		for(int row = 0; row < 9; row ++) {
			if(board[row][j] == val) {
				return false;
			}
		}
		//check in row i any cell is 1
		for(int col = 0; col < 9; col ++) {
			if(board[i][col] == val) {
				return false;
			}
		}
		//check for 3*3 square
		int rowStart = (i/3)*3;
		int colStart = (j/3)*3;
		for(int row = rowStart; row < rowStart+3; row++) {
            for(int col = colStart; col < colStart+3; col++) {
            	if(board[row][col] == val) {
    				return false;
    			}
            }
        }
		return true;
	}
	static void sudoku_solve(int [][] grid) {
		sudoku_solve1(grid);
	}
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int board[][] = new int[9][9];

        n = in.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 9; j++) {
                for(int k = 0; k < 9; k++) {
                    board[j][k] = in.nextInt();
                }
            }
            sudoku_solve(board);
            for(int j = 0; j < 9; j++) {
                for(int k = 0; k < 9; k++) {
                	System.out.print(board[j][k]);
                	 if(k != 8)
                     	System.out.print(" ");
                }
                if(j != 8)
                	System.out.println();
            }
        }
    }
}
