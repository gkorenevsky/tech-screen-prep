package net.prep.screen.tech.eval.via.tree.expression;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    @Test
    public void testSimpleAddition() {
        Solution sut = new Solution("2 + 3");
        float result = sut.evaluate("2 + 3");
        assertEquals(5.0f, result);
    }

    @Test
    public void testSimpleMult() {
        Solution sut = new Solution("2 x 3");
        float result = sut.evaluate("2 x 3");
        assertEquals(6.0f, result);
    }

    @Test
    public void testSimpleSub() {
        Solution sut = new Solution("2 - 3");
        float result = sut.evaluate("2 - 3");
        assertEquals(-1.0f, result);
    }

    @Test
    public void testSimpleDiv() {
        Solution sut = new Solution("6 / 3");
        float result = sut.evaluate("6 / 3");
        assertEquals(2.0f, result);
    }

    @Test
    public void testSimpleAddAndMult() {
        Solution sut = new Solution("2 + 3 x 4");
        float result = sut.evaluate("2 + 3 x 4");
        assertEquals(14.0f, result);
    }

    @Test
    public void testSubtraction() {
        Solution sut = new Solution("8 - 2 + 3");
        float result = sut.evaluate("8 - 2 + 3");
        assertEquals( 9.0f, result);
    }

    @Test
    public void testComplexAddAndMultAndDiv() {
        Solution sut = new Solution("4 + 4 x 3 x 2 / 5");
        float result = sut.evaluate("4 + 4 x 3 x 2 / 5");
        assertEquals(8.8f, result);
    }

    @Test
    public void testAnotherComplexAddAndMult() {
        Solution sut = new Solution("2.5 x 2 + 3.5");
        float result = sut.evaluate("2.5 x 2 + 3.5");
        assertEquals(8.5f, result);
    }
}