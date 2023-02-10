package tictactoe;

import java.util.Scanner;

public class Game {

    private final Scanner scan = new Scanner(System.in);
    private int secondPlayerWon;
    private int firstPlayerWon;
    final private Board gameBoard = new Board();

    public void assignNames() {
        gameBoard.players.setNames();
    }

    public void assignSymbols() {
        gameBoard.players.setSymbols();
    }

    public void playTheGame() {
        gameBoard.printBoard();

        while (!gameBoard.gameIsOver()) {
            System.out.println(gameBoard.players.getNameOne() + " turn");
            int position = getIndex();
            if (gameBoard.spotIsTaken(position)) {
                do {
                    System.out.println("Spot is already taken, choose different position.");
                    position = getIndex();
                } while (gameBoard.spotIsTaken(position));
            }
            placeOOnBoard(position);
            gameBoard.printBoard();
            if (gameBoard.gameIsOver()) {
                firstPlayerWon++;
                break;
            } else if ((gameBoard.isDraw())) {
                System.out.println("It's a draw");
                break;
            }

            System.out.println(gameBoard.players.getNameTwo() + " turn");
            position = getIndex();
            if (gameBoard.spotIsTaken(position)) {
                do {
                    System.out.println("Spot is already taken, choose different position.");
                    position = getIndex();
                } while (gameBoard.spotIsTaken(position));
            }
            placeXOnBoard(position);
            gameBoard.printBoard();
            if (gameBoard.gameIsOver()) {
                secondPlayerWon++;
                break;
            } else if ((gameBoard.isDraw())) {
                System.out.println("It's a draw");
                break;
            }
        }
        System.out.println("The results are: " + gameBoard.players.getNameOne() + " - " + getFirstPlayerWon() + ", " + gameBoard.players.getNameTwo() + " - " + getSecondPlayerWon());
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
            case 0 -> gameBoard.board[0][0] = gameBoard.players.getSymbolTwo();
            case 1 -> gameBoard.board[0][1] = gameBoard.players.getSymbolTwo();
            case 2 -> gameBoard.board[0][2] = gameBoard.players.getSymbolTwo();
            case 3 -> gameBoard.board[1][0] = gameBoard.players.getSymbolTwo();
            case 4 -> gameBoard.board[1][1] = gameBoard.players.getSymbolTwo();
            case 5 -> gameBoard.board[1][2] = gameBoard.players.getSymbolTwo();
            case 6 -> gameBoard.board[2][0] = gameBoard.players.getSymbolTwo();
            case 7 -> gameBoard.board[2][1] = gameBoard.players.getSymbolTwo();
            case 8 -> gameBoard.board[2][2] = gameBoard.players.getSymbolTwo();
        }

    }

    private void placeOOnBoard(final int index) {
        switch (index) {
            case 0 -> gameBoard.board[0][0] = gameBoard.players.getSymbolOne();
            case 1 -> gameBoard.board[0][1] = gameBoard.players.getSymbolOne();
            case 2 -> gameBoard.board[0][2] = gameBoard.players.getSymbolOne();
            case 3 -> gameBoard.board[1][0] = gameBoard.players.getSymbolOne();
            case 4 -> gameBoard.board[1][1] = gameBoard.players.getSymbolOne();
            case 5 -> gameBoard.board[1][2] = gameBoard.players.getSymbolOne();
            case 6 -> gameBoard.board[2][0] = gameBoard.players.getSymbolOne();
            case 7 -> gameBoard.board[2][1] = gameBoard.players.getSymbolOne();
            case 8 -> gameBoard.board[2][2] = gameBoard.players.getSymbolOne();
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

    private int getSecondPlayerWon() {
        return secondPlayerWon;
    }

    private int getFirstPlayerWon() {
        return firstPlayerWon;
    }

}
