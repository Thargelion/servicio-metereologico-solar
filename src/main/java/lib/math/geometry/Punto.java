package lib.math.geometry;

import static java.lang.Math.round;

public class Punto implements Movimiento {

    private double coordX;
    private double coordY;

    public Punto() {
    }

    public Punto(double coordX, double coordY) {
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

    public double[] getCoords() {
        return new double[]{coordX, coordY};
    }

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }
}
