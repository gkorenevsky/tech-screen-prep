package net.prep.screen.tech.longest.palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution sut = new Solution();

    @Test
    public void testSingleChar() {
        assertEquals(1, sut.longestPalindrome("a"));
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, sut.longestPalindrome(""));
    }

    @Test
    public void testTwoIdenticalChars() {
        assertEquals(2, sut.longestPalindrome("aa"));
    }

    @Test
    public void testTwoDifferentChars() {
        assertEquals(1, sut.longestPalindrome("ab"));
    }

    @Test
    public void testThreeCharPal() {
        assertEquals(3, sut.longestPalindrome("aab"));
        assertEquals(3, sut.longestPalindrome("baa"));
        assertEquals(3, sut.longestPalindrome("aba"));
        assertEquals(3, sut.longestPalindrome("aaa"));
        assertEquals(3, sut.longestPalindrome("abb"));
    }

    @Test
    public void testSomeString() {
        assertEquals(7, sut.longestPalindrome("abccccdd"));
    }
}