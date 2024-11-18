package wings.math.vectors;

/**
 * Класс Vector2X для работы с двухмерными векторами.
 */
public class Vector2X implements Vectorable<Vector2X>{
    private final float x;
    private final float y;

    // Конструктор
    public Vector2X(float x, float y) {
        this.x = x;
        this.y = y;
    }
    // Реализация методов интерфейса Vector2X
    @Override
    public Vector2X add(Vector2X v2) {
        if (v2 instanceof Vector2X v) {
            return new Vector2X(this.x + v.x, this.y + v.y);
        }
        throw new IllegalArgumentException("Vector2X.add: прибавляемый вектор не соответствует размерности.");
    }

    @Override
    public Vector2X subtract(Vector2X v2) {
        if (v2 instanceof Vector2X v) {
            return new Vector2X(this.x - v.x, this.y - v.y);
        }
        throw new IllegalArgumentException("Vector2X.subtract: вычитаемый вектор не соответствует размерности.");
    }

    @Override
    public Vector2X scale(float scalar) {
        return new Vector2X(this.x * scalar, this.y * scalar);
    }
    @Override
    public Vector2X divide(float scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Vector2X.divide: деление на ноль невозможно.");
        }
        return new Vector2X(this.x / scalar, this.y / scalar);
    }
    @Override
    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }
    @Override
    public Vector2X normalize() {
        float length = length();
        if (length == 0) {
            throw new ArithmeticException("Vector2X.normalize: длина вектора равна нулю, нормализация невозможна.");
        }
        return divide(length);
    }

    @Override
    public float dotProduct(Vector2X v2) {
        if (v2 instanceof Vector2X v) {
            return this.x * v.x + this.y * v.y;
        }
        throw new IllegalArgumentException("Vector2X.dotProduct: скалярное произведение невозможно с вектором другой размерности.");
    }
    @Override
    public String toString() {
        return "Vector2X{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Vector2X vector2x = (Vector2X) obj;
        return Math.abs(this.x - vector2x.x) < 1e-6 && Math.abs(this.y - vector2x.y) < 1e-6;
    }
}
