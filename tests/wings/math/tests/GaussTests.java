package wings.math.tests;

import org.junit.jupiter.api.Test;
import wings.math.gauss.GaussMethod;
import wings.math.gauss.ResultString;

import static org.junit.jupiter.api.Assertions.*;


public class GaussTests {
    @Test
    public void testSingleSolution() {
        double[][] matrix = {
                {2, 1, -1},
                {-3, -1, 2},
                {-2, 1, 2}
        };
        double[] freeMembers = {8, -11, -3};

        ResultString[] result = GaussMethod.gaussMethod(matrix, freeMembers);

        assertEquals(2.0, result[0].result, 0.001);
        assertEquals(3.0, result[1].result, 0.001);
        assertEquals(-1.0, result[2].result, 0.001);
    }

    @Test
    public void testInfiniteSolutions() {
        double[][] matrix = {
                {1, 1, 1},
                {2, 2, 2},
                {1, 1, 1}
        };
        double[] freeMembers = {3, 6, 3};

        ResultString[] result = GaussMethod.gaussMethod(matrix, freeMembers);

        assertTrue(result[0].isInfinite);
        assertTrue(result[1].isFree);
        assertTrue(result[2].isFree);
    }

    @Test
    public void testNoSolutions() {
        double[][] matrix = {
                {1, 1, 1},
                {2, 2, 2},
                {1, 1, 1}
        };
        double[] freeMembers = {3, 6, 4};

        assertThrows(RuntimeException.class, () -> GaussMethod.gaussMethod(matrix, freeMembers));
    }
}
