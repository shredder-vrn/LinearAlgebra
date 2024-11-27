package wings.math.tests;

import org.junit.jupiter.api.Test;
import wings.math.matrices.Matrix3x3;
import wings.math.matrices.Matrix4x4;
import wings.math.vectors.Vector3;
import wings.math.vectors.Vector4;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MatrixTests {

    /**
     * Matrix3x3
     */
    @Test
    void testM3Addition() {
        Matrix3x3 m1 = new Matrix3x3(new float[]{
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
        });
        Matrix3x3 m2 = new Matrix3x3(new float[]{
                9, 8, 7,
                6, 5, 4,
                3, 2, 1
        });
        Matrix3x3 expected = new Matrix3x3(new float[]{
                10, 10, 10,
                10, 10, 10,
                10, 10, 10
        });
        assertEquals(expected, m1.add(m2));
    }

    @Test
    void testM3Subtraction() {
        Matrix3x3 m1 = new Matrix3x3(new float[]{
                10, 10, 10,
                10, 10, 10,
                10, 10, 10
        });
        Matrix3x3 m2 = new Matrix3x3(new float[]{
                9, 8, 7,
                6, 5, 4,
                3, 2, 1
        });
        Matrix3x3 expected = new Matrix3x3(new float[]{
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
        });
        assertEquals(expected, m1.subtract(m2));
    }

    @Test
    void testM3MultiplyMM() {
        Matrix3x3 m1 = new Matrix3x3(new float[]{
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
        });
        Matrix3x3 m2 = new Matrix3x3(new float[]{
                9, 8, 7,
                6, 5, 4,
                3, 2, 1
        });
        Matrix3x3 expected = new Matrix3x3(new float[]{
                30, 24, 18,
                84, 69, 54,
                138, 114, 90
        });
        assertEquals(expected, m1.multiplyMM(m2));
    }

    @Test
    void testM3MultiplyMV() {
        Matrix3x3 m = new Matrix3x3(new float[]{
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
        });
        Vector3 v = new Vector3(1, 2, 3);
        Vector3 expected = new Vector3(14, 32, 50);
        assertEquals(expected, m.multiplyMV(v));
    }

    @Test
    void testM3Transpose() {
        Matrix3x3 m = new Matrix3x3(new float[]{
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
        });
        Matrix3x3 expected = new Matrix3x3(new float[]{
                1, 4, 7,
                2, 5, 8,
                3, 6, 9
        });
        assertEquals(expected, m.transpose());
    }

    @Test
    void testIdentityMatrix() {
        Matrix3x3 identity = Matrix3x3.identity();
        Matrix3x3 expected = new Matrix3x3(new float[]{
                1, 0, 0,
                0, 1, 0,
                0, 0, 1
        });

        assertEquals(expected, identity, "Единичная матрица создана неверно.");
    }

    @Test
    void testZeroMatrix() {
        Matrix3x3 zero = Matrix3x3.zero();
        Matrix3x3 expected = new Matrix3x3(new float[]{
                0, 0, 0,
                0, 0, 0,
                0, 0, 0
        });

        assertEquals(expected, zero, "Нулевая матрица создана неверно.");
    }


    @Test
    void testM3Determinant() {
        Matrix3x3 m = new Matrix3x3(new float[]{
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
        });
        assertEquals(0, m.determinant(), 1e-6);
    }

    @Test
    void testM3Inverse() {
        Matrix3x3 m = new Matrix3x3(new float[]{
                2, -1, 0,
                -1, 2, -1,
                0, -1, 2
        });
        Matrix3x3 expected = new Matrix3x3(new float[]{
                0.75f, 0.5f, 0.25f,
                0.5f, 1, 0.5f,
                0.25f, 0.5f, 0.75f
        });
        assertEquals(expected, m.inverse());
    }

    @Test
    void testM3Equals() {
        Matrix3x3 m1 = new Matrix3x3(new float[]{
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
        });
        Matrix3x3 m2 = new Matrix3x3(new float[]{
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
        });
        assertEquals(m1, m2);
    }

    @Test
    void testM3ToString() {
        Matrix3x3 m = new Matrix3x3(new float[]{
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
        });
        String expected = """
            Matrix3x3X{
              [1.0, 2.0, 3.0]
              [4.0, 5.0, 6.0]
              [7.0, 8.0, 9.0]
            }""";
        assertEquals(expected, m.toString().trim());
    }

    /**
     * Matrix4x4
     */
    @Test
    public void testM4Add() {
        Matrix4x4 m1 = Matrix4x4.identity();
        Matrix4x4 m2 = Matrix4x4.identity();
        Matrix4x4 result = m1.add(m2);

        Matrix4x4 expected = new Matrix4x4(new float[]{
                2, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 2, 0,
                0, 0, 0, 2
        });

        assertEquals(expected, result);
    }

    @Test
    public void testM4Subtract() {
        Matrix4x4 m1 = Matrix4x4.identity();
        Matrix4x4 m2 = Matrix4x4.identity();
        Matrix4x4 result = m1.subtract(m2);

        Matrix4x4 expected = Matrix4x4.zero();
        assertEquals(expected, result);
    }

    @Test
    public void testM4MultiplyMM() {
        Matrix4x4 m1 = Matrix4x4.identity();
        Matrix4x4 m2 = new Matrix4x4(new float[]{
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16
        });

        Matrix4x4 result = m1.multiplyMM(m2);

        assertEquals(m2, result);
    }

    @Test
    public void testM4MultiplyMV() {
        Matrix4x4 m = Matrix4x4.identity();
        Vector4 v = new Vector4(1, 2, 3, 4);

        Vector4 result = m.multiplyMV(v);

        assertEquals(v, result);
    }

    @Test
    public void testM4Transpose() {
        Matrix4x4 m = new Matrix4x4(new float[]{
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16
        });

        Matrix4x4 expected = new Matrix4x4(new float[]{
                1, 5, 9, 13,
                2, 6, 10, 14,
                3, 7, 11, 15,
                4, 8, 12, 16
        });

        assertEquals(expected, m.transpose());
    }

    @Test
    public void testM4Determinant() {
        Matrix4x4 m = new Matrix4x4(new float[]{
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        });

        assertEquals(1, m.determinant(), 1e-6);
    }

    @Test
    public void testM4Inverse() {
        Matrix4x4 m = Matrix4x4.identity();
        Matrix4x4 inverse = m.inverse();

        assertEquals(m, inverse);
    }

    @Test
    public void testM4ZeroMatrix() {
        Matrix4x4 zero = Matrix4x4.zero();
        Matrix4x4 expected = new Matrix4x4(new float[16]);

        assertEquals(expected, zero);
    }

    @Test
    public void testM4IdentityMatrix() {
        Matrix4x4 identity = Matrix4x4.identity();
        Matrix4x4 expected = new Matrix4x4(new float[]{
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        });

        assertEquals(expected, identity);
    }
}
