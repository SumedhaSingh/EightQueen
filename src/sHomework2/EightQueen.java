package sHomework2;
/**
 * EightQueen.java
 * 
 * 
 * This program prints all the possible solutions to Eight queens problem using recursion and backtracking.
 * 
 * 
 * @author Sumedha Singh
 * 
 * 
 */

public class EightQueen {

	/**
	 * printMatrix() This static method is used to print the 8 Queen Matrix
	 * 
	 * @param board 2D boolean matrix as chess board 
	 * 
	 * @param rows variable that holds the value for rows
	 * 
	 */
	public static int count=0;
	public static void printMatrix(boolean[][] board, int rows) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				if (board[i][j] == true){
					System.out.print("Q ");
				}
				else{
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * putQueen() This static method is used to place the queen recursively using backtracking.
	 * 
	 * @param row holds the value of row variable
	 * 
	 * @param board 2D boolean array that holds chessboard instances
	 * 
	 * @return boolean returns whether a queen can be placed at a particular cell in the array
	 */
	static boolean putQueen(int row, boolean[][] board) {
		// if the number of rows exceed the maximum number of rows
		if (row == maxRows){
			System.out.println(count++);
			printMatrix(board, 8);
			
			return false;
		}
		
		
		for (int col = 0; col < maxRows; col++) {
			if (isQueenSafe(board, row, col)) {
				board[row][col] = true;
				if (putQueen(row + 1, board)==true) {
					return true;
				} 
				board[row][col]=false;
			}
		}
		return false;
	}

	/**
	 * isQueenSafe() This static method is used to check if the queen can be placed at a particular cell or not
	 * 
	 * @param board 2D boolean array that holds chessboard instances
	 * 
	 * @param row holds the value of row variable
	 * 
	 * @param col holds the value of column variable
	 * 
	 * @return boolean returns true if Queen can safely be placed at. 
	 */	
	static boolean isQueenSafe(boolean[][] board, int row, int col) {
		int i, j;
		 
	    /* Check this column */
	    for (i = 0; i < col; i++)
	    {
	        if (board[row][i])
	            return false;
	    }
	 
	    /* Check for row */
	    for (i = 0; i < row; i++)
	    {
	        if (board[i][col])
	            return false;
	    }
	 
	    /* Check upper diagonal on left side */
	    for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
	    {
	        if (board[i][j])
	            return false;
	    }
	 
	    /* Check lower left diagonal */
	    for (i = row, j = col; j >= 0 && i < maxRows; i++, j--)
	    {
	        if (board[i][j])
	            return false;
	    }
	    
	    /* Check upper diagonal on right side */
	    for (i = row, j = col; j <maxRows && i >=0; i--, j++)
	    {
	        if (board[i][j])
	            return false;
	    }
	    
	    /* Check lower diagonal on right side */
	    for (i = row, j = col; j <maxRows && i <maxRows; i++, j++)
	    {
	        if (board[i][j])
	            return false;
	    }
	    
	    return true;
	}
	
	public static int maxRows = 8;

	public static void main(String args[]) {
		boolean[][] board = new boolean[8][8];
		putQueen(0, board); // Driver method to run the eight queen solver
	}
}