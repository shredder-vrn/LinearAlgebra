package wings.math.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wings.math.vectors.Vector;
import wings.math.vectors.Vector3;

class VectorTests {
    @Test
    public void testVector3Add() {
        Vector3 v1 = new Vector3(1.0f, 2.0f, 3.0f);
        Vector3 v2 = new Vector3(4.0f, 5.0f, 6.0f);
        Vector result = v1.add(v2);
        Vector3 expected = new Vector3(5.0f, 7.0f, 9.0f);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testVector3Subtract() {
        Vector3 vector1 = new Vector3(4.0f, 5.0f, 6.0f);
        Vector3 vector2 = new Vector3(1.0f, 2.0f, 3.0f);
        Vector3 expected = new Vector3(3.0f, 3.0f, 3.0f);

        Assertions.assertEquals(expected, vector1.subtract(vector2));
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
    public void testVector3Normalize() {
        Vector3 vector = new Vector3(3.0f, 4.0f, 0.0f);
        Vector3 expected = new Vector3(0.6f, 0.8f, 0.0f);

        Assertions.assertEquals(expected, vector.normalize());
    }
    @Test
    public void testVector3DotProduct() {
        Vector3 vector1 = new Vector3(2.0f, 2.0f, 3.0f);
        Vector3 vector2 = new Vector3(4.0f, 5.0f, 6.0f);
        float expected = 2.0f * 4.0f + 2.0f * 5.0f + 3.0f * 6.0f; // 32.0f
        Assertions.assertEquals(expected, vector1.dotProduct(vector2));
    }
    @Test
    public void testVector3CrossProduct() {
        Vector3 vector1 = new Vector3(1.0f, 2.0f, 3.0f);
        Vector3 vector2 = new Vector3(4.0f, 5.0f, 6.0f);
        // AxB = (y1z2-z1y2, z1x2-x1z2, x1y2-y1x2)
        Vector3 expected = new Vector3(-3.0f, 6.0f, -3.0f);
        Assertions.assertEquals(expected, vector1.crossProduct(vector2));
    }

}