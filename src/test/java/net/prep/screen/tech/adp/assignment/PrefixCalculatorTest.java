package net.prep.screen.tech.adp.assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrefixCalculatorTest {

    PrefixCalculator sut = new PrefixCalculator();


    @Test
    public void testAddition() {
        int result = sut.evaluateExpr("( + 3 2 )");
        assertEquals(5, result);
    }

    @Test
    public void testDiv() {
        int result = sut.evaluateExpr("( / 4 2 )");
        assertEquals(2, result);
    }

    @Test
    public void testMult() {
        int result = sut.evaluateExpr("( * 4 2 )");
        assertEquals(8, result);
    }
    @Test
    public void testSub() {
        int result = sut.evaluateExpr("( - 10 2 )");
        assertEquals(8, result);
    }

}

// tokenize input
// create two stacks: operator stack, operand stack