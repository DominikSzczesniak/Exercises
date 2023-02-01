package tictactoe;

import java.util.Scanner;

public class Placement {
    Scanner scan = new Scanner(System.in);


    int getIndex() {
        int index = scan.nextInt();
        if (index < 0 || index > 8) {
            do {
                System.out.println("Position out of bounds, choose number between 0-8");
                index = scan.nextInt();
            } while (index < 0 || index > 8);
        }
        return index;
    }
}
