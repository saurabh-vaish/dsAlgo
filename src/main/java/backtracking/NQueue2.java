package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Problem :  The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *              Two queen can attack each other when they share the same row, column, or diagonal.
 *              Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *              Return the no of possible solutions
 *              Example 1:
 *              Input: n = 4
 *              Output: 2
 *
 *               Example 2:
 *               Input: n = 1
 *               Output: 1
 *
 * @Solution :=  1. Every row and col can have only max one queen. And neither or queens can be in diagonals of others .
 *               2. Donating queens in row we can use 1d array instead of 2d matrix and in this array we can store queen position as index .
 *                  where index no denotes row number and value denotes column position in board.
 *
 *                Every cell have two types of diagonals: (1) go from left to right  (2) from right to left.
 *                For Every cell in the left to right diagonals,  the board with coordinate [row, col] the value of (row - col) remains the same.
 *                On the other hand for right to left diagonals the every cell with coordinate [row, col] the value of (row + col) remains the same.
 *
 *                e.g. Now suppose we have two cells [row1, col1] and [row2, col2]. If they are on a same diagonal which goes from left to right then we would have
 *                 row1 - col1 = row2 - col2  ==>  row1 - row2 = col1 - col2
 *
 *                If the two cells are on a diagonal from right to left then we would have
 *                  row1 + col1 = row2 + col2 ==> row1 - row2 = col2 - col1
 *
 *                 We consolidate the above two cases by checking if (Math.abs(row1 - row2) == Math.abs(col1 - col2))
 *
 * @author Saurabh Vaish
 * @Date 06-07-2021
 */
public class NQueue2 {

    private static int count=0;

    public void solveNQueue(int n){
        backtrack(new ArrayList<>(),0,n);
    }

    private void backtrack(List<Integer> partialSolution, int row, int n) {
        // step1: check for valid solution
        if(isValidSolution(row,n)){
            count++;
            return;
        }

        // step2: get candidates
        for (int col = 0; col < n; col++) {  // for each row in recursive call checking all columns
            if (isAValidCandidate(partialSolution,col,row,n)){
                //step 3: make move
                makeMove(partialSolution,row,col);
                // step 4: calling backtrack
                backtrack(partialSolution,row+1, n);
                // step 5: undo make move
                undoMakeMove(partialSolution,row,col);
            }
        }

    }

    private boolean isValidSolution(int row, int n) {
        return row==n;  // we have reached to n value so traversing is completed
    }

    private boolean isAValidCandidate(List<Integer> partialSolution, int col, int row, int n) {
        // checking that next queen position cell should not be in the same row or col or in diagonal index;
        // partial sol will contain col value based on row index
        // for each col we need to check in every row
        // Notice that we are not checking for row, since in each partial solution we are placing only one queen in a row. So there is no conflict.

        for (int rowIndex = 0; rowIndex < row; rowIndex++) {  // here we are taking row as limit bcs we need to check for the rows that we have traversed already
            int colValue = partialSolution.get(rowIndex);
            if(colValue==col  // same column
            || Math.abs(colValue-col)==Math.abs(rowIndex-row)) { // checking diagonals (row1-row2)==(col1-col2)
                return false;
            }
        }
        return true;
    }

    private void makeMove(List<Integer> partialSolution, int row, int col) {
        // extra work that need to do before calling backtrack method
        partialSolution.add(row,col); // adding col value in specified index
    }

    private void undoMakeMove(List<Integer> partialSolution, int row, int col) {
        // remove extra work after backtrack call
        partialSolution.remove(row);  // removing extra index
    }

    public static void main(String[] args) {

        NQueue2 nQueue = new NQueue2();
        int n=4; //1  [ n * n ] board
        long start = System.currentTimeMillis();
        nQueue.solveNQueue(n);
        long end = System.currentTimeMillis();
        System.out.println("Total Solutions = "+count);
        System.out.println((end-start));
    }
}
