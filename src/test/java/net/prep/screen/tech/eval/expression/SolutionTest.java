package net.prep.screen.tech.eval.expression;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution sut;

    @BeforeEach
    public void setUp() {
        sut = new Solution();
    }

    @Test
    public void testSingleNumberExpression() {
        sut.setExpression("12");
        assertEquals(12, sut.evalString());
    }

    @Test
    public void testSingleAdditionExpression() {
        sut.setExpression("1 + 2");
        assertEquals(3, sut.evalString());
    }

    @Test
    public void testSingleSubtractionExpression() {
        sut.setExpression("2 - 1");
        assertEquals(1, sut.evalString());
    }

    @Test
    public void testSingleMultiplicationExpression() {
        sut.setExpression("2 * 3");
        assertEquals(6, sut.evalString());
    }

    @Test
    public void testMultipleAdditionExpression() {
        sut.setExpression("1 + 2 + 3 + 4 + 5");
        assertEquals(15, sut.evalString());
    }

    @Test
    public void testMultipleMultiplicationExpression() {
        sut.setExpression("1 * 2 * 3 * 4 * 5");
        assertEquals(120, sut.evalString());
    }

    @Test
    public void testMixedAdditionAndMultiplicationExpression() {
        sut.setExpression("1 + 2 * 3 + 4 * 5 - 3");
        assertEquals(24, sut.evalString());
    }

    @Test
    public void testMixedAdditionAndMultiplicationWithParenthesesExpression() {
        sut.setExpression("( 1 + 2 ) * ( 3 + 4 ) * 5 - 3");
        assertEquals(102, sut.evalString());
    }

    @Test
    public void testMixedOperationsWithParenthesesExpression() {
        sut.setExpression("( 1 * 2 ) + ( 3 * 4 ) + 5 - 3");
        assertEquals(16, sut.evalString());
    }

    @Test
    public void testComplexExpression() {
        sut.setExpression("( 1 + 2 + 3 ) * ( 3 * 4 * 5 ) * 6 - 3 - 2 + 11 * 2");
        assertEquals(2177, sut.evalString());
    }



}