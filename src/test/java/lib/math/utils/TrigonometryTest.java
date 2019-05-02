package lib.math.utils;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class TrigonometryTest {

    @Test()
    void alignedPointsAreAligned() {
        double[][] data = {{0, 100}, {0, 200}, {0, 300}};
        Array2DRowRealMatrix matrix = new Array2DRowRealMatrix(data);
        assertTrue(Trigonometry.arePointsAligned(matrix));
    }

    @Test()
    void outsidePointIsOutside() {
        double[] floatingPoint = {5, -5};
        double[] firstPoint = {-1000, 1};
        double[] secondPoint = {2, 4};
        double[] thirdPoint = {3, 3};
        assertFalse(Trigonometry.isPointInTri(
                floatingPoint,
                firstPoint,
                secondPoint,
                thirdPoint
        ));
    }

    @Test()
    void insidePointIsInside() {
        double[] floatingPoint = {2, 3};
        double[] firstPoint = {1, 1};
        double[] secondPoint = {2, 4};
        double[] thirdPoint = {3, 1};
        assertTrue(Trigonometry.isPointInTri(
                floatingPoint,
                firstPoint,
                secondPoint,
                thirdPoint
        ));
    }
}
