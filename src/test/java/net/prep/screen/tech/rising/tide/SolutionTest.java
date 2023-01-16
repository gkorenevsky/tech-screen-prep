package net.prep.screen.tech.rising.tide;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution sut = new Solution();

    @Test
    public void checkTrivialCase() {
        int[][] grid = new int[][]{{1}, {1}};
        int result =  sut.getMinWaterHeight(grid);
        assertEquals(1,result);
    }

    @Test
    public void checkAnotherTrivialCase() {
        int[][] grid = new int[][]{{1, 1}, {1, 1}};
        int result = sut.getMinWaterHeight(grid);
        assertEquals(1, result);
    }

    @Test
    public void checkSimpleCase() {
        int[][] grid = new int[][]{{Integer.MAX_VALUE, 3, 2}, {3, 1, 3}, {3, 1, Integer.MAX_VALUE}};
        int result = sut.getMinWaterHeight(grid);
        assertEquals(2, result);
    }

    @Test
    public void checkMoreComplexCase() {
// # S 5 4 5 5
// # 4 2 5 1 1
// # 5 5 2 1 5
// # 2 3 2 4 4
// # 5 4 5 5 E
        int[][] grid = new int[][]{{Integer.MAX_VALUE, 5, 4, 5, 5},
                {4, 2, 5, 1, 1},
                {5, 5, 2, 1, 5},
                {2, 3, 2, 4, 4},
                {5, 4, 5, 5, Integer.MAX_VALUE}};

        int result = sut.getMinWaterHeight(grid);
        assertEquals(3, result);
    }


}