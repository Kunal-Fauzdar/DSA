package backtracking;

public class nQueens {

    int count=0;
    public static void main(String[] args) {
        int n = 4;
        

        //initialize board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        nQueens(board, 0);
    }
    public static void nQueens(char[][] board, int row) {
    //for printing only one solution
    //public static boolean nQueens(char[][] board, int row) {
        
        //base case
        if(row == board.length){
            //print board
            printBoard(board);

            //for counting solutions
            //count++;

            //for printing only one solution
            //return true;

            return;
        }

        for(int i=0 ; i<board.length ; i++){
            if(isSafe(board,row,i)){
                board[row][i] = 'Q';
                nQueens(board, row+1);
                //for printing only one solution
                //if(nQueens(board, row+1)){
                //    return true;
                //}
                board[row][i] = 'x'; //backtracking
            }
            
        }
    }

    public static boolean isSafe(char[][] board, int row, int col){
        //vertical up
        for(int i=row-1 ; i>=0 ; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //diagonal left up
        for(int i=row-1, j=col-1 ; i>=0 && j>=0 ; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //diagonal right up
        for(int i=row-1, j=col+1 ; i>=0 && j<board.length ; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static void printBoard(char[][] board){
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board.length ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
