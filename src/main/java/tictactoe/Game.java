package tictactoe;

import java.util.Scanner;

public class Game {

    private final Scanner scan = new Scanner(System.in);
    private int xWon;
    private int oWon;
    final private Board gameBoard = new Board();

    public void playTheGame() {
        gameBoard.printBoard();

        while (!gameBoard.playerWon()) {
            System.out.println("◯ turn");
            int position = getIndex();
            if (gameBoard.spotIsTaken(position)) {
                do {
                    System.out.println("Spot is already taken, choose different position.");
                    position = getIndex();
                } while (gameBoard.spotIsTaken(position));
            }
            placeOOnBoard(position);
            gameBoard.printBoard();
            if (gameBoard.playerWon()) {
                oWon++;
                break;
            }

            System.out.println("X turn");
            position = getIndex();
            if (gameBoard.spotIsTaken(position)) {
                do {
                    System.out.println("Spot is already taken, choose different position.");
                    position = getIndex();
                } while (gameBoard.spotIsTaken(position));
            }
            placeXOnBoard(position);
            gameBoard.printBoard();
            if (gameBoard.playerWon()) {
                xWon++;
                break;
            }
        }
        System.out.println("The results are: ◯ - " + getoWon() + ", X - " + getxWon());
        System.out.println("Would you like to play again? (1 - yes, 2 - no)");
        int play = scan.nextInt();
        if (play == 1) {
            resetBoard(gameBoard);
            playTheGame();
        } else {
            System.out.println("Thanks for playing, ggs");
        }
    }

    private void placeXOnBoard(final int index) {
        switch (index) {
            case 0 -> gameBoard.board[0][0] = "X";
            case 1 -> gameBoard.board[0][1] = "X";
            case 2 -> gameBoard.board[0][2] = "X";
            case 3 -> gameBoard.board[1][0] = "X";
            case 4 -> gameBoard.board[1][1] = "X";
            case 5 -> gameBoard.board[1][2] = "X";
            case 6 -> gameBoard.board[2][0] = "X";
            case 7 -> gameBoard.board[2][1] = "X";
            case 8 -> gameBoard.board[2][2] = "X";
        }
    }

    private void placeOOnBoard(final int index) {
        switch (index) {
            case 0 -> gameBoard.board[0][0] = "◯";
            case 1 -> gameBoard.board[0][1] = "◯";
            case 2 -> gameBoard.board[0][2] = "◯";
            case 3 -> gameBoard.board[1][0] = "◯";
            case 4 -> gameBoard.board[1][1] = "◯";
            case 5 -> gameBoard.board[1][2] = "◯";
            case 6 -> gameBoard.board[2][0] = "◯";
            case 7 -> gameBoard.board[2][1] = "◯";
            case 8 -> gameBoard.board[2][2] = "◯";
        }
    }

    private void resetBoard(Board gameBoard) {
        gameBoard.board[0][0] = "0";
        gameBoard.board[0][1] = "1";
        gameBoard.board[0][2] = "2";
        gameBoard.board[1][0] = "3";
        gameBoard.board[1][1] = "4";
        gameBoard.board[1][2] = "5";
        gameBoard.board[2][0] = "6";
        gameBoard.board[2][1] = "7";
        gameBoard.board[2][2] = "8";
    }

    private int getIndex() {
        int index = scan.nextInt();
        if (index < 0 || index > 8) {
            do {
                System.out.println("Position out of bounds, choose number between 0-8");
                index = scan.nextInt();
            } while (index < 0 || index > 8);
        }
        return index;
    }

    private int getxWon() {
        return xWon;
    }

    private int getoWon() {
        return oWon;
    }
}
