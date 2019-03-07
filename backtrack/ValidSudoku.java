import java.util.*;

public class ValidSudoku{

	private static boolean notInRow(char [][] sudoku, int row){
		HashSet<Character> set = new HashSet<>();

		for(int col = 0; col < 9; col++){
			if(set.contains(sudoku[row][col])){
				return false;
			}

			if(sudoku[row][col] != '.'){
				set.add(sudoku[row][col]);
			}
		}

		return true;
	}

	private static boolean notInCol( char [][] sudoku, int col){
		HashSet<Character> set = new HashSet<>();

		for(int row = 0; row < 9; row++){
			if(set.contains(sudoku[row][col])){
				return false;
			}

			if(sudoku[row][col] != '.'){
				set.add(sudoku[row][col]);
			}
		}

		return true;
	}


	private static boolean notInBox( char [][] sudoku, int row, int col){
		HashSet<Character> set = new HashSet<>();

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				char current = sudoku[i+row][j+col];

				if(set.contains(current)){
					return false;
				}

				if(current != '.'){
					set.add(current);
				}
			}
		}

		return true;
	}

	private static boolean isValid(char [][] sudoku){
		int rows = sudoku.length;
		int cols = sudoku[0].length;
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				return (notInRow(sudoku, i) && notInCol(sudoku, j) && notInBox(sudoku, i-i%3, j-j%3));
			}
		}	

		return false;
	}

	public static void main(String [] args){
		char [][] board = new char[][]{ 
						 { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, 
                         { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
                         { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, 
                         { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
                         { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, 
                         { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
                         { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, 
                         { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
                         { '.', '.', '.', '.', '8', '.', '.', '7', '9' } 
                     }; 

        System.out.println(isValid(board));
	}
}