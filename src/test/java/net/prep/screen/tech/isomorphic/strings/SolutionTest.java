package net.prep.screen.tech.isomorphic.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution sut = new Solution();

    @Test
    public void testTrueIsomorphicStringPair() {
        boolean result = sut.isIsomorphic("egg", "add");
        assertTrue(result);
    }

    @Test
    public void testAnotherIsomorphicStringPair() {
        boolean result = sut.isIsomorphic("paper", "title");
        assertTrue(result);
    }

    @Test
    public void testNonIsomorphicStringPair() {
        boolean result = sut.isIsomorphic("foo", "bar");
        assertFalse(result);
    }

    @Test
    public void testAnotherNonIsomorphicStringPair() {
        boolean result = sut.isIsomorphic("egcd", "adfd");
        assertFalse(result);
    }

}