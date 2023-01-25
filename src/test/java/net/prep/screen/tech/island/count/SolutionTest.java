package net.prep.screen.tech.island.count;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution sut = new Solution();

    @Test
    public void testEmptyGrid() {
        int[][] grid = new int[][]{{}};

        assertEquals(0, sut.islandCount(grid));
    }
    @Test
    public void testGridWithoutIslands() {
        int[][] grid = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

        assertEquals(0, sut.islandCount(grid));
    }

    @Test
    public void testGridWithOneIsland() {
        int[][] grid = new int[][]{{0, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertEquals(1, sut.islandCount(grid));

        grid = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}};
        assertEquals(1, sut.islandCount(grid));
    }

  @Test
  public void testGridWithSeveralIslands() {
        int[][] grid = new int[][]{ {0, 1, 0, 1, 0},
                                    {1, 1, 0, 1, 0},
                                    {0, 1, 0, 0, 0},
                                    {1, 0, 1, 1, 0},
                                    {0, 0, 0, 0, 1},
        };
        assertEquals(5, sut.islandCount(grid));
    }

    @Test
    public void testIslandThatTakesUpTheGrid() {
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
        };
        assertEquals(1, sut.islandCount(grid));
    }
}