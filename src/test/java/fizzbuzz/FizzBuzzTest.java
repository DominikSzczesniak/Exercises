package fizzbuzz;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {

    private final FizzBuzz tut = new FizzBuzz();

    @Test
    void should_return_FizzBuzz() {
        // expect
        assertThat(tut.execute(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void should_return_Fizz() {
        // expect
        assertThat(tut.execute(9)).isEqualTo("Fizz");
    }

    @Test
    void should_return_Buzz() {
        // expect
        assertThat(tut.execute(-55)).isEqualTo("Buzz");
    }

    @Test
    void should_return_number() {
        // expect
        assertThat(tut.execute(2)).isEqualTo("2");
    }

}