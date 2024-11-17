package wings.math.vectors;

/**
 * Класс Vector3 для работы с трехмерными векторами.
 */
public class Vector3 implements Vector {
    private final float x;
    private final float y;
    private final float z;

    // Конструктор
    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Геттеры

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    // Реализация методов интерфейса Vector
    @Override
    public Vector add(Vector v2) {
        if (v2 instanceof Vector3 v) {
            return new Vector3(this.x + v.x, this.y + v.y, this.z + v.z);
        }
        throw new IllegalArgumentException("Vector3.add: прибавляемый вектор не соответствует размерности.");
    }

    @Override
    public Vector subtract(Vector v2) {
        if (v2 instanceof Vector3 v) {
            return new Vector3(this.x - v.x, this.y - v.y, this.z - v.z);
        }
        throw new IllegalArgumentException("Vector3.subtract: вычитаемый вектор не соответствует размерности.");
    }

    @Override
    public Vector scale(float scalar) {
        return new Vector3(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    @Override
    public Vector divide(float scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Vector3.divide: деление на ноль невозможно.");
        }
        return new Vector3(this.x / scalar, this.y / scalar, this.z / scalar);
    }

    @Override
    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public Vector normalize() {
        float length = length();
        if (length == 0) {
            throw new ArithmeticException("Vector3.normalize: длина вектора равна нулю, нормализация невозможна.");
        }
        return divide(length);
    }

    @Override
    public float dotProduct(Vector v2) {
        if (v2 instanceof Vector3 v) {
            return this.x * v.x + this.y * v.y + this.z * v.z;
        }
        throw new IllegalArgumentException("Vector3.dotProduct: скалярное произведение невозможно с вектором другой размерности.");
    }

    // Метод для векторного произведения
    public Vector crossProduct(Vector v2) {
        if (v2 instanceof Vector3 v) {
            return new Vector3(
                    this.y * v.z - this.z * v.y,
                    this.z * v.x - this.x * v.z,
                    this.x * v.y - this.y * v.x
            );
        }
        throw new IllegalArgumentException("Vector3.crossProduct: векторное произведение невозможно с вектором другой размерности.");
    }

    @Override
    public String toString() {
        return "Vector3{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Сравнение ссылок
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка на null и соответствие классов

        Vector3 vector = (Vector3) obj;
        return Math.abs(this.x - vector.x) < 1e-6 &&
                Math.abs(this.y - vector.y) < 1e-6 &&
                Math.abs(this.z - vector.z) < 1e-6; // Сравнение значений
    }
}
