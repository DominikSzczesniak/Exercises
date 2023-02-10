package fizzbuzz;

public class FizzBuzzApp {

    public static void main(String[] args) {
        FizzBuzz game = new FizzBuzz();

        for (int i = 1; i <= 100; i++) {
            game.print(i);
        }

    }
}
