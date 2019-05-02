package lib.math.geometry;

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
    public void Rotacion(double degrees) {
        degrees = Math.toRadians(degrees);
        double coordXPrima = round((coordX * Math.cos(degrees)) - (coordY * Math.sin(degrees)));
        double coordYPrima = round((coordY * Math.cos(degrees)) + (coordX * Math.sin(degrees)));
        coordX = coordXPrima;
        coordY = coordYPrima;
    }

    public double[] getVectorArray() {
        return new double[]{coordX, coordY};
    }
}
