package fizzbuzz;

public class FizzBuzz {

    public void print(int number) {
        System.out.println(number + " - " + execute(number));
    }


    public String execute(int number) {
        if (number % 5 == 0 && number % 3 == 0) {
            return "FizzBuzz";
        }
        else if (number % 3 == 0) {
            return "Fizz";
        }
        else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }
}