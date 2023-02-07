package net.prep.screen.tech.matrix.rotation;

public class MatrixRotator {

    public String[][] rotate(String[][] source, int count) {
        int actualCount = count % 4;
        String[][] matrix = new String[source.length][source[0].length];
        deepCopy(source, matrix);

        for (int i = 0; i < actualCount; i++) {
            matrix = rotate(matrix);
        }

        return matrix;
    }

    private void deepCopy(String[][] source, String[][] target) {
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, target[i], 0, source[i].length);
        }
    }

    private String[][] rotate(String[][] source) {

        String[][] result = new String[source[0].length][source.length];

        int sRow, sCol, tRow, tCol;

        for (sCol = 0, tRow = 0; sCol < source[0].length; sCol++, tRow++ ) {
            for (sRow = source.length - 1, tCol = 0; sRow >= 0; sRow--, tCol++) {
                result[tRow][tCol] = source[sRow][sCol];
            }
        }

        return result;
    }

}
