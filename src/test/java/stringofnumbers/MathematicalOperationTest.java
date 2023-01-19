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
        assertEquals(4, test.action("2,2;+"));
    }

    @Test
    void shouldEqualMinusSix() {
        assertEquals(-6, test.action("2.4,-"));
    }

    @Test
    void shouldReturnZero() {
        assertEquals(0, test.action("1,3,523,754632,53"));
        assertEquals(0, test.action("1,3,523,754632,53,l"));
        assertEquals(0, test.action("1,3,523,754632,53,/"));
    }

}