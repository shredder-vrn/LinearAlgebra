package wings.math.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wings.math.matrices.Matrix;
import wings.math.matrices.Matrix3x3;
import wings.math.matrices.Matrix4x4;
import wings.math.vectors.Vector;
import wings.math.vectors.Vector3;
import wings.math.vectors.Vector4;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MatrixTests {
/*

    // Тесты на матрицы 3х3

    @Test
    public void testAdd3x3() {
        Matrix matrix1 = new Matrix3x3(new float[][]{
                {1.0f, 2.0f, 3.0f},
                {4.0f, 5.0f, 6.0f},
                {7.0f, 8.0f, 9.0f}
        });
        Matrix matrix2 = new Matrix3x3(new float[][]{
                {9.0f, 8.0f, 7.0f},
                {6.0f, 5.0f, 4.0f},
                {3.0f, 2.0f, 1.0f}
        });
        Matrix result = matrix1.add(matrix2);
        Matrix expected = new Matrix3x3(new float[][]{
                {10.0f, 10.0f, 10.0f},
                {10.0f, 10.0f, 10.0f},
                {10.0f, 10.0f, 10.0f}
        });
        assertEquals(expected, result);
    }

    @Test
    public void testAdd3x3Exception() {
        Matrix3x3 matrix3x3 = Matrix3x3.identity();
        Matrix4x4 matrix4x4 = Matrix4x4.identity();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> matrix3x3.add(matrix4x4));
        Assertions.assertEquals("Matrix3x3.add: матрица другой размерности.", exception.getMessage());
    }


    @Test
    public void testSubtract3x3() {
        Matrix matrix1 = new Matrix3x3(new float[][]{
                {9.0f, 8.0f, 7.0f},
                {6.0f, 5.0f, 4.0f},
                {3.0f, 2.0f, 1.0f}
        });
        Matrix matrix2 = new Matrix3x3(new float[][]{
                {1.0f, 2.0f, 3.0f},
                {4.0f, 5.0f, 6.0f},
                {7.0f, 8.0f, 9.0f}
        });
        Matrix result = matrix1.subtract(matrix2);
        Matrix expected = new Matrix3x3(new float[][]{
                {8.0f, 6.0f, 4.0f},
                {2.0f, 0.0f, -2.0f},
                {-4.0f, -6.0f, -8.0f}
        });
        assertEquals(expected, result);
    }

    @Test
    public void testSubtract3x3Exception() {
        Matrix3x3 matrix3x3 = Matrix3x3.identity();
        Matrix4x4 matrix4x4 = Matrix4x4.identity();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> matrix3x3.subtract(matrix4x4));
        Assertions.assertEquals("Matrix3x3.subtract: матрица другой размерности.", exception.getMessage());
    }

    @Test
    public void testMultiply3x3() {
        Matrix matrix1 = new Matrix3x3(new float[][]{
                {1.0f, 2.0f, 3.0f},
                {4.0f, 5.0f, 6.0f},
                {7.0f, 8.0f, 9.0f}
        });
        Matrix matrix2 = new Matrix3x3(new float[][]{
                {9.0f, 8.0f, 7.0f},
                {6.0f, 5.0f, 4.0f},
                {3.0f, 2.0f, 1.0f}
        });
        Matrix result = matrix1.multiply(matrix2);
        Matrix expected = new Matrix3x3(new float[][]{
                {30.0f, 24.0f, 18.0f},
                {84.0f, 69.0f, 54.0f},
                {138.0f, 114.0f, 90.0f}
        });
        assertEquals(expected, result);
    }

    @Test
    public void testMultiply3x3Exception() {
        Matrix3x3 matrix3x3 = Matrix3x3.identity();
        Matrix4x4 matrix4x4 = Matrix4x4.identity();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> matrix3x3.multiply(matrix4x4));
        Assertions.assertEquals("Matrix3x3.multiply: матрица другой размерности.", exception.getMessage());
    }

    @Test
    public void test2Multiply3x3() {
        Matrix matrix = new Matrix3x3(new float[][]{
                {1.0f, 2.0f, 3.0f},
                {4.0f, 5.0f, 6.0f},
                {7.0f, 8.0f, 9.0f}
        });
        Vector3 vector = new Vector3(1.0f, 2.0f, 3.0f);
        Vector result = matrix.multiply(vector);
        Vector expected = new Vector3(14.0f, 32.0f, 50.0f);
        assertEquals(expected, result);
    }

    @Test
    public void test2Multiply3x3Exception() {
        Matrix3x3 matrix3x3 = Matrix3x3.identity();
        Vector4 vector4 = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> matrix3x3.multiply(vector4));
        Assertions.assertEquals("Matrix3x3.multiply: вектор другой размерности.", exception.getMessage());
    }

    @Test
    public void testTranspose3x3() {
        Matrix matrix = new Matrix3x3(new float[][]{
                {1.0f, 2.0f, 3.0f},
                {4.0f, 5.0f, 6.0f},
                {7.0f, 8.0f, 9.0f}
        });
        Matrix result = matrix.transpose();
        Matrix expected = new Matrix3x3(new float[][]{
                {1.0f, 4.0f, 7.0f},
                {2.0f, 5.0f, 8.0f},
                {3.0f, 6.0f, 9.0f}
        });
        assertEquals(expected, result);
    }

    @Test
    public void testIdentityMatrix3x3() {
        Matrix identityMatrix = Matrix3x3.identity();
        Matrix expectedMatrix = new Matrix3x3(new float[][]{
                {1.0f, 0.0f, 0.0f},
                {0.0f, 1.0f, 0.0f},
                {0.0f, 0.0f, 1.0f}
        });
        assertEquals(expectedMatrix, identityMatrix);
    }

    @Test
    public void testZeroMatrix3x3() {
        Matrix zeroMatrix = Matrix3x3.zero();
        Matrix expectedMatrix = new Matrix3x3(new float[][]{
                {0.0f, 0.0f, 0.0f},
                {0.0f, 0.0f, 0.0f},
                {0.0f, 0.0f, 0.0f}
        });
        assertEquals(expectedMatrix, zeroMatrix);
    }


    // Тесты на матрицы 4x4

    @Test
    public void testAdd4x4() {
        float[][] elements1 = {
                {1.0f, 2.0f, 3.0f, 4.0f},
                {5.0f, 6.0f, 7.0f, 8.0f},
                {9.0f, 10.0f, 11.0f, 12.0f},
                {13.0f, 14.0f, 15.0f, 16.0f}
        };
        float[][] elements2 = {
                {16.0f, 15.0f, 14.0f, 13.0f},
                {12.0f, 11.0f, 10.0f, 9.0f},
                {8.0f, 7.0f, 6.0f, 5.0f},
                {4.0f, 3.0f, 2.0f, 1.0f}
        };
        Matrix4x4 m1 = new Matrix4x4(elements1);
        Matrix4x4 m2 = new Matrix4x4(elements2);
        Matrix4x4 expected = new Matrix4x4(new float[][]{
                {17.0f, 17.0f, 17.0f, 17.0f},
                {17.0f, 17.0f, 17.0f, 17.0f},
                {17.0f, 17.0f, 17.0f, 17.0f},
                {17.0f, 17.0f, 17.0f, 17.0f}
        });
        Assertions.assertEquals(expected, m1.add(m2));
    }

    @Test
    public void testAdd4x4Exception() {
        float[][] elements1 = {
                {1.0f, 2.0f, 3.0f, 4.0f},
                {5.0f, 6.0f, 7.0f, 8.0f},
                {9.0f, 10.0f, 11.0f, 12.0f},
                {13.0f, 14.0f, 15.0f, 16.0f}
        };
        float[][] elements2 = {
                {1.0f, 2.0f, 3.0f},
                {4.0f, 5.0f, 6.0f},
                {7.0f, 8.0f, 9.0f}
        };
        Matrix4x4 m1 = new Matrix4x4(elements1);
        Matrix3x3 m2 = new Matrix3x3(elements2);

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> m1.add(m2));
        Assertions.assertEquals("Matrix4x4.add: матрица другой размерности.", exception.getMessage());
    }

    @Test
    public void testSubtract4x4() {
        float[][] elements1 = {
                {10.0f, 20.0f, 30.0f, 40.0f},
                {50.0f, 60.0f, 70.0f, 80.0f},
                {90.0f, 100.0f, 110.0f, 120.0f},
                {130.0f, 140.0f, 150.0f, 160.0f}
        };
        float[][] elements2 = {
                {1.0f, 2.0f, 3.0f, 4.0f},
                {5.0f, 6.0f, 7.0f, 8.0f},
                {9.0f, 10.0f, 11.0f, 12.0f},
                {13.0f, 14.0f, 15.0f, 16.0f}
        };
        Matrix4x4 m1 = new Matrix4x4(elements1);
        Matrix4x4 m2 = new Matrix4x4(elements2);
        Matrix4x4 expected = new Matrix4x4(new float[][]{
                {9.0f, 18.0f, 27.0f, 36.0f},
                {45.0f, 54.0f, 63.0f, 72.0f},
                {81.0f, 90.0f, 99.0f, 108.0f},
                {117.0f, 126.0f, 135.0f, 144.0f}
        });
        Assertions.assertEquals(expected, m1.subtract(m2));
    }

    @Test
    public void testSubtract4x4Exception() {
        float[][] elements1 = {
                {10.0f, 20.0f, 30.0f, 40.0f},
                {50.0f, 60.0f, 70.0f, 80.0f},
                {90.0f, 100.0f, 110.0f, 120.0f},
                {130.0f, 140.0f, 150.0f, 160.0f}
        };
        float[][] elements2 = {
                {1.0f, 2.0f, 3.0f},
                {4.0f, 5.0f, 6.0f},
                {7.0f, 8.0f, 9.0f}
        };
        Matrix4x4 m1 = new Matrix4x4(elements1);
        Matrix3x3 m2 = new Matrix3x3(elements2);

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> m1.subtract(m2));
        Assertions.assertEquals("Matrix4x4.subtract: матрица другой размерности.", exception.getMessage());
    }



    @Test
    public void testMultiply4x4() {
        float[][] elements1 = {
                {1.0f, 2.0f, 3.0f, 4.0f},
                {5.0f, 6.0f, 7.0f, 8.0f},
                {9.0f, 10.0f, 11.0f, 12.0f},
                {13.0f, 14.0f, 15.0f, 16.0f}
        };
        float[][] elements2 = {
                {1.0f, 0.0f, 0.0f, 0.0f},
                {0.0f, 1.0f, 0.0f, 0.0f},
                {0.0f, 0.0f, 1.0f, 0.0f},
                {0.0f, 0.0f, 0.0f, 1.0f}
        };
        Matrix4x4 m1 = new Matrix4x4(elements1);
        Matrix4x4 m2 = new Matrix4x4(elements2);
        Assertions.assertEquals(m1, m1.multiply(m2));
    }

    @Test
    public void testMultiply4x4Exception() {
        float[][] elements1 = {
                {1.0f, 2.0f, 3.0f, 4.0f},
                {5.0f, 6.0f, 7.0f, 8.0f},
                {9.0f, 10.0f, 11.0f, 12.0f},
                {13.0f, 14.0f, 15.0f, 16.0f}
        };
        float[][] elements2 = {
                {1.0f, 2.0f, 3.0f},
                {4.0f, 5.0f, 6.0f},
                {7.0f, 8.0f, 9.0f}
        };
        Matrix4x4 m1 = new Matrix4x4(elements1);
        Matrix3x3 m2 = new Matrix3x3(elements2);

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> m1.multiply(m2));
        Assertions.assertEquals("Matrix4x4.multiply: матрица другой размерности.", exception.getMessage());
    }

    @Test
    public void test2Multiply4x4() {
        Matrix matrix = new Matrix4x4(new float[][]{
                {1.0f, 2.0f, 3.0f, 4.0f},
                {5.0f, 6.0f, 7.0f, 8.0f},
                {9.0f, 10.0f, 11.0f, 12.0f},
                {13.0f, 14.0f, 15.0f, 16.0f}
        });
        Vector4 vector = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Vector expected = new Vector4(30.0f, 70.0f, 110.0f, 150.0f);
        Vector result = matrix.multiply(vector);
        assertEquals(expected, result, "Matrix4x4.multiply: результат неверный.");
    }

    @Test
    public void test2Multiply4x4Exception() {
        Matrix4x4 matrix4x4 = Matrix4x4.identity();
        Vector3 vector3 = new Vector3(1.0f, 2.0f, 3.0f);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> matrix4x4.multiply(vector3));
        Assertions.assertEquals("Matrix4x4.multiply: вектор другой размерности.", exception.getMessage());
    }


    @Test
    public void testIdentity4x4() {
        Matrix4x4 identity = Matrix4x4.identity();
        float[][] expectedElements = {
                {1.0f, 0.0f, 0.0f, 0.0f},
                {0.0f, 1.0f, 0.0f, 0.0f},
                {0.0f, 0.0f, 1.0f, 0.0f},
                {0.0f, 0.0f, 0.0f, 1.0f}
        };
        Matrix4x4 expected = new Matrix4x4(expectedElements);
        Assertions.assertEquals(expected, identity);
    }

    @Test
    public void testZero4x4() {
        Matrix4x4 zero = Matrix4x4.zero();
        float[][] expectedElements = new float[4][4];
        Matrix4x4 expected = new Matrix4x4(expectedElements);
        Assertions.assertEquals(expected, zero);
    }

    @Test
    public void testTranspose4x4() {
        float[][] elements = {
                {1.0f, 2.0f, 3.0f, 4.0f},
                {5.0f, 6.0f, 7.0f, 8.0f},
                {9.0f, 10.0f, 11.0f, 12.0f},
                {13.0f, 14.0f, 15.0f, 16.0f}
        };
        Matrix4x4 m = new Matrix4x4(elements);
        Matrix4x4 expected = new Matrix4x4(new float[][]{
                {1.0f, 5.0f, 9.0f, 13.0f},
                {2.0f, 6.0f, 10.0f, 14.0f},
                {3.0f, 7.0f, 11.0f, 15.0f},
                {4.0f, 8.0f, 12.0f, 16.0f}
        });
        Assertions.assertEquals(expected, m.transpose());
    }
*/

}
