package arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] isZero = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) isZero[i][j] = true;
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(isZero[i][j]) {
                    int counter = 0;
                    while(counter < m) {
                        matrix[i][counter] = 0;
                        counter++;
                    }

                    counter = 0;
                    while(counter < n) {
                        matrix[counter][j] = 0;
                        counter++;
                    }
                }
            }
        }
    }
}
