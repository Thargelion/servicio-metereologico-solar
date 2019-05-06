package app.clima;

public class Clima {
    private Integer dia;
    private String clima;
    private double intensidad;

    public Clima(){}

    public Clima(Integer dia, String clima, double intensidad) {
        this.dia = dia;
        this.clima = clima;
        this.intensidad =intensidad;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public double getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(double intensidad) {
        this.intensidad = intensidad;
    }
}
