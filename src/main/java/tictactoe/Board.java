package tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Board {

    Placement placement = new Placement();
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
        printBoard();

        while (!playerWon()) {
            System.out.println("◯ turn");
            int position = placement.getIndex();
            if (spotIsTaken(position)) {
                do {
                    System.out.println("Spot is already taken, choose different position.");
                    position = placement.getIndex();
                } while (spotIsTaken(position));
            }
            placeOOnBoard(position);
            printBoard();
            if (playerWon()) {
                return;
            }

            System.out.println("X turn");
            position = placement.getIndex();
            if (spotIsTaken(position)) {
                do {
                    System.out.println("Spot is already taken, choose different position.");
                    position = placement.getIndex();
                } while (spotIsTaken(position));
            }
            placeXOnBoard(position);
            printBoard();
            if (playerWon()) {
                return;
            }
        }

    }


    private int asdIndex() {
        int index = scan.nextInt();
        if (index < 0 || index > 8) {
            do {
                System.out.println("Position out of bounds, choose number between 0-8");
                index = scan.nextInt();
            } while (index < 0 || index > 8);
        }
            return index;
    }

    private void placeXOnBoard(int index) {
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


    private void placeOOnBoard(int index) {
        switch (index) {
            case 0 -> board[0][0] = "◯";
            case 1 -> board[0][1] = "◯";
            case 2 -> board[0][2] = "◯";
            case 3 -> board[1][0] = "◯";
            case 4 -> board[1][1] = "◯";
            case 5 -> board[1][2] = "◯";
            case 6 -> board[2][0] = "◯";
            case 7 -> board[2][1] = "◯";
            case 8 -> board[2][2] = "◯";
        }
    }

    private boolean spotIsTaken(int index) {  // TO NAPRAWIC
        String line;
        switch (index) {
            case 0 -> {
                line = board[0][0];
                if ("X".equals(line) || "◯".equals(line))
                    return true;
            }
            case 1 -> {
                line = board[0][1];
                if ("X".equals(line) || "◯".equals(line))
                    return true;
            }
            case 2 -> {
                line = board[0][2];
                if ("X".equals(line) || "◯".equals(line))
                    return true;
            }
            case 3 -> {
                line = board[1][0];
                if ("X".equals(line) || "◯".equals(line))
                    return true;
            }
            case 4 -> {
                line = board[1][1];
                if ("X".equals(line) || "◯".equals(line))
                    return true;
            }
            case 5 -> {
                line = board[1][2];
                if ("X".equals(line) || "◯".equals(line))
                    return true;
            }
            case 6 -> {
                line = board[2][0];
                if ("X".equals(line) || "◯".equals(line))
                    return true;
            }
            case 7 -> {
                line = board[2][1];
                if ("X".equals(line) || "◯".equals(line))
                    return true;
            }
            case 8 -> {
                line = board[2][2];
                if ("X".equals(line) || "◯".equals(line))
                    return true;
            }
        }
        return false;
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

    private void announceWinner() {
        if (playerWon()) {

        }


    }

    private boolean playerWon() {
        for (int i = 0; i < 8; i++) {
            String line = " ";
            switch (i) {
                case 0 -> line = board[0][0] + board[0][1] + board[0][2];
                case 1 -> line = board[1][0] + board[1][1] + board[1][2];
                case 2 -> line = board[2][0] + board[2][1] + board[2][2];
                case 3 -> line = board[0][0] + board[1][0] + board[2][0];
                case 4 -> line = board[0][1] + board[1][1] + board[2][1];
                case 5 -> line = board[0][2] + board[1][2] + board[2][2];
                case 6 -> line = board[0][0] + board[1][1] + board[2][2];
                case 7 -> line = board[0][2] + board[1][1] + board[2][0];

            }
            if ("XXX".equals(line)) {
                System.out.println("Player X has won the game");
                return true;
            } else if ("◯◯◯".equals(line)) {
                System.out.println("Player ◯ has won the game");
                return true;
            }
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
