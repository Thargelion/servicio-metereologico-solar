package app.enums;

import app.clima.ClimaService;
import app.planetas.PlanetaService;

public enum ServiceEnum {
    instance;
    ClimaService climaService = new ClimaService();
    PlanetaService planetaService = new PlanetaService();
    public ClimaService getClimaService() {
        return climaService;
    }
    public PlanetaService getPlanetaService() {
        return planetaService;
    }
}
