package app.enums;

import app.clima.ClimaService;

public enum ServiceEnum {
    instance;
    ClimaService climaService = new ClimaService();

    public ClimaService getClimaService() {
        return climaService;
    }
}
