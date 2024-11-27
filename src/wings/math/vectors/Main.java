package wings.math.vectors;

import wings.math.matrices.Matrix4x4;

public class Main {
    public static void main(String[] args) {
        // Создаём два вектора
        Vector4 v1 = new Vector4(1, 2, 3, 4);
        Vector4 v2 = new Vector4(4, 3, 2, 1);

        // Сложение векторов
        Vector4 sum = v1.add(v2);
        System.out.println("Сложение векторов:");
        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);
        System.out.println("Результат: " + sum);

        // Умножение вектора на матрицу
        Matrix4x4 matrix = Matrix4x4.identity();
        Vector4 result = matrix.multiplyMV(v1);
        System.out.println("\nУмножение вектора на матрицу:");
        System.out.println("Матрица:");
        System.out.println(matrix);
        System.out.println("Вектор: " + v1);
        System.out.println("Результат: " + result);

        // Вычисление длины вектора
        double length = v1.length();
        System.out.println("\nДлина вектора:");
        System.out.println("Вектор: " + v1);
        System.out.println("Длина: " + length);
    }
}
