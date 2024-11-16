package wings.math.vectors;

/**
 * Класс Vector2 для работы с двухмерными векторами.
 */
public class Vector2 implements Vector{
    private final float x;
    private final float y;

    // Конструктор
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    // Реализация методов интерфейса Vector
    @Override
    public Vector add(Vector v2) {
        if (v2 instanceof Vector2 v) {
            return new Vector2(this.x + v.x, this.y + v.y);
        }
        throw new IllegalArgumentException("Vector2.add: прибавляемый вектор не соответствует размерности.");
    }

    @Override
    public Vector subtract(Vector v2) {
        if (v2 instanceof Vector2 v) {
            return new Vector2(this.x - v.x, this.y - v.y);
        }
        throw new IllegalArgumentException("Vector2.subtract: вычитаемый вектор не соответствует размерности.");
    }

    @Override
    public Vector scale(float scalar) {
        return new Vector2(this.x * scalar, this.y * scalar);
    }
    @Override
    public Vector divide(float scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Vector2.divide: деление на ноль невозможно.");
        }
        return new Vector2(this.x / scalar, this.y / scalar);
    }
    @Override
    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }
    @Override
    public Vector normalize() {
        float length = length();
        if (length == 0) {
            throw new ArithmeticException("Vector2.normalize: длина вектора равна нулю, нормализация невозможна.");
        }
        return divide(length);
    }

    @Override
    public float dotProduct(Vector v2) {
        if (v2 instanceof Vector2 v) {
            return this.x * v.x + this.y * v.y;
        }
        throw new IllegalArgumentException("Vector2.dotProduct: скалярное произведение невозможно с вектором другой размерности.");
    }
    @Override
    public String toString() {
        return "Vector2{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Vector2 vector = (Vector2) obj;
        return Math.abs(this.x - vector.x) < 1e-6 && Math.abs(this.y - vector.y) < 1e-6;
    }
}
