package lib.math;

import lib.math.geometry.Punto;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PuntoTest {

    @Test()
    void angle360RotatesPointToSamePlace() {
        Punto punto = new Punto(0.0, 2000.0);
        punto.Rotacion(360);
        assertEquals(Arrays.toString(new double[]{0.0, 2000.0}), Arrays.toString(punto.getCoords()));
    }

    @Test()
    void angle90RotateRotatesPointAQuarter() {
        Punto punto = new Punto(0.0, 2000.0);
        punto.Rotacion(90);
        assertEquals(Arrays.toString(new double[]{-2000.0, 0.0}), Arrays.toString(punto.getCoords()));
    }

    @Test()
    void angle180RotateRotatesPointAHalf() {
        Punto punto = new Punto(0.0, 1000.0);
        punto.Rotacion(180);
        assertEquals(Arrays.toString(new double[]{0, -1000.0}), Arrays.toString(punto.getCoords()));
    }

}
