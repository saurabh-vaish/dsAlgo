package TickTockToe;

import java.util.Random;
import java.util.Scanner;

/**
 * @Problem  == In tic toc toe game find the next optimal move
 *
 * @author Saurabh Vaish
 * @Date 06-06-2021
 */

class Move{
    int nextRow;
    int nextCol;

    boolean isTie;
    boolean isPlayerWon;
    boolean isComputerWon;
    boolean isMoveLeft;

    public Move(){}

    public Move(int row,int col){
        this.nextRow=row;
        this.nextCol=col;
    }
}
public class TicTokToeMiniMax {

    static char player='o' , computer='x' ,nil='_';
    static boolean isGameStarted=false;

    public static void main(String[] args) {
//        char board1[][] = {{ 'x', 'o', 'x' },
//                { 'o', 'o', 'x' },
//                { nil, nil, nil }};
        char board[][] = {{ nil, nil, nil },
                        { nil, nil, nil },
                        { nil, nil, nil }};

        printGame(board);
        Scanner scanner = new Scanner(System.in);
        boolean turn=true;
        while(turn) {
            System.out.print("Enter your move = ");
            String pl[] = scanner.nextLine().trim().split(",");
            int row=Integer.parseInt(pl[0]);
            int col=Integer.parseInt(pl[1]);
            row = row>2?2: Math.max(row, 0);
            col = col>2?2: Math.max(col, 0);

            if(board[row][col]!=nil){
                System.out.println("moves can't be repeated , try another move");
                continue;
            }else {
                board[row][col] = player;
            }
            GameMove bestGameMove = evaluate(board);  //  evolution for result check

            if(bestGameMove.isMoveLeft) {
                bestGameMove = findBestMove(board, bestGameMove);
                board[bestGameMove.nextRow][bestGameMove.nextCol]=computer;
//                System.out.println("optimal next bestMove = [" + bestMove.nextRow + "," + bestMove.nextCol + "]");
            }
             bestGameMove = evaluate(board);  // again evolution for result check
            if(bestGameMove.isPlayerWon){
                turn=false;
                System.out.println("Congo ! you have won");
            }else if(bestGameMove.isComputerWon){
                turn=false;
                System.out.println("Sorry ! you loose");
            }else if(bestGameMove.isTie){
                turn=false;
                System.out.println("match tied");
            }
            printGame(board);
        }



    }


    // method to give next best move based on current state of board
    private static GameMove findBestMove(char[][] board, GameMove gameMove) {

        GameMove bestGameMove = new GameMove();
        int bestValue = Integer.MIN_VALUE; // consider its best move
        int movesCount=0;
        if(isGameStarted) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == nil) {
                        board[i][j]=computer;  // making move for computer 

                        // evolute best move
                        int best = minimax(board,false);
                        board[i][j]=nil;  // undo making move for computer

                        if(best>bestValue){
                            bestValue=best;
                            bestGameMove.nextRow=i;
                            bestGameMove.nextCol=j;
                        }
                    }
                }
            }
//            System.out.println("bext value = "+bestValue);
            return bestGameMove;
        }else {
            // choose any random move
            int rowNo = new Random().nextInt(4);
            int colNo = new Random().nextInt(4);
            return new GameMove(rowNo, colNo);
        }
    }


    // method to check if any move left for player or tie or wins
    static GameMove evaluate(char[][] board){
        GameMove gameMove = new GameMove();

        // check in rows if all are same then game won
        for (int row = 0; row < 3; row++) {
            if(board[row][0]!=nil && board[row][0]==board[row][1] && board[row][1]==board[row][2]){
                if(board[row][0]==player) gameMove.isPlayerWon=true;
                else gameMove.isComputerWon=true;
                return gameMove;
            }
        }

        // check in columns if all are same then game won
        for (int col = 0; col < 3; col++) {
            if(board[0][col]!=nil && board[0][col]==board[1][col] && board[1][col]==board[2][col]){
                if(board[0][col]==player) gameMove.isPlayerWon=true;
                else gameMove.isComputerWon=true;
                return gameMove;
            }
        }

        // check in diagonal if all are same then game won
        if(board[0][0]!=nil && board[0][0]==board[1][1] && board[1][1]==board[2][2]){
            if(board[0][0]==player) gameMove.isPlayerWon=true;
            else gameMove.isComputerWon=true;
            return gameMove;
        }
        if(board[0][2]!=nil && board[0][2]==board[1][1] && board[1][1]==board[2][0]){
            if(board[0][2]==player) gameMove.isPlayerWon=true;
            else gameMove.isComputerWon=true;
            return gameMove;
        }

        int count=0;  // to check how many moves are remaining
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j]==nil){
                    gameMove.isMoveLeft=true;
                    count++;
                }
            }
        }
        if(count!=9)isGameStarted=true; // if equal to 9 means no move has been made yet
        else isGameStarted=false;

        gameMove.isTie=!gameMove.isMoveLeft;

        return gameMove;
    }


    private static int minimax(char[][] board, boolean isMax) {
        GameMove gameMove =evaluate(board);
        if(gameMove.isComputerWon){
            return 10;
        }
        else if(gameMove.isPlayerWon){
            return -10;
        }
        else if(gameMove.isTie){
            return 0;
        }
//        else return 0; // if none matched
        // calculate maximizer move
        if(isMax){
            int best=Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(board[i][j]==nil) {
                        board[i][j] = computer;
                        best = Math.max(best, minimax(board, !isMax));
                        board[i][j] = nil;
                    }
                }
            }
            return best;
        }else{
            int best=Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(board[i][j]==nil) {
                        board[i][j] = player;
                        best = Math.min(best, minimax(board, !isMax));
                        board[i][j] = nil;
                    }
                }
            }
            return best;
        }
    }


    private static void printGame(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c =board[i][j];
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
}
