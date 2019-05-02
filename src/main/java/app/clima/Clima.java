package app.clima;

public class Clima {
    private Integer dia;
    private String clima;

    public Clima(){}

    public Clima(Integer dia, String clima) {
        this.dia = dia;
        this.clima = clima;
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
}
