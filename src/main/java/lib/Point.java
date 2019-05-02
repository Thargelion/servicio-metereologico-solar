package lib;

import lib.math.geometry.Movimiento;

import static java.lang.Math.round;

public class Point implements Movimiento {

    private double coordX;
    private double coordY;

    public Point() {
    }

    public Point(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    @Override
    public void Rotacion(double degrees, double distance) {
        degrees = Math.toRadians(degrees);
        // coordX = round(distance * Math.cos(degrees));
        // coordY = round(distance * Math.sin(degrees));
        coordX = round((coordX * Math.cos(degrees) - coordY * Math.sin(degrees)));
        coordY = round((coordY * Math.cos(degrees) + coordX * Math.sin(degrees)));
    }

    public double[] getVectorArray() {
        return new double[]{coordX, coordY};
    }
}
