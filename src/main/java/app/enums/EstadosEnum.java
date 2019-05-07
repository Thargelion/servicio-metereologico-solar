package app.enums;

public enum EstadosEnum {
    LLUVIA("lluvia"),
    SOLEADO("soleado"),
    OPTIMO("optimo"),
    SEQUIA("sequia");
    private String estado;
    EstadosEnum(String estado) {
        this.estado = estado;
    }
    public String getEstado() {
        return this.estado;
    }
}
