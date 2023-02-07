package net.prep.screen.tech.matrix.rotation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixRotatorTest {

    MatrixRotator sut = new MatrixRotator();

    String[][] rectangularMatrix = new String[][] {{"A", "B", "C", "D"}, {"E", "F", "G", "H"}};
    String[][] squareMatrix = new String[][] {{"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"}};

    @Test
    public void testSingleRotationOfRectangularMatrix() {

        var result = sut.rotate(rectangularMatrix, 1);
        assertEquals(0, deepCompare(result, new String[][]{{"E", "A"}, {"F", "B"}, {"G", "C"}, {"H", "D"}}));
    }

    @Test
    public void testDoubleRotationOfRectangularMatrix() {

        var result = sut.rotate(rectangularMatrix, 2);
        assertEquals(0, deepCompare(result, new String[][]{{"H", "G", "F", "E"}, {"D", "C", "B", "A"}}));
    }

    @Test
    public void testTripleRotationOfRectangularMatrix() {

        var result = sut.rotate(rectangularMatrix, 3);
        assertEquals(0, deepCompare(result, new String[][]{{"D", "H"}, {"C", "G"}, {"B", "F"}, {"A", "E"}}));
    }

    @Test
    public void testQuadrupleRotationOfRectangularMatrix() {

        var result = sut.rotate(rectangularMatrix, 4);
        assertEquals(0, deepCompare(result, rectangularMatrix));
    }

    @Test
    public void testSingleRotationOfSquareMatrix() {

        var result = sut.rotate(squareMatrix, 1);
        assertEquals(0, deepCompare(result, new String[][]{{"G", "D", "A"}, {"H", "E", "B"}, {"I", "F", "C"}}));
    }

    @Test
    public void testDoubleRotationOfSquareMatrix() {

        var result = sut.rotate(squareMatrix, 2);
        assertEquals(0, deepCompare(result, new String[][]{{"I", "H", "G"}, {"F", "E", "D"}, {"C", "B", "A"}}));
    }

    @Test
    public void testTripleRotationOfSquareMatrix() {

        var result = sut.rotate(squareMatrix, 3);
        assertEquals(0, deepCompare(result, new String[][]{{"C", "F", "I"}, {"B", "E", "H"}, {"A", "D", "G"}}));
    }

    @Test
    public void testQuadrupleRotationOfSquareMatrix() {

        var result = sut.rotate(squareMatrix, 4);
        assertEquals(0, deepCompare(result, squareMatrix));
    }

    private int deepCompare(String[][] source, String[][] target) {
        int result = 0;
        for (int i = 0; i < source.length && result == 0; i++) {
            result = Arrays.compare(source[i], target[i]);
        }

        return result;
    }

}