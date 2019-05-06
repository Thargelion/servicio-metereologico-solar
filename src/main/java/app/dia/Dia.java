package app.dia;

import app.planeta.Planeta;

public class Dia {
    Integer numero;
    Planeta planeta;

    public Dia() {
    }
    public Dia(Integer numero, Planeta planeta) {
        this.numero = numero;
        this.planeta = planeta;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }
}
