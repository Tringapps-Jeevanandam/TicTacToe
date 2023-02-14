package com.example;
import java.util.logging.Logger;
import java.util.Scanner;

class TicTacToe {
    public static final Logger Log = Logger.getLogger("InfoLogging");
    public static void display(char[][] board) {
        StringBuilder s = new StringBuilder("\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                s.append(board[i][j] + "| ");
            }
           s.append("\n");
        }
        String str =""+s;
        Log.info(str);
    }

    public static void settingPos(char[][] board, String player, int pos) {
        char sym = ' ';
        if (player.equals("p1")) {
            sym = 'x';
        } else if (player.equals("p2")) {
            sym = 'o';
        }
        switch (pos) {
            case 1:
                board[0][0] = sym;
                break;
            case 2:
                board[0][1] = sym;
                break;
            case 3:
                board[0][2] = sym;
                break;
            case 4:
                board[1][0] = sym;
                break;
            case 5:
                board[1][1] = sym;
                break;
            case 6:
                board[1][2] = sym;
                break;
            case 7:
                board[2][0] = sym;
                break;
            case 8:
                board[2][1] = sym;
                break;
            case 9:
                board[2][2] = sym;
                break;
            default:
                break;

        }
    }
    public static boolean isEmpty(char[][] board,int pos){
        switch(pos){
            case 1: return(board[0][0] == ' ');
            case 2: return(board[0][1] == ' ');
            case 3: return(board[0][2] == ' ');
            case 4: return(board[1][0] == ' ');
            case 5: return(board[1][1] == ' ');
            case 6: return(board[1][2] == ' ');
            case 7: return(board[2][0] == ' ');
            case 8: return(board[2][1] == ' ');
            case 9: return(board[2][2] == ' ');
            default: return false;
        }

    }
    public static boolean winner(char[][] board, char sym){
        if ((board[0][0] == sym && board [0][1] == sym && board [0][2] == sym) ||
			(board[1][0] == sym && board [1][1] == sym && board [1][2] == sym) ||
			(board[2][0] == sym && board [2][1] == sym && board [2][2] == sym) ||
			
			(board[0][0] == sym && board [1][0] == sym && board [2][0] == sym) ||
			(board[0][1] == sym && board [1][1] == sym && board [2][1] == sym) ||
			(board[0][2] == sym && board [1][2] == sym && board [2][2] == sym) ||
			
			(board[0][0] == sym && board [1][1] == sym && board [2][2] == sym) ||
			(board[0][2] == sym && board [1][1] == sym && board [2][0] == sym) ) {
			return true;
		}
		return false;
    }
    public static boolean gameResult(char[][] board) {
		
		if (winner(board, 'x')) {	
			display(board);
			Log.info("Player 1 wins!");
			return true;
		}
		
		if (winner(board, 'o')) {	
			display(board);
			Log.info("Player 2 wins!");
			return true;
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		display(board);
		Log.info("The game ended in a tie!");
		return true;
	}
    public static void player1Turn(char[][] board, Scanner scanner) {
		int p1pos;
		while (true) {
			Log.info("Player 1:");
			p1pos = scanner.nextInt();
			if (isEmpty(board, p1pos)){
				break;
			} else {
				Log.info(p1pos + " is not a valid move.");
			}
		}
		settingPos(board, "p1", p1pos);
	}    
    public static void player2Turn(char[][] board, Scanner scanner) {
		int p2pos;
		while (true) {
			Log.info("Player 2:");
			p2pos = scanner.nextInt();
			if (isEmpty(board, p2pos)){
				break;
			} else {
				Log.info(p2pos + " is not a valid move.");
			}
		}
		settingPos(board, "p2", p2pos);
	}

    public static void main(String[] args) {
        char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
        display(board);
        Scanner input = new Scanner(System.in);        
        while (true) {
			player1Turn(board, input);
			if (gameResult(board)){
				break;
			}
			display(board);
			
			player2Turn(board, input);
			if (gameResult(board)){
				break;
			}
			display(board);
		}
    }

}