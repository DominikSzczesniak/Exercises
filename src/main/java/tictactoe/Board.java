package tictactoe;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Board {
    String[][] board = {{"0", "1", "2"}, {"3", "4", "5"}, {"6", "7", "8"}};
    Scanner scan = new Scanner(System.in);

//    -------------------------------------------------------------         -------------------------------
//    |                   |                   |                   |         |         |         |         |
//    |    board[0][0]    |    board[0][1]    |    board[0][2]    |         |    0    |    1    |    2    |
//    |                   |                   |                   |         |         |         |         |
//    -------------------------------------------------------------         -------------------------------
//    |                   |                   |                   |         |         |         |         |
//    |    board[1][0]    |    board[1][1]    |    board[1][2]    |         |    3    |    4    |    5    |
//    |                   |                   |                   |         |         |         |         |
//    -------------------------------------------------------------         -------------------------------
//    |                   |                   |                   |         |         |         |         |
//    |    board[2][0]    |    board[2][1]    |    board[2][2]    |         |    6    |    7    |    8    |
//    |                   |                   |                   |         |         |         |         |
//    -------------------------------------------------------------         -------------------------------


    public void playTheGame() {
        Random rnd = new Random();  // jakos zadecydowac ktore startuja
        printBoard();

        while (!playerWon()) {
            placeOOnBoard();
            printBoard();
            if (playerWon()) {
                System.out.println("Player that places ◯ has won");
                return;
            }
            placeXOnBoard();
            printBoard();
            if (playerWon()) {
                return;
            }
            // logika jak sie toczy gra


        }

    }


    private int getXIndex() {
        int index = scan.nextInt();
        return index;
    }

    private int getOIndex() {
        int index = scan.nextInt();
        return index;
    }

    private void placeXOnBoard() {
        int index = getXIndex();
        switch (index) {
            case 0 -> board[0][0] = "X";
            case 1 -> board[0][1] = "X";
            case 2 -> board[0][2] = "X";
            case 3 -> board[1][0] = "X";
            case 4 -> board[1][1] = "X";
            case 5 -> board[1][2] = "X";
            case 6 -> board[2][0] = "X";
            case 7 -> board[2][1] = "X";
            case 8 -> board[2][2] = "X";
        }
    }

    private void placeOOnBoard() {
        int index = getOIndex();
        switch (index) {
            case 0:
                board[0][0] = "◯";
                break;
            case 1:
                board[0][1] = "◯";
                break;
            case 2:
                board[0][2] = "◯";
                break;
            case 3:
                board[1][0] = "◯";
                break;
            case 4:
                board[1][1] = "◯";
                break;
            case 5:
                board[1][2] = "◯";
                break;
            case 6:
                board[2][0] = "◯";
                break;
            case 7:
                board[2][1] = "◯";
                break;
            case 8:
                board[2][2] = "◯";
                break;
        }
    }

    public void printBoard() {
        System.out.println("" +
                "-------------------------------\n" +
                "|         |         |         |\n" +
                "|    " + board[0][0] + "    |    " + board[0][1] + "    |    " + board[0][2] + "    |\n" +
                "|         |         |         |\n" +
                "-------------------------------\n" +
                "|         |         |         |\n" +
                "|    " + board[1][0] + "    |    " + board[1][1] + "    |    " + board[1][2] + "    |\n" +
                "|         |         |         |\n" +
                "-------------------------------\n" +
                "|         |         |         |\n" +
                "|    " + board[2][0] + "    |    " + board[2][1] + "    |    " + board[2][2] + "    |\n" +
                "|         |         |         |\n" +
                "-------------------------------");
    }

    private boolean playerWon() {
        if (board[0][0].equals(board[0][1])) {
            return true;
        }


        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board1 = (Board) o;
        return Arrays.equals(board, board1.board);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(board);
    }
}
