package wings.math.gauss;

public class Main {
    public static void main(String[] args) {
        double[][] matrix = {
                {2, 1, -1},
                {-3, -1, 2},
                {-2, 1, 2}
        };
        double[] freeMembers = {8, -11, -3};

        try {
            ResultString[] result = GaussMethod.gaussMethod(matrix, freeMembers);
            printResults(result);
        } catch (RuntimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void printResults(ResultString[] results) {
        System.out.println("Результаты:");
        for (int i = 0; i < results.length; i++) {
            System.out.println("x" + (i + 1) + " = " + results[i]);
        }
    }
}
