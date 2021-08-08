package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Problem  == Given an m x n board and a word, find if the word exists in the grid. The word can be constructed from letters of sequentially adjacent cells,
 *              where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *              Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 *               Output: true
 *
 *               Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 *               Output: false
 *
 * @Solution == so the aspect here is that we cannot include a cell more than once while searching for a word. While searching for a word if a cell (x, y) is already visited
 *              as part of the current backtrack path (think of it as a path in the 'backtrack tree') we should not re-visit that again.
 *              Example: input: [["a", "a"]], string to search = "aaa", You cannot visit cell (0, 0) and (0, 1) and then again (0, 0) and say you found "aaa".
 *              Because (0, 0) is already visited you cannot revisit it.
 *
 *              From every cell we can go in 4 directions [ in down , right approach] -  {-1, 0} [top] , {0, -1} [left] , {0, 1} [right]  , {1, 0}} [down] ;
 *
 *
 *
 * @author Saurabh Vaish
 * @Date 05-06-2021
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
        String word = "SEE";
        boolean exist = checkWordExit(board,word);
        System.out.println("word found = "+exist);
    }

    private static boolean checkWordExit(char[][] board, String word) {
        if(board==null ||board.length==0 || word==null || word.isEmpty())return false;
        char firstChar = word.charAt(0);
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==firstChar){
                    if(backtrack(0,board,word.toCharArray(),i,j,visited))return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(int charIndex,char[][] board, char[] word, int row, int col, Set<String> visited) {
        if(charIndex==word.length-1 && word[charIndex]==board[row][col]){
            return true;
        }
        if(board[row][col]!=word[charIndex])return false; // next cell is not equal to next char

        List<List<Integer>> candidates = generateCandidates(row,col,board,visited);

        for (List<Integer> candidate:candidates) {
            visited.add(row+","+col);  // make move mark cell as visited
            if(backtrack(charIndex+1, board, word, candidate.get(0),candidate.get(1) ,visited )){
                return true;
            }
            visited.remove(row+","+col); // undo make move
        }
        return false;
    }

    // method for generating next cells to traverse
    private static List<List<Integer>> generateCandidates(int row, int col, char[][] board, Set<String> visited) {
        int[][] adjacentCells = {{-1,0},{0,-1},{1,0},{0,1}} ; // top , left , down ,right   // next cells for every cell
        List<List<Integer>> candidates = new ArrayList<>(); // valid cells
        for(int[] nextCell:adjacentCells){
            int nextRow = row+nextCell[0];
            int nextCol = col+nextCell[1];

            if(nextRow<0 || nextRow==board.length || nextCol<0 || nextCol==board[0].length || visited.contains(nextRow+","+nextCol)){  // if cell is already visited then continue
                continue;   // if cells position for next step is on boundaries then continue
            }
            List<Integer> candidate = new ArrayList<>();
            candidate.add(nextRow); // next valid cell row
            candidate.add(nextCol); // next valid cell col
            candidates.add(candidate);
        }
        return candidates;
    }
}
