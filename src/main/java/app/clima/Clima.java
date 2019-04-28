package app.clima;

import lib.transformers.JsonObject;

public class Clima extends JsonObject {
    private String dia;
    private String clima;

    public Clima(){}

    public Clima(String dia, String clima) {
        this.dia = dia;
        this.clima = clima;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }
}
