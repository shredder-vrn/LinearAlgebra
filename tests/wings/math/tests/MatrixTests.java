package wings.math.tests;

import org.junit.jupiter.api.Test;
import wings.math.matrices.Matrix;
import wings.math.matrices.Matrix3x3;
import wings.math.matrices.Matrix4x4;
import wings.math.vectors.Vector;
import wings.math.vectors.Vector3;

import static org.junit.jupiter.api.Assertions.*;


public class MatrixTests {

    // Тесты на матрицы 3х3

    @Test
    public void testAdd3x3() {
        Matrix matrix1 = new Matrix3x3(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Matrix matrix2 = new Matrix3x3(new float[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });
        Matrix result = matrix1.add(matrix2);
        Matrix expected = new Matrix3x3(new float[][]{
                {10, 10, 10},
                {10, 10, 10},
                {10, 10, 10}
        });
        assertEquals(expected, result);
    }

    @Test
    public void testAdd3x3Exception() {
        //...
    }


    @Test
    public void testSubtract3x3() {
        Matrix matrix1 = new Matrix3x3(new float[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });
        Matrix matrix2 = new Matrix3x3(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Matrix result = matrix1.subtract(matrix2);
        Matrix expected = new Matrix3x3(new float[][]{
                {8, 6, 4},
                {2, 0, -2},
                {-4, -6, -8}
        });
        assertEquals(expected, result);
    }

    @Test
    public void testSubtract3x3Exception() {
        //...
    }

    @Test
    public void testMultiply3x3() {
        Matrix matrix1 = new Matrix3x3(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Matrix matrix2 = new Matrix3x3(new float[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });
        Matrix result = matrix1.multiply(matrix2);
        Matrix expected = new Matrix3x3(new float[][]{
                {30, 24, 18},
                {84, 69, 54},
                {138, 114, 90}
        });
        assertEquals(expected, result);
    }

    @Test
    public void testMultiply3x3Exception() {
        //...
    }

    @Test
    public void test2Multiply3x3() {
        Matrix matrix = new Matrix3x3(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Vector3 vector = new Vector3(1, 2, 3);
        Vector result = matrix.multiply(vector);
        Vector expected = new Vector3(14, 32, 50);
        assertEquals(expected, result);
    }

    @Test
    public void test2Multiply3x3Exception() {
        // ...
    }

    @Test
    public void testTranspose3x3() {
        Matrix matrix = new Matrix3x3(new float[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        Matrix result = matrix.transpose();
        Matrix expected = new Matrix3x3(new float[][]{
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        });
        assertEquals(expected, result);
    }

    @Test
    public void testIdentityMatrix3x3() {
        Matrix identityMatrix = Matrix3x3.identity();
        Matrix expectedMatrix = new Matrix3x3(new float[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        });
        assertEquals(expectedMatrix, identityMatrix);
    }

    @Test
    public void testZeroMatrix3x3() {
        Matrix zeroMatrix = Matrix3x3.zero();
        Matrix expectedMatrix = new Matrix3x3(new float[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
        assertEquals(expectedMatrix, zeroMatrix);
    }
}
