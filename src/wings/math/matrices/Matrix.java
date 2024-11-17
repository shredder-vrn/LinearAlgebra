package wings.math.matrices;

import wings.math.vectors.Vector;

/**
 * Интерфейс Matrix, определяющий основные операции для матриц.
 */
public interface Matrix {

    /**
     * Сложение с другой матрицей.
     */
    Matrix add(Matrix other);

    /**
     * Вычитание другой матрицы.
     */
    Matrix subtract(Matrix other);

    /**
     * Умножение на другую матрицу.
     */
    Matrix multiply(Matrix other);

    /**
     * Умножение на вектор.
     */
    Vector multiply(Vector vector);

    /**
     * Транспонирование матрицы.
     */
    Matrix transpose();

    /**
     * Создание единичной матрицы заданного размера.
     */
    static Matrix identity(int size) {
        throw new UnsupportedOperationException("Matrix.identity: некорректные параметры.");
    }

    /**
     * Создание нулевой матрицы заданного размера.
     */
    static Matrix zero(int rows, int cols) {
        throw new UnsupportedOperationException("Matrix.zero: некорректные параметры.");
    }
}