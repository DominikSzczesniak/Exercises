package stringofnumbers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathematicalOperationTest {

    MathematicalOperation test;

    @BeforeEach
    void setUp() {
        test = new MathematicalOperation();
    }

    @Test
    void shouldEqualFour() {
        // expect
        assertEquals(4, test.action("2,2;+"));
    }

    @Test
        // expect
    void shouldEqualMinusSix() {
        assertEquals(-6, test.action("2.4,-"));
    }

    @Test
    void shouldEqualFiftySix() {
        // expect
        assertEquals(56, test.action("2.4,7,*"));
    }

    @Test
    void shouldEqualFive() {
        // expect
        assertEquals(5, test.action("100.4,5,/"));
    }

    @Test
    void shouldReturnZero() {
        // expect
        assertEquals(0, test.action("1,3,523,754632,53"));
        assertEquals(0, test.action("1,3,523,754632,53,l"));
        assertEquals(0, test.action("1,3,523,754632,53, "));
    }

}