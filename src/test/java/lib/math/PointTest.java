package lib.math;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lib.Point;

class PointTest {

    @Test()
    void angle360RotatesPointToSamePlace() {
        Point punto = new Point(0.0, 2000.0);
        punto.Rotacion(360);
        assertEquals(Arrays.toString(new double[]{0.0, 2000.0}), Arrays.toString(punto.getVectorArray()));
    }

    @Test()
    void angle90RotateRotatesPointAQuarter() {
        Point punto = new Point(0.0, 2000.0);
        punto.Rotacion(90);
        assertEquals(Arrays.toString(new double[]{-2000.0, 0.0}), Arrays.toString(punto.getVectorArray()));
    }

    @Test()
    void angle180RotateRotatesPointAHalf() {
        Point punto = new Point(0.0, 2000.0);
        punto.Rotacion(180);
        assertEquals(Arrays.toString(new double[]{0, -2000.0}), Arrays.toString(punto.getVectorArray()));
    }

}
