package wings.math.vectors;

/**
 * Класс Vector3X для работы с трехмерными векторами.
 */
public class Vector3X implements Vectorable<Vector3X> {
    private final float x;
    private final float y;
    private final float z;

    // Конструктор
    public Vector3X(float x, float y, float z) {
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
    public Vector3X add(Vector3X v2) {
        if (v2 instanceof Vector3X v) {
            return new Vector3X(this.x + v.x, this.y + v.y, this.z + v.z);
        }
        throw new IllegalArgumentException("Vector3X.add: прибавляемый вектор не соответствует размерности.");
    }

    @Override
    public Vector3X subtract(Vector3X v2) {
        if (v2 instanceof Vector3X v) {
            return new Vector3X(this.x - v.x, this.y - v.y, this.z - v.z);
        }
        throw new IllegalArgumentException("Vector3X.subtract: вычитаемый вектор не соответствует размерности.");
    }

    @Override
    public Vector3X scale(float scalar) {
        return new Vector3X(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    @Override
    public Vector3X divide(float scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Vector3X3.divide: деление на ноль невозможно.");
        }
        return new Vector3X(this.x / scalar, this.y / scalar, this.z / scalar);
    }

    @Override
    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3X normalize() {
        float length = length();
        if (length == 0) {
            throw new ArithmeticException("Vector3.normalize: длина вектора равна нулю, нормализация невозможна.");
        }
        return divide(length);
    }

    @Override
    public float dotProduct(Vector3X v2) {
        if (v2 instanceof Vector3X v) {
            return this.x * v.x + this.y * v.y + this.z * v.z;
        }
        throw new IllegalArgumentException("Vector3X3.dotProduct: скалярное произведение невозможно с вектором другой размерности.");
    }

    // Метод для векторного произведения
    public Vector3X crossProduct(Vector3X v2) {
        if (v2 instanceof Vector3X v) {
            return new Vector3X(
                    this.y * v.z - this.z * v.y,
                    this.z * v.x - this.x * v.z,
                    this.x * v.y - this.y * v.x
            );
        }
        throw new IllegalArgumentException("Vector3X3.crossProduct: векторное произведение невозможно с вектором другой размерности.");
    }

    @Override
    public String toString() {
        return "Vector3X3{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Vector3X vector3X = (Vector3X) obj;
        return Math.abs(this.x - vector3X.x) < 1e-6 &&
                Math.abs(this.y - vector3X.y) < 1e-6 &&
                Math.abs(this.z - vector3X.z) < 1e-6;
    }
}
