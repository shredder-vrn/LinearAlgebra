package wings.math;

import wings.math.matrices.Matrix4x4;

public class Main {
    public static void main(String[] args) {

        float[][] m = {
                {0.0f, 1.0f, -1.0f, 1.0f},
                {1.0f, 2.0f, 3.0f, -1.0f},
                {0.0f, 4.0f, 3.0f, 2.0f},
                {1.0f, -1.0f, 1.0f, 2.0f}
        };

        Matrix4x4 matrix4x4 = new Matrix4x4(m);
        System.out.println(matrix4x4.determinant());

    }
}
