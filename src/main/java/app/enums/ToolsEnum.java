package app.enums;

import app.analisis.Analisis;
import app.analisis.AnalisisService;

public enum ToolsEnum {
    INSTANCE;
    AnalisisService analisisService = new AnalisisService();
    public AnalisisService getAnalisisService() {
        return analisisService;
    }
}
