import java.util.Random;

public class MatrixAdvancedOperations {

    // Create random matrix
    static double[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(9) + 1;
            }
        }
        return matrix;
    }

    // Transpose of matrix
    static double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transpose = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    // Determinant of 2x2
    static double determinant2x2(double[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }

    // Determinant of 3x3
    static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1]*m[2][2] - m[1][2]*m[2][1])
             - m[0][1] * (m[1][0]*m[2][2] - m[1][2]*m[2][0])
             + m[0][2] * (m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    // Inverse of 2x2
    static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) return null;

        double[][] inv = new double[2][2];
        inv[0][0] =  m[1][1] / det;
        inv[0][1] = -m[0][1] / det;
        inv[1][0] = -m[1][0] / det;
        inv[1][1] =  m[0][0] / det;

        return inv;
    }

    // Inverse of 3x3
    static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) return null;

        double[][] adj = new double[3][3];

        adj[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]);
        adj[0][1] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
        adj[0][2] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]);

        adj[1][0] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]);
        adj[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]);
        adj[1][2] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]);

        adj[2][0] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]);
        adj[2][1] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]);
        adj[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]);

        double[][] inv = transposeMatrix(adj);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inv[i][j] /= det;
            }
        }
        return inv;
    }

    // Display matrix
    static void displayMatrix(double[][] matrix) {
        if (matrix == null) {
            System.out.println("Inverse not possible");
            return;
        }
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.2f ", value);
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {

        double[][] m2 = createRandomMatrix(2, 2);
        double[][] m3 = createRandomMatrix(3, 3);

        displayMatrix(m2);
        displayMatrix(transposeMatrix(m2));
        System.out.println(determinant2x2(m2));
        displayMatrix(inverse2x2(m2));

        displayMatrix(m3);
        displayMatrix(transposeMatrix(m3));
        System.out.println(determinant3x3(m3));
        displayMatrix(inverse3x3(m3));
    }
}
