package wings.math.matrices;

import wings.math.vectors.Vector;

/**
 * Интерфейс Matrix, определяющий основные операции для матриц.
 */
public interface Matrix {

    /**
     * Сложение с другой матрицей.
     */
    Matrix add(Matrix m2);
    
    /**
     * Вычитание другой матрицы.
     */
    Matrix subtract(Matrix m2);

    /**
     * Умножение на другую матрицу.
     */
    Matrix multiply(Matrix m2);

    /**
     * Умножение на вектор.
     */
    Vector multiply(Vector vector);

    /**
     * Транспонирование матрицы.
     */
    Matrix transpose();
}