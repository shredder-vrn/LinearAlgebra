package wings.math.tests;

import org.junit.jupiter.api.Test;
import wings.math.vectors.Vector2;
import wings.math.vectors.Vector3;
import wings.math.vectors.Vector4;

import static org.junit.jupiter.api.Assertions.*;

class VectorTests {

    /**
     * Vector2
     */
    @Test
    void testV2Add() {
        Vector2 v1 = new Vector2(1, 2);
        Vector2 v2 = new Vector2(3, 4);
        Vector2 result = v1.add(v2);
        assertEquals(new Vector2(4, 6), result, "Сложение двух векторов выполнено неверно.");
    }

    @Test
    void testV2Subtract() {
        Vector2 v1 = new Vector2(5, 6);
        Vector2 v2 = new Vector2(2, 3);
        Vector2 result = v1.subtract(v2);
        assertEquals(new Vector2(3, 3), result, "Вычитание двух векторов выполнено неверно.");
    }

    @Test
    void testV2Scale() {
        Vector2 v = new Vector2(2, 3);
        Vector2 result = v.scale(2);
        assertEquals(new Vector2(4, 6), result, "Масштабирование выполнено неверно.");
    }

    @Test
    void testV2Divide() {
        Vector2 v = new Vector2(6, 8);
        Vector2 result = v.divide(2);
        assertEquals(new Vector2(3, 4), result, "Деление вектора выполнено неверно.");
    }

    @Test
    void testV2DivideByZero() {
        Vector2 v = new Vector2(1, 1);
        assertThrows(ArithmeticException.class, () -> v.divide(0), "Деление на ноль должно вызывать исключение.");
    }

    @Test
    void testV2Length() {
        Vector2 v = new Vector2(3, 4);
        assertEquals(5, v.length(), 1e-6, "Длина вектора вычислена неверно.");
    }

    @Test
    void testV2Normalize() {
        Vector2 v = new Vector2(3, 4);
        Vector2 result = v.normalize();
        assertEquals(new Vector2(0.6f, 0.8f), result, "Нормализация вектора выполнена неверно.");
    }

    @Test
    void testV2NormalizeZeroLength() {
        Vector2 v = new Vector2(0, 0);
        assertThrows(ArithmeticException.class, v::normalize, "Нормализация нулевого вектора должна вызывать исключение.");
    }

    @Test
    void testV2DotProduct() {
        Vector2 v1 = new Vector2(1, 2);
        Vector2 v2 = new Vector2(3, 4);
        assertEquals(11, v1.dotProduct(v2), 1e-6, "Скалярное произведение вычислено неверно.");
    }

    @Test
    void testV2Equals() {
        Vector2 v1 = new Vector2(1, 2);
        Vector2 v2 = new Vector2(1, 2);
        Vector2 v3 = new Vector2(2, 3);
        assertEquals(v1, v2, "Одинаковые векторы должны быть равны.");
        assertNotEquals(v1, v3, "Разные векторы не должны быть равны.");
    }

    @Test
    void testV2ToString() {
        Vector2 v = new Vector2(1.5f, 2.5f);
        assertEquals("Vector2X{x=1.5, y=2.5}", v.toString(), "Метод toString вернул неверное значение.");
    }

    /**
     * Vector3
     */
    @Test
    void testV3Add() {
        Vector3 v1 = new Vector3(1, 2, 3);
        Vector3 v2 = new Vector3(4, 5, 6);
        Vector3 result = v1.add(v2);
        assertEquals(new Vector3(5, 7, 9), result, "Сложение выполнено неверно.");
    }

    @Test
    void testV3Subtract() {
        Vector3 v1 = new Vector3(4, 5, 6);
        Vector3 v2 = new Vector3(1, 2, 3);
        Vector3 result = v1.subtract(v2);
        assertEquals(new Vector3(3, 3, 3), result, "Вычитание выполнено неверно.");
    }

    @Test
    void testV3Scale() {
        Vector3 v = new Vector3(1, 2, 3);
        Vector3 result = v.scale(2);
        assertEquals(new Vector3(2, 4, 6), result, "Масштабирование выполнено неверно.");
    }

    @Test
    void testV3Divide() {
        Vector3 v = new Vector3(2, 4, 6);
        Vector3 result = v.divide(2);
        assertEquals(new Vector3(1, 2, 3), result, "Деление выполнено неверно.");
    }

    @Test
    void testV3DivideByZero() {
        Vector3 v = new Vector3(2, 4, 6);
        assertThrows(ArithmeticException.class, () -> v.divide(0), "Деление на ноль должно вызывать исключение.");
    }

    @Test
    void testV3Length() {
        Vector3 v = new Vector3(3, 4, 0);
        assertEquals(5.0f, v.length(), "Расчет длины выполнен неверно.");
    }

    @Test
    void testV3Normalize() {
        Vector3 v = new Vector3(3, 0, 4);
        Vector3 result = v.normalize();
        assertEquals(new Vector3(0.6f, 0.0f, 0.8f), result, "Нормализация выполнена неверно.");
    }

    @Test
    void testV3NormalizeZeroLength() {
        Vector3 v = new Vector3(0, 0, 0);
        assertThrows(ArithmeticException.class, v::normalize, "Нормализация нулевого вектора должна вызывать исключение.");
    }

    @Test
    void testV3DotProduct() {
        Vector3 v1 = new Vector3(1, 2, 3);
        Vector3 v2 = new Vector3(4, 5, 6);
        float result = v1.dotProduct(v2);
        assertEquals(32.0f, result, "Скалярное произведение выполнено неверно.");
    }

    @Test
    void testV3CrossProduct() {
        Vector3 v1 = new Vector3(1, 0, 0);
        Vector3 v2 = new Vector3(0, 1, 0);
        Vector3 result = v1.crossProduct(v2);
        assertEquals(new Vector3(0, 0, 1), result, "Векторное произведение выполнено неверно.");
    }

    @Test
    void testV3ToString() {
        Vector3 v = new Vector3(1, 2, 3);
        String result = v.toString();
        assertEquals("Vector3X3{x=1.0, y=2.0, z=3.0}", result, "Метод toString выполнен неверно.");
    }

    @Test
    void testV3Equals() {
        Vector3 v1 = new Vector3(1, 2, 3);
        Vector3 v2 = new Vector3(1, 2, 3);
        assertEquals(v1, v2, "Равенство идентичных векторов выполнено неверно.");
    }

    @Test
    void testV3NotEquals() {
        Vector3 v1 = new Vector3(1, 2, 3);
        Vector3 v2 = new Vector3(3, 2, 1);
        assertNotEquals(v1, v2, "Сравнение разных векторов выполнено неверно.");
    }

    /**
     * Vector4
     */
    @Test
    void testV4Add() {
        Vector4 v1 = new Vector4(1, 2, 3, 4);
        Vector4 v2 = new Vector4(5, 6, 7, 8);
        Vector4 result = v1.add(v2);
        assertEquals(new Vector4(6, 8, 10, 12), result, "Сложение выполнено неверно.");
    }

    @Test
    void testV4Subtract() {
        Vector4 v1 = new Vector4(5, 6, 7, 8);
        Vector4 v2 = new Vector4(1, 2, 3, 4);
        Vector4 result = v1.subtract(v2);
        assertEquals(new Vector4(4, 4, 4, 4), result, "Вычитание выполнено неверно.");
    }

    @Test
    void testV4Scale() {
        Vector4 v = new Vector4(1, 2, 3, 4);
        Vector4 result = v.scale(2);
        assertEquals(new Vector4(2, 4, 6, 8), result, "Масштабирование выполнено неверно.");
    }

    @Test
    void testV4Divide() {
        Vector4 v = new Vector4(2, 4, 6, 8);
        Vector4 result = v.divide(2);
        assertEquals(new Vector4(1, 2, 3, 4), result, "Деление выполнено неверно.");
    }

    @Test
    void testV4DivideByZero() {
        Vector4 v = new Vector4(2, 4, 6, 8);
        assertThrows(ArithmeticException.class, () -> v.divide(0), "Деление на ноль должно вызывать исключение.");
    }

    @Test
    void testV4Length() {
        Vector4 v = new Vector4(2, 2, 1, 1);
        assertEquals(3.0f, v.length(), "Расчет длины выполнен неверно.");
    }

    @Test
    void testV4Normalize() {
        Vector4 v = new Vector4(2, 2, 1, 1);
        Vector4 result = v.normalize();
        assertEquals(new Vector4(2 / 3f, 2 / 3f, 1 / 3f, 1 / 3f), result, "Нормализация выполнена неверно.");
    }

    @Test
    void testV4NormalizeZeroLength() {
        Vector4 v = new Vector4(0, 0, 0, 0);
        assertThrows(ArithmeticException.class, v::normalize, "Нормализация нулевого вектора должна вызывать исключение.");
    }

    @Test
    void testV4DotProduct() {
        Vector4 v1 = new Vector4(1, 2, 3, 4);
        Vector4 v2 = new Vector4(5, 6, 7, 8);
        float result = v1.dotProduct(v2);
        assertEquals(70.0f, result, "Скалярное произведение выполнено неверно.");
    }

    @Test
    void testV4ToString() {
        Vector4 v = new Vector4(1, 2, 3, 4);
        String result = v.toString();
        assertEquals("Vector4X{x=1.0, y=2.0, z=3.0, w=4.0}", result, "Метод toString выполнен неверно.");
    }

    @Test
    void testV4Equals() {
        Vector4 v1 = new Vector4(1, 2, 3, 4);
        Vector4 v2 = new Vector4(1, 2, 3, 4);
        assertEquals(v1, v2, "Равенство идентичных векторов выполнено неверно.");
    }

    @Test
    void testV4NotEquals() {
        Vector4 v1 = new Vector4(1, 2, 3, 4);
        Vector4 v2 = new Vector4(4, 3, 2, 1);
        assertNotEquals(v1, v2, "Сравнение разных векторов выполнено неверно.");
    }
}