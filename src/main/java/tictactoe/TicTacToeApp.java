package tictactoe;

public class TicTacToeApp {

    public static void main(String[] args) {

        Game game = new Game();
        game.assignNames();
        game.assignSymbols();
        game.playTheGame();

    }
}
