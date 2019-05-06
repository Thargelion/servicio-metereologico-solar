package app.planeta;

public class Planeta {
    String nombre;
    double posicionX;
    double posicionY;
    double velocidad;

    public Planeta(){}

    public Planeta(String nombre, double posX, double posY, double velocidad) {
        this.nombre = nombre;
        this.posicionX = posX;
        this.posicionY = posY;
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
}
