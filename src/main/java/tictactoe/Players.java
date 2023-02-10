package tictactoe;

import java.util.Scanner;

public class Players {
    String symbolOne = "◯";
    String nameOne;
    String symbolTwo = "X";
    String nameTwo;
    Scanner scan = new Scanner(System.in);


    String getNameOne() {
        return nameOne;
    }

    String getNameTwo() {
        return nameTwo;
    }

    void setNames() {
        System.out.println("First player, enter your name");
        nameOne = scan.nextLine();
        System.out.println("Second player, enter your name");
        nameTwo = scan.nextLine();
    }

    String getSymbolOne() {
        return symbolOne;
    }

    String getSymbolTwo() {
        return symbolTwo;
    }

    void setSymbols() {
        System.out.println("Player one, if you want to use standard symbol 'O' enter 1, if you want to use first letter of your name enter 2");
        int choiceOne = scan.nextInt();
        if (choiceOne == 2) {
            symbolOne = String.valueOf(nameOne.charAt(0));
        }

        System.out.println("Player two, if you want to use standard symbol 'X' enter 1, if you want to use first letter of your name enter 2");
        int choiceTwo = scan.nextInt();
        if (choiceTwo == 2) {
            symbolTwo = String.valueOf(nameTwo.charAt(0));
        }
    }
}
