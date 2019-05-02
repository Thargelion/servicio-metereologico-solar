package lib.math;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lib.Point;

class PointTest {

    @Test()
    void RotateRotatesPoint() {
        Point punto = new Point(0.0, 2000.0);
        punto.Rotacion(360, 2000.0);
        assertEquals(Arrays.toString(new double[]{0.0, 2000.0}), Arrays.toString(punto.getVectorArray()));
    }

}
