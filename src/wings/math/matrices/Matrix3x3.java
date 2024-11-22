package wings.math.matrices;

import wings.math.vectors.Vector;
import wings.math.vectors.Vector3;

/**
 * Класс Matrix3x3 для работы с матрицами размером 3x3.
 */
public class Matrix3x3 implements Matrix {
    private final float[][] elements;

    // Конструктор
    public Matrix3x3(float[][] elements) {
        if (elements == null || elements.length != 3 || elements[0].length != 3 || elements[1].length != 3 || elements[2].length != 3) {
            throw new IllegalArgumentException("Matrix3x3: некорректные размеры матрицы.");
        }
        this.elements = new float[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(elements[i], 0, this.elements[i], 0, 3);
        }
    }

    // Реализация методов интерфейса Matrix
    @Override
    public Matrix add(Matrix m2) {
        if (m2 instanceof Matrix3x3 o) {
            float[][] result = new float[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    result[i][j] = this.elements[i][j] + o.elements[i][j];
                }
            }
            return new Matrix3x3(result);
        }
        throw new IllegalArgumentException("Matrix3x3.add: матрица другой размерности.");
    }

    @Override
    public Matrix subtract(Matrix m2) {
        if (m2 instanceof Matrix3x3 o) {
            float[][] result = new float[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    result[i][j] = this.elements[i][j] - o.elements[i][j];
                }
            }
            return new Matrix3x3(result);
        }
        throw new IllegalArgumentException("Matrix3x3.subtract: матрица другой размерности.");
    }

    @Override
    public Matrix multiply(Matrix m2) {
        if (m2 instanceof Matrix3x3 o) {
            float[][] result = new float[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < 3; k++) {
                        result[i][j] += this.elements[i][k] * o.elements[k][j];
                    }
                }
            }
            return new Matrix3x3(result);
        }
        throw new IllegalArgumentException("Matrix3x3.multiply: матрица другой размерности.");
    }

    @Override
    public Vector multiply(Vector vector) {
        if (vector instanceof Vector3 v) {
            float[] result = new float[3];
            for (int i = 0; i < 3; i++) {
                result[i] = this.elements[i][0] * v.getX() + this.elements[i][1] * v.getY() + this.elements[i][2] * v.getZ();
            }
            return new Vector3(result[0], result[1], result[2]);
        }
        throw new IllegalArgumentException("Matrix3x3.multiply: вектор другой размерности.");
    }

    @Override
    public Matrix transpose() {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = this.elements[j][i];
            }
        }
        return new Matrix3x3(result);
    }

    public static Matrix3x3 identity() {
        float[][] identity = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        return new Matrix3x3(identity);
    }

    public static Matrix3x3 zero() {
        float[][] zero = new float[3][3];
        return new Matrix3x3(zero);
    }

    public float determinant() {
        return elements[0][0] * (elements[1][1] * elements[2][2] - elements[1][2] * elements[2][1])
                - elements[0][1] * (elements[1][0] * elements[2][2] - elements[1][2] * elements[2][0])
                + elements[0][2] * (elements[1][0] * elements[2][1] - elements[1][1] * elements[2][0]);
    }

    public Matrix3x3 inverse() {
        float determinant = this.determinant();
        if (Math.abs(determinant) < 1e-6) {
            throw new IllegalArgumentException("Matrix3x3.inverse: матрица вырождена, обратной нет.");
        }

        float[][] cofactor = new float[3][3];
        cofactor[0][0] = elements[1][1] * elements[2][2] - elements[1][2] * elements[2][1];
        cofactor[0][1] = elements[1][2] * elements[2][0] - elements[1][0] * elements[2][2];
        cofactor[0][2] = elements[1][0] * elements[2][1] - elements[1][1] * elements[2][0];

        cofactor[1][0] = elements[2][1] * elements[0][2] - elements[2][2] * elements[0][1];
        cofactor[1][1] = elements[2][2] * elements[0][0] - elements[2][0] * elements[0][2];
        cofactor[1][2] = elements[2][0] * elements[0][1] - elements[2][1] * elements[0][0];

        cofactor[2][0] = elements[0][1] * elements[1][2] - elements[0][2] * elements[1][1];
        cofactor[2][1] = elements[0][2] * elements[1][0] - elements[0][0] * elements[1][2];
        cofactor[2][2] = elements[0][0] * elements[1][1] - elements[0][1] * elements[1][0];

        float[][] adjugate = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                adjugate[i][j] = cofactor[j][i];
            }
        }

        float[][] inverse = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverse[i][j] = adjugate[i][j] / determinant;
            }
        }

        return new Matrix3x3(inverse);
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Matrix3x3{\n");
        for (int i = 0; i < 3; i++) {
            builder.append("  [");
            for (int j = 0; j < 3; j++) {
                builder.append(elements[i][j]).append(j < 2 ? ", " : "");
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

        Matrix3x3 matrix = (Matrix3x3) obj;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Math.abs(this.elements[i][j] - matrix.elements[i][j]) > 1e-6) {
                    return false;
                }
            }
        }
        return true;
    }
}