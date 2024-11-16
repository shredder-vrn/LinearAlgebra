package wings.math.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wings.math.vectors.Vector;
import wings.math.vectors.Vector2;
import wings.math.vectors.Vector3;
import wings.math.vectors.Vector4;

class VectorTests {

    // Тесты на двухмерные векторы

    @Test
    public void testVector2Add() {
        Vector2 v1 = new Vector2(1.0f, 2.0f);
        Vector2 v2 = new Vector2(4.0f, 5.0f);
        Vector result = v1.add(v2);
        Vector2 expected = new Vector2(5.0f, 7.0f);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testVector2AddException() {
        Vector2 v1 = new Vector2(1.0f, 2.0f);
        Vector3 v2 = new Vector3(4.0f, 5.0f, 6.0f);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {v1.add(v2);});
        Assertions.assertEquals("Vector2.add: прибавляемый вектор не соответствует размерности.", exception.getMessage());
    }

    @Test
    public void testVector2Subtract() {
        Vector2 vector1 = new Vector2(4.0f, 5.0f);
        Vector2 vector2 = new Vector2(1.0f, 2.0f);
        Vector2 expected = new Vector2(3.0f, 3.0f);
        Assertions.assertEquals(expected, vector1.subtract(vector2));
    }

    @Test
    public void testVector2SubtractException() {
        Vector2 v1 = new Vector2(1.0f, 2.0f);
        Vector3 v2 = new Vector3(4.0f, 5.0f, 6.0f);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {v1.subtract(v2);});
        Assertions.assertEquals("Vector2.subtract: вычитаемый вектор не соответствует размерности.", exception.getMessage());
    }

    @Test
    public void testVector2Scale() {
        Vector2 vector1 = new Vector2(1.0f, 5.0f);
        float scalar = 2.0f;
        Vector2 expected = new Vector2(2.0f, 10.0f);
        Assertions.assertEquals(expected, vector1.scale(scalar));
    }

    @Test
    public void testVector2Divide() {
        Vector2 vector1 = new Vector2(2.0f, 10.0f);
        float scalar = 2.0f;
        Vector2 expected = new Vector2(1.0f, 5.0f);
        Assertions.assertEquals(expected, vector1.divide(scalar));
    }

    @Test
    public void testVector2DivideByZeroException() {
        Vector2 v1 = new Vector2(1.0f, 2.0f);
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () -> {v1.divide(0);});
        Assertions.assertEquals("Vector2.divide: деление на ноль невозможно.", exception.getMessage());
    }

    @Test
    public void testVector2Normalize() {
        Vector2 vector = new Vector2(3.0f, 4.0f);
        Vector2 expected = new Vector2(0.6f, 0.8f);

        Assertions.assertEquals(expected, vector.normalize());
    }

    @Test
    public void testVector2NormalizeZeroLengthException() {
        Vector2 v1 = new Vector2(0.0f, 0.0f);
        Exception exception = Assertions.assertThrows(ArithmeticException.class, v1::normalize);
        Assertions.assertEquals("Vector2.normalize: длина вектора равна нулю, нормализация невозможна.", exception.getMessage());
    }

    @Test
    public void testVector2DotProduct() {
        Vector2 vector1 = new Vector2(2.0f, 3.0f);
        Vector2 vector2 = new Vector2(4.0f, 5.0f);
        float expected = 2.0f * 4.0f + 3.0f * 5.0f; // 23.0f
        Assertions.assertEquals(expected, vector1.dotProduct(vector2));
    }

    @Test
    public void testVector2DotProductException() {
        Vector2 v1 = new Vector2(1.0f, 2.0f);
        Vector3 v2 = new Vector3(4.0f, 5.0f, 6.0f);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {v1.dotProduct(v2);});
        Assertions.assertEquals("Vector2.dotProduct: скалярное произведение невозможно с вектором другой размерности.", exception.getMessage());
    }

    // Тесты на трёхмерные векторы

    @Test
    public void testVector3Add() {
        Vector3 v1 = new Vector3(1.0f, 2.0f, 3.0f);
        Vector3 v2 = new Vector3(4.0f, 5.0f, 6.0f);
        Vector result = v1.add(v2);
        Vector3 expected = new Vector3(5.0f, 7.0f, 9.0f);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testVector3AddException() {
        Vector3 v1 = new Vector3(1.0f, 2.0f, 3.0f);
        Vector2 v2 = new Vector2(4.0f, 5.0f); // Несовместимый размер
        Assertions.assertThrows(IllegalArgumentException.class, () -> v1.add(v2));
    }

    @Test
    public void testVector3Subtract() {
        Vector3 vector1 = new Vector3(4.0f, 5.0f, 6.0f);
        Vector3 vector2 = new Vector3(1.0f, 2.0f, 3.0f);
        Vector3 expected = new Vector3(3.0f, 3.0f, 3.0f);

        Assertions.assertEquals(expected, vector1.subtract(vector2));
    }

    @Test
    public void testVector3SubtractException() {
        Vector3 vector1 = new Vector3(4.0f, 5.0f, 6.0f);
        Vector2 vector2 = new Vector2(1.0f, 2.0f); // Несовместимый размер
        Assertions.assertThrows(IllegalArgumentException.class, () -> vector1.subtract(vector2));
    }

    @Test
    public void testVector3Scale() {
        Vector3 vector1 = new Vector3(1.0f, 5.0f, 3.0f);
        float scalar = 2.0f;
        Vector3 expected = new Vector3(2.0f, 10.0f, 6.0f);
        Assertions.assertEquals(expected, vector1.scale(scalar));
    }

    @Test
    public void testVector3Divide() {
        Vector3 vector1 = new Vector3(2.0f, 10.0f, 6.0f);
        float scalar = 2.0f;
        Vector3 expected = new Vector3(1.0f, 5.0f, 3.0f);
        Assertions.assertEquals(expected, vector1.divide(scalar));
    }

    @Test
    public void testVector3DivideByZero() {
        Vector3 vector1 = new Vector3(2.0f, 10.0f, 6.0f);
        float scalar = 0.0f;
        Assertions.assertThrows(ArithmeticException.class, () -> vector1.divide(scalar));
    }

    @Test
    public void testVector3Normalize() {
        Vector3 vector = new Vector3(3.0f, 4.0f, 0.0f);
        Vector3 expected = new Vector3(0.6f, 0.8f, 0.0f);
        Assertions.assertEquals(expected, vector.normalize());
    }

    @Test
    public void testVector3NormalizeException() {
        Vector3 vector = new Vector3(0.0f, 0.0f, 0.0f);
        Assertions.assertThrows(ArithmeticException.class, vector::normalize);
    }

    @Test
    public void testVector3DotProduct() {
        Vector3 vector1 = new Vector3(2.0f, 2.0f, 3.0f);
        Vector3 vector2 = new Vector3(4.0f, 5.0f, 6.0f);
        float expected = 2.0f * 4.0f + 2.0f * 5.0f + 3.0f * 6.0f; // 32.0f
        Assertions.assertEquals(expected, vector1.dotProduct(vector2));
    }

    @Test
    public void testVector3DotProductException() {
        Vector3 vector1 = new Vector3(2.0f, 2.0f, 3.0f);
        Vector2 vector2 = new Vector2(4.0f, 5.0f);
        Assertions.assertThrows(IllegalArgumentException.class, () -> vector1.dotProduct(vector2));
    }


    @Test
    public void testVector3CrossProduct() {
        Vector3 vector1 = new Vector3(1.0f, 2.0f, 3.0f);
        Vector3 vector2 = new Vector3(4.0f, 5.0f, 6.0f);
        // AxB = (y1z2-z1y2, z1x2-x1z2, x1y2-y1x2)
        Vector3 expected = new Vector3(-3.0f, 6.0f, -3.0f);
        Assertions.assertEquals(expected, vector1.crossProduct(vector2));
    }

    @Test
    public void testVector3CrossProductException() {
        Vector3 vector1 = new Vector3(1.0f, 2.0f, 3.0f);
        Vector2 vector2 = new Vector2(4.0f, 5.0f);
        Assertions.assertThrows(IllegalArgumentException.class, () -> vector1.crossProduct(vector2));
    }

    // Тесты на четырёхмерные векторы

    @Test
    public void testVector4Add() {
        Vector4 v1 = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Vector4 v2 = new Vector4(4.0f, 5.0f, 6.0f, 7.0f);
        Vector4 expected = new Vector4(5.0f, 7.0f, 9.0f, 11.0f);
        Assertions.assertEquals(expected, v1.add(v2));
    }

    @Test
    public void testVector4AddException() {
        Vector4 v1 = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Vector2 v2 = new Vector2(1.0f, 2.0f);
        Assertions.assertThrows(IllegalArgumentException.class, () -> v1.add(v2),
                "Vector4.add: должен выбросить исключение при добавлении вектора другой размерности.");
    }

    @Test
    public void testVector4Subtract() {
        Vector4 v1 = new Vector4(5.0f, 7.0f, 9.0f, 11.0f);
        Vector4 v2 = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Vector4 expected = new Vector4(4.0f, 5.0f, 6.0f, 7.0f);
        Assertions.assertEquals(expected, v1.subtract(v2));
    }

    @Test
    public void testSubtractException() {
        Vector4 v1 = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Vector2 v2 = new Vector2(1.0f, 2.0f);
        Assertions.assertThrows(IllegalArgumentException.class, () -> v1.subtract(v2),
                "Vector4.subtract: должен выбросить исключение при вычитании вектора другой размерности.");
    }

    @Test
    public void testVector4Scale() {
        Vector4 vector = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        float scalar = 2.0f;
        Vector4 expected = new Vector4(2.0f, 4.0f, 6.0f, 8.0f);
        Assertions.assertEquals(expected, vector.scale(scalar));
    }

    @Test
    public void testVector4Divide() {
        Vector4 vector = new Vector4(2.0f, 4.0f, 6.0f, 8.0f);
        float scalar = 2.0f;
        Vector4 expected = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Assertions.assertEquals(expected, vector.divide(scalar));
    }

    @Test
    public void testDivideByZeroException() {
        Vector4 vector = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Assertions.assertThrows(ArithmeticException.class, () -> vector.divide(0.0f),
                "Vector4.divide: должен выбросить исключение при делении на ноль.");
    }

    @Test
    public void testVector4Length() {
        Vector4 vector = new Vector4(3.0f, 2.0f, 3.0f, 4.0f);
        float expected = (float) Math.sqrt(3.0f * 3.0f + 2.0f * 2.0f + 3.0f * 3.0f + 4.0f * 4.0f);
        Assertions.assertEquals(expected, vector.length(), 1e-6f);
    }

    @Test
    public void testVector4Normalize() {
        Vector4 vector = new Vector4(3.0f, 0.0f, 4.0f, 0.0f);
        Vector4 expected = new Vector4(0.6f, 0.0f, 0.8f, 0.0f); // Нормализация (3, 0, 4, 0)
        Assertions.assertEquals(expected, vector.normalize());
    }

    @Test
    public void testNormalizeException() {
        Vector4 zeroVector = new Vector4(0.0f, 0.0f, 0.0f, 0.0f);
        Assertions.assertThrows(ArithmeticException.class, zeroVector::normalize,
                "Vector4.normalize: должен выбросить исключение при нормализации нулевого вектора.");
    }

    @Test
    public void testVector4DotProduct() {
        Vector4 v1 = new Vector4(3.0f, 2.0f, 3.0f, 4.0f);
        Vector4 v2 = new Vector4(4.0f, 5.0f, 6.0f, 7.0f);
        float expected = 3.0f * 4.0f + 2.0f * 5.0f + 3.0f * 6.0f + 4.0f * 7.0f; // 60.0f
        Assertions.assertEquals(expected, v1.dotProduct(v2));
    }

    @Test
    public void testDotProductException() {
        Vector4 v1 = new Vector4(1.0f, 2.0f, 3.0f, 4.0f);
        Vector2 v2 = new Vector2(1.0f, 2.0f);
        Assertions.assertThrows(IllegalArgumentException.class, () -> v1.dotProduct(v2),
                "Vector4.dotProduct: должен выбросить исключение при скалярном произведении с вектором другой размерности.");
    }
}