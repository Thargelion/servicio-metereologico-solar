package app.enums;

import app.analisis.Analisis;
import app.analisis.AnalisisService;
import app.services.ToolsService;

public enum ToolsEnum {
    INSTANCE;
    AnalisisService analisisService = new AnalisisService();
    ToolsService toolsService = new ToolsService();
    public AnalisisService getAnalisisService() {
        return analisisService;
    }
    public ToolsService toolsService() {
        return toolsService;
    }
}
