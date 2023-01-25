package net.prep.screen.tech.island.count;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public record Cell(int x, int y) {
    }

    private final Set<Cell> cellSet = new HashSet<>();

    public int islandCount(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int islandCount = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (checkIsland(grid, i, j)) {
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private boolean checkIsland(int[][] grid, int i, int j) {

        if (grid[i][j] != 1) {
            return false;
        }

        if (cellSet.contains(new Cell(i, j))) {
            return false;
        }

        cellSet.add(new Cell(i, j));

        if (j > 0) {
            checkIsland(grid, i, j - 1);
        }

        if (j + 1 < grid[i].length) {
            checkIsland(grid, i, j + 1);
        }

        if (i + 1 < grid.length) {
            checkIsland(grid, i + 1, j);
        }

        if (i > 0) {
            checkIsland(grid, i - 1, j);
        }

        return true;
    }
}
