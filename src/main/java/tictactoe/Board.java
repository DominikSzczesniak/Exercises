package tictactoe;

public class Board {
    final String[][] board = {{"0", "1", "2"}, {"3", "4", "5"}, {"6", "7", "8"}};

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

    boolean spotIsTaken(final int index) {
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

    boolean playerWon() {
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

}
