package app.analisis;

public class Analisis {
    Integer diasSequia;
    Integer diasLluvia;
    Integer diaMasLluvia;
    Integer diasOptimo;
    public Analisis(){}

    public Analisis(Integer diasSequia, Integer diasLluvia, Integer diaMasLluvia, Integer diasOptimo) {
        this.diasSequia = diasSequia;
        this.diasLluvia = diasLluvia;
        this.diaMasLluvia = diaMasLluvia;
        this.diasOptimo = diasOptimo;
    }
}
