package lib.math.utils;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TrigonometryTest {

    @Test()
    void linearPoints() {
        double[][] data = {{0, 100}, {0, 200}, {0, 300}};
        Array2DRowRealMatrix matrix = new Array2DRowRealMatrix(data);
        assertTrue(Trigonometry.arePointsAligned(matrix));
    }
}
