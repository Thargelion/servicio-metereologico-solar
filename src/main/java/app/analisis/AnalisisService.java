package app.analisis;

import app.clima.ClimaService;
import app.enums.CrudServiceEnum;

public class AnalisisService {
    ClimaService climaService = (ClimaService)CrudServiceEnum.CLIMA_SERVICE.getCrudService();

    public Analisis buildAnalisis() {
        return new Analisis(
                climaService.countByTiempo("sequia"),
                climaService.countByTiempo("lluvia"),
                climaService.getMaxSize(),
                climaService.countByTiempo("optimo")
        );
    }
}
