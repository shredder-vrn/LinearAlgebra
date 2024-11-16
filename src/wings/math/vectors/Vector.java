package wings.math.vectors;

/**
 * Интерфейс Vector, определяющий основные операции для векторов.
 */
public interface Vector {
    /**
     * Сложение с другим вектором.
     */
    Vector add(Vector v2);

    /**
     * Вычитание другого вектора.
     */
    Vector subtract(Vector v2);

    /**
     * Умножение вектора на скаляр.
     */
    Vector scale(float scalar);

    /**
     * Деление вектора на скаляр.
     */
    Vector divide(float scalar);

    /**
     * Вычисление длины вектора.
     */
    float length();

    /**
     * Нормализация вектора (приведение длины к 1).
     */
    Vector normalize();

    /**
     * Скалярное произведение с другим вектором.
     */
    float dotProduct(Vector v2);
}
