package net.prep.screen.tech.rising.tide;

import java.util.*;

// # Rising Tide
// #
// # Given a grid of land heights, find the minimum water height that disconnects the start and end

// # Constraints
// # A path between start and end cannot go diagonally between landmasses
// # A path cannot traverse cells that are underwater.
// # A cell is underwater if their height less than or equal to the current water level.

// # Example:
// # S 5 4 5 5
// # 4 2 5 1 1
// # 5 5 2 1 5
// # 2 3 2 4 4
// # 5 4 5 5 E

// # Water Height 1
// # .....
// # ...XX
// # ...X.
// # .....
// # .....

// # Water Height 2
// # .....
// # .X.XX
// # ..XX.
// # X.X..
// # .....

// # Water Height 3
// # .....
// # .X.XX
// # ..XX.
// # XXX..
// # .....

// etc...

// Approach: pour water to the level below the highest level, then check if there exists a path from source to target at that level.
// Repeat for all lower levels until either a path is found or the lowest level is reached.
// Algorithm:
// 1. Search through the matrix and accumulate all the different heights
// 2. Sort heights in descending order
// 3. Iterate through the list of heights and check if a path exists
//
// For simplicity we are assuming the search starts in the top row and
// ends in the bottom row. If arbitrary cells can be designated as origin/destination
// then the following implementation can be extended.

public class Solution {

    //START PROBLEM HERE
    record Cell (int row, int col) {}

    // Define direction of grid traversal. This prevents creation of cycles, assuming
    // traversal is only down, left or right
    enum Direction {
        Left,
        Right,
        Down,
        Up,
        None
    }

    // The main driver method which returns the desired min. water height
    public int getMinWaterHeight(int[][] grid) {

        // get grid dimensions
        int nRows = grid.length;
        int nCols = grid[0].length;

        Set<Integer> heights = collectHeights(grid, nRows, nCols);

        // Quick heuristic:
        // if all cells are the same height, then return that height
        if (heights.size() == 1) {
            return heights.stream().findFirst().get();
        }

        Optional<Integer> minHeight = heights.stream().filter(h -> !existsPathForHeight(h, grid, nRows, nCols)).findFirst();

        return minHeight.get();
    }

    // This method begins grid traversal for height h. All cells with values <= h are considered
    // to be "blocking" cells, disallowing further traversal
    private boolean existsPathForHeight(int h, int[][] grid, int nRows, int nCols) {
        Cell currCell = new Cell(0,0);
        Cell target = new Cell(nRows - 1, nCols - 1);
        boolean result = existsPathForHeight(h, grid, nRows, nCols, currCell, Direction.None);
        return result;
    }

    // This method performs the recursive traversal of the grid using height h, starting at a given cell,
    // then recursively evaluating paths starting with the cells immediately below, to the right and, finally,
    // to the left of the current cell. If a current cell is not "blocking" and there exists a path through either
    // bottom, right or left cell, then the current cell is considered to be a part of the allowed path from
    // the origin to the destination
    private boolean existsPathForHeight(int h, int[][] grid, int nRows, int nCols, Cell currCell, Direction dir) {

        // check if this is the destination cell
        if ((currCell.row() == nRows - 1) && (currCell.col() == nCols - 1)) {
            return true;
        }

        // check if this cell is underwater
        if (grid[currCell.row()][currCell.col()] <= h) {
            return false;
        }

        boolean checkLeft = (dir != Direction.Right) && (currCell.col() > 0);
        boolean checkRight = (dir != Direction.Left) && (currCell.col < nCols - 1);
        boolean checkDown = (dir != Direction.Up) && (currCell.row < nRows - 1);

        boolean result = (
                (checkDown && existsPathForHeight(h, grid, nRows, nCols, new Cell(currCell.row() + 1, currCell.col()), Direction.Down))
                        || (checkRight && existsPathForHeight(h, grid, nRows, nCols, new Cell(currCell.row(), currCell.col() + 1), Direction.Right))
                        || (checkLeft && existsPathForHeight(h, grid, nRows, nCols, new Cell(currCell.row(), currCell.col() - 1), Direction.Left))
        );

        return result;
    }

    // Collect all unique heights in the grid
    private Set<Integer> collectHeights(int[][] grid, int nRows, int nCols) {

        Set<Integer> result = new TreeSet<Integer>();

        for (int[] row : grid) {
            for (int h : row) {
                if (h != Integer.MAX_VALUE) {
                    result.add(h);
                }
            }
        }

        return result;
    }

}
