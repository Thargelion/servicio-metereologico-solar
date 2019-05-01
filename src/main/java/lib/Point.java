package lib;

import lib.math.geometry.Rotacion;

import static java.lang.Math.round;

public class Point implements Rotacion {

    private double coordX;
    private double coordY;

    public Point() {
    }

    public Point(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    @Override
    public void Rotate(double degrees) {
        degrees = Math.toRadians(degrees);
        coordX = round(coordX * Math.cos(degrees) - coordY * Math.sin(degrees));
        coordY = round(coordX * Math.sin(degrees) + coordY * Math.cos(degrees));
    }

    public double[] getVectorArray() {
        return new double[]{coordX, coordY};
    }
}
