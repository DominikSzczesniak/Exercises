package tictactoe;

public class Board {
    final String[][] board = {{"0", "1", "2"}, {"3", "4", "5"}, {"6", "7", "8"}};

    Players players = new Players();

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
                if (players.getSymbolTwo().equals(line) || players.getSymbolOne().equals(line))
                    return true;
            }
            case 1 -> {
                line = board[0][1];
                if (players.getSymbolTwo().equals(line) || players.getSymbolOne().equals(line))
                    return true;
            }
            case 2 -> {
                line = board[0][2];
                if (players.getSymbolTwo().equals(line) || players.getSymbolOne().equals(line))
                    return true;
            }
            case 3 -> {
                line = board[1][0];
                if (players.getSymbolTwo().equals(line) || players.getSymbolOne().equals(line))
                    return true;
            }
            case 4 -> {
                line = board[1][1];
                if (players.getSymbolTwo().equals(line) || players.getSymbolOne().equals(line))
                    return true;
            }
            case 5 -> {
                line = board[1][2];
                if (players.getSymbolTwo().equals(line) || players.getSymbolOne().equals(line))
                    return true;
            }
            case 6 -> {
                line = board[2][0];
                if (players.getSymbolTwo().equals(line) || players.getSymbolOne().equals(line))
                    return true;
            }
            case 7 -> {
                line = board[2][1];
                if (players.getSymbolTwo().equals(line) || players.getSymbolOne().equals(line))
                    return true;
            }
            case 8 -> {
                line = board[2][2];
                if (players.getSymbolTwo().equals(line) || players.getSymbolOne().equals(line))
                    return true;
            }
        }
        return false;
    }

    boolean gameIsOver() {
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
            if ((players.getSymbolTwo() + players.getSymbolTwo() + players.getSymbolTwo()).equals(line)) {
                System.out.println(players.getNameTwo() + " has won the game");
                return true;
            } else if ((players.getSymbolOne() + players.getSymbolOne() + players.getSymbolOne()).equals(line)) {
                System.out.println(players.getNameOne() + " has won the game");
                return true;
            }
        }
        return false;
    }

    boolean isDraw() {
        int spotsTaken = 0;
        for (int i = 0; i < 9; i++) {
            if (spotIsTaken(i)) {
                spotsTaken++;
            }
        }
        if (spotsTaken == 9) {
            return true;
        } else {
            return false;
        }
    }
}

