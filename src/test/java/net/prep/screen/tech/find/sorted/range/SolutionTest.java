package net.prep.screen.tech.find.sorted.range;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    final Solution sut = new Solution();
    @Test
    void searchRangeMultiElementNoRepetition() {

        final int[] testArray = new int[] {0, 1, 2, 3, 4};
        var result = sut.searchRange(testArray, 3);
        assertArrayEquals(new int[] {3, 3}, result);
    }

    @Test
    void searchRangeMultiElementSingleRepetition() {

        final int[] testArray = new int[] {0, 1, 2, 3, 3, 4};
        var result = sut.searchRange(testArray, 3);
        assertArrayEquals(new int[] {3, 4}, result);
    }

    @Test
    void searchRangeMultiElementMultiRepetitionInTheMiddle() {

        final int[] testArray = new int[] {0, 1, 2, 3, 3, 3, 3, 4};
        var result = sut.searchRange(testArray, 3);
        assertArrayEquals(new int[] {3, 6}, result);
    }

    @Test
    void searchRangeMultiElementMultiRepetitionInTheBeginning() {

        final int[] testArray = new int[] {3, 3, 3, 3, 4, 5, 6, 7};
        var result = sut.searchRange(testArray, 3);
        assertArrayEquals(new int[] {0, 3}, result);
    }

    @Test
    void searchRangeMultiElementMultiRepetitionAtTheEnd() {

        final int[] testArray = new int[] {0, 1, 2, 3, 3, 3, 3};
        var result = sut.searchRange(testArray, 3);
        assertArrayEquals(new int[] {3, 6}, result);
    }
}