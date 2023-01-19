package net.prep.screen.tech.min.array.difference;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution sut = new Solution();

    @Test
    public void testTrivialCase() {
        assertEquals(0, sut.minArrayDifference(new int[]{1}, new int[]{1}));
    }

    @Test
    public void testArraysWithUniqueValues() {
        assertEquals(1, sut.minArrayDifference(new int[]{1,3,7,15}, new int[]{5,9,16}));
    }

}