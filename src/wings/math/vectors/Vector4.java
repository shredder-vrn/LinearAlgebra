package wings.math.vectors;

/**
 * Класс Vector4 для работы с четырехмерными векторами.
 */
public class Vector4 implements Vector {
    private final float x;
    private final float y;
    private final float z;
    private final float w;

    // Конструктор
    public Vector4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
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

    public float getW() {
        return w;
    }

    // Реализация методов интерфейса Vector
    @Override
    public Vector add(Vector v) {
        if (v instanceof Vector4 other) {
            return new Vector4(this.x + other.x, this.y + other.y, this.z + other.z, this.w + other.w);
        }
        throw new IllegalArgumentException("Vector4.add: прибавляемый вектор не соответствует размерности.");
    }

    @Override
    public Vector subtract(Vector v) {
        if (v instanceof Vector4 other) {
            return new Vector4(this.x - other.x, this.y - other.y, this.z - other.z, this.w - other.w);
        }
        throw new IllegalArgumentException("Vector4.subtract: вычитаемый вектор не соответствует размерности.");
    }

    @Override
    public Vector scale(float scalar) {
        return new Vector4(this.x * scalar, this.y * scalar, this.z * scalar, this.w * scalar);
    }

    @Override
    public Vector divide(float scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Vector4.divide: деление на ноль невозможно.");
        }
        return new Vector4(this.x / scalar, this.y / scalar, this.z / scalar, this.w / scalar);
    }

    @Override
    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    @Override
    public Vector normalize() {
        float length = length();
        if (length == 0) {
            throw new ArithmeticException("Vector4.normalize: длина вектора равна нулю, нормализация невозможна.");
        }
        return divide(length);
    }

    @Override
    public float dotProduct(Vector v) {
        if (v instanceof Vector4 other) {
            return this.x * other.x + this.y * other.y + this.z * other.z + this.w * other.w;
        }
        throw new IllegalArgumentException("Vector4.dotProduct: скалярное произведение невозможно с вектором другой размерности.");
    }

    @Override
    public String toString() {
        return "Vector4{" + "x=" + x + ", y=" + y + ", z=" + z + ", w=" + w + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Vector4 vector = (Vector4) obj;
        return Math.abs(this.x - vector.x) < 1e-6 &&
                Math.abs(this.y - vector.y) < 1e-6 &&
                Math.abs(this.z - vector.z) < 1e-6 &&
                Math.abs(this.w - vector.w) < 1e-6;
    }
}
