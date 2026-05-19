package backtracking;
public class sudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(board,0,0)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }

    }

    public static boolean solveSudoku(int[][] board , int row , int col) {
        if(row==9){
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;
        if(nextCol == 9){
            nextRow = row + 1;
            nextCol = 0;
        }

        if(board[row][col] != 0){
            return solveSudoku(board , nextRow , nextCol);
        }

        for(int num = 1 ; num <= 9 ; num++){
            if(isSafe(board , row , col , num)){
                board[row][col] = num;
                if(solveSudoku(board , nextRow , nextCol)){
                    return true;
                }
                board[row][col] = 0; // backtrack
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check if 'num' is not already placed in the current row, current column and current 3x3 box
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int boxStartRow = row/3 * 3;
        int boxStartCol = col/3 * 3;
        for (int i = boxStartRow; i < boxStartRow + 3; i++) {
            for (int j = boxStartCol; j < boxStartCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard(int[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int d = 0; d < 9; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}