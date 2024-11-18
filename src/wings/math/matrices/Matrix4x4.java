package wings.math.matrices;

import wings.math.vectors.Vector;
import wings.math.vectors.Vector4;

/**
 * Класс Matrix4x4 для работы с матрицами размером 4x4.
 */
public class Matrix4x4 implements Matrix {
    private final float[][] elements;

    // Конструктор
    public Matrix4x4(float[][] elements) {
        if (elements == null || elements.length != 4 || elements[0].length != 4 || elements[1].length != 4 || elements[2].length != 4 || elements[3].length != 4) {
            throw new IllegalArgumentException("Matrix4x4: некорректные размеры матрицы.");
        }
        this.elements = new float[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(elements[i], 0, this.elements[i], 0, 4);
        }
    }

    // Реализация методов интерфейса Matrix
    @Override
    public Matrix add(Matrix m2) {
        if (m2 instanceof Matrix4x4 o) {
            float[][] result = new float[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    result[i][j] = this.elements[i][j] + o.elements[i][j];
                }
            }
            return new Matrix4x4(result);
        }
        throw new IllegalArgumentException("Matrix4x4.add: матрица другой размерности.");
    }

    @Override
    public Matrix subtract(Matrix m2) {
        if (m2 instanceof Matrix4x4 o) {
            float[][] result = new float[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    result[i][j] = this.elements[i][j] - o.elements[i][j];
                }
            }
            return new Matrix4x4(result);
        }
        throw new IllegalArgumentException("Matrix4x4.subtract: матрица другой размерности.");
    }

    @Override
    public Matrix multiply(Matrix m2) {
        if (m2 instanceof Matrix4x4 o) {
            float[][] result = new float[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < 4; k++) {
                        result[i][j] += this.elements[i][k] * o.elements[k][j];
                    }
                }
            }
            return new Matrix4x4(result);
        }
        throw new IllegalArgumentException("Matrix4x4.multiply: матрица другой размерности.");
    }

    @Override
    public Vector multiply(Vector vector) {
        if (vector instanceof Vector4 v) {
            float[] result = new float[4];
            for (int i = 0; i < 4; i++) {
                result[i] = this.elements[i][0] * v.getX() + this.elements[i][1] * v.getY() + this.elements[i][2] * v.getZ() + this.elements[i][3] * v.getW();
            }
            return new Vector4(result[0], result[1], result[2], result[3]);
        }
        throw new IllegalArgumentException("Matrix4x4.multiply: вектор другой размерности.");
    }

    @Override
    public Matrix transpose() {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = this.elements[j][i];
            }
        }
        return new Matrix4x4(result);
    }

    public static Matrix4x4 identity() {
        float[][] identity = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        return new Matrix4x4(identity);
    }

    public static Matrix4x4 zero() {
        float[][] zero = new float[4][4];
        return new Matrix4x4(zero);
    }

    public float determinant() {
        float det = 0.0f;
        for (int i = 0; i < 4; i++) {
            det += (i % 2 == 0 ? 1 : -1) * elements[0][i] * minorDeterminant(i);
        }
        return det;
    }
    private float minorDeterminant(int col) {
        float[][] minor = new float[3][3];
        int minorRow = 0, minorCol;
        for (int i = 0; i < 4; i++) {
            if (i == 0) continue;
            minorCol = 0;
            for (int j = 0; j < 4; j++) {
                if (j == col) continue;
                minor[minorRow][minorCol++] = elements[i][j];
            }
            minorRow++;
        }
        return new Matrix3x3(minor).determinant();
    }

    public Matrix4x4 inverse() {
        float determinant = this.determinant();
        if (Math.abs(determinant) < 1e-6) {
            throw new IllegalArgumentException("Matrix4x4.inverse: матрица вырождена, обратной нет.");
        }

        float[][] cofactor = new float[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                float[][] minor = getMinor(elements, i, j);
                cofactor[i][j] = ((i + j) % 2 == 0 ? 1 : -1) * determinant3x3(minor);
            }
        }

        float[][] adjugate = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                adjugate[i][j] = cofactor[j][i];
            }
        }

        float[][] inverse = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                inverse[i][j] = adjugate[i][j] / determinant;
            }
        }

        return new Matrix4x4(inverse);
    }

    private float[][] getMinor(float[][] matrix, int row, int col) {
        float[][] minor = new float[3][3];
        int minorRow = 0, minorCol;
        for (int i = 0; i < 4; i++) {
            if (i == row) continue;
            minorCol = 0;
            for (int j = 0; j < 4; j++) {
                if (j == col) continue;
                minor[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }
            minorRow++;
        }
        return minor;
    }

    private float determinant3x3(float[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Matrix4x4{\n");
        for (int i = 0; i < 4; i++) {
            builder.append("  [");
            for (int j = 0; j < 4; j++) {
                builder.append(elements[i][j]).append(j < 3 ? ", " : "");
            }
            builder.append("]\n");
        }
        builder.append("}");
        return builder.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Matrix4x4 matrix = (Matrix4x4) obj;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Math.abs(this.elements[i][j] - matrix.elements[i][j]) > 1e-6) {
                    return false;
                }
            }
        }
        return true;
    }
}