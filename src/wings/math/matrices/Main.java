package wings.math.matrices;

import wings.math.vectors.Vector4;

public class Main {
    public static void main(String[] args) {
        // Создаём две матрицы
        Matrix4x4 m1 = new Matrix4x4(new float[]{
                1, 2, 3, 4,
                5, 6, 7, 8,
                9, 10, 11, 12,
                13, 14, 15, 16
        });
        Matrix4x4 m2 = new Matrix4x4(new float[]{
                2, 0, 0, 0,
                0, 2, 0, 0,
                0, 0, 2, 0,
                0, 0, 0, 2
        });

        // Сложение матриц
        Matrix4x4 sum = m1.add(m2);
        System.out.println("Сложение матриц:");
        System.out.println("m1:\n" + m1);
        System.out.println("m2:\n" + m2);
        System.out.println("Результат:\n" + sum);

        // Умножение матриц
        Matrix4x4 product = m1.multiplyMM(m2);
        System.out.println("\nУмножение матриц:");
        System.out.println("m1:\n" + m1);
        System.out.println("m2:\n" + m2);
        System.out.println("Результат:\n" + product);

        // Умножение матрицы на вектор
        Vector4 v = new Vector4(1, 2, 3, 4);
        Vector4 result = m1.multiplyMV(v);
        System.out.println("\nУмножение матрицы на вектор:");
        System.out.println("Матрица:\n" + m1);
        System.out.println("Вектор: " + v);
        System.out.println("Результат: " + result);
    }
}
