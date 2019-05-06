package app.enums;

import app.clima.ClimaService;
import app.planeta.PlanetaService;
import app.services.CrudService;

public enum CrudServiceEnum {
    CLIMA_SERVICE(new ClimaService()),
    PLANETA_SERVICE(new PlanetaService());
    private CrudService crudService;

    CrudServiceEnum(CrudService crudService) {
        this.crudService = crudService;
    }

    public CrudService getCrudService() {
        return crudService;
    }
}
