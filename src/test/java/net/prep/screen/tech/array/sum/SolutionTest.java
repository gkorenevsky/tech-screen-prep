package net.prep.screen.tech.array.sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution sut = new Solution();

    private final int[] testArray = new int[]{1, 2, 5, 7, 100, 10, 11, 12, 101};
    private final int[] emptyArray = new int[0];

    @Test
    public void mustFindInSingletonArray() {
        int[] result = sut.getSubArray(new int[]{3}, 3);
        assertArrayEquals(new int[]{3}, result);
    }

    @Test
    public void mustNotFindInSingletonArray() {
        int[] result = sut.getSubArray(new int[]{3}, 10);
        assertArrayEquals(emptyArray, result);
    }

    @Test
    public void mustFindRegularRunningSum() {
        int[] result = sut.getSubArray(testArray, 15);
        assertArrayEquals(new int[]{1,2,5,7}, result);
    }

    @Test
    public void mustFindLastRegularRunningSum() {
        int[] result = sut.getSubArray(testArray, 249);
        assertArrayEquals(testArray, result);
    }

    @Test
    public void mustNotFindSum() {
        int[] result = sut.getSubArray(testArray, 88);
        assertArrayEquals(emptyArray, result);
        result = sut.getSubArray(testArray, 1000);
        assertArrayEquals(emptyArray, result);
        result = sut.getSubArray(testArray, 109);
        assertArrayEquals(emptyArray, result);
    }

    @Test
    public void mustFindSubArray() {
        int[] result = sut.getSubArray(testArray, 121);
        assertArrayEquals(new int[]{100, 10, 11}, result);
    }

    @Test
    public void mustFindAnotherSubArray() {
        int[] result = sut.getSubArray(testArray, 112);
        assertArrayEquals(new int[]{5, 7, 100}, result);
    }

    @Test
    public void mustFindYetOtherSubArrays() {
        int[] result = sut.getSubArray(testArray, 122);
        assertArrayEquals(new int[]{5, 7, 100, 10}, result);

        result = sut.getSubArray(testArray, 14);
        assertArrayEquals(new int[]{2, 5, 7}, result);

        result = sut.getSubArray(testArray, 113);
        assertArrayEquals(new int[]{12, 101}, result);
    }

    @Test
    public void checkArraysWithNegativeNumbers() {
        int[] input = new int[]{1, 2, 5, -8, 100, 10, 11, 12, 101};
        assertArrayEquals(new int[]{2, 5}, sut.getSubArray(input, 7));

        assertArrayEquals(new int[]{-8, 100}, sut.getSubArray(input, 92));
        assertArrayEquals(new int[]{5, -8, 100, 10, 11}, sut.getSubArray(input, 118));
    }

    @Test
    public void checkArraysWithMoreNegativeNumbers() {
        int[] input = new int[]{1, 2, 5, -8, 100, 10, 11, -12, -101};
        assertArrayEquals(new int[]{-12, -101}, sut.getSubArray(input, -113));
    }

}