package app.analisis;

import app.clima.ClimaService;
import app.enums.CrudServiceEnum;
import app.enums.EstadosEnum;

public class AnalisisService {
    ClimaService climaService = (ClimaService)CrudServiceEnum.CLIMA_SERVICE.getCrudService();

    public Analisis buildAnalisis() {
        return new Analisis(
                climaService.countByTiempo(EstadosEnum.SEQUIA),
                climaService.countByTiempo(EstadosEnum.LLUVIA),
                climaService.getMaxSize(),
                climaService.countByTiempo(EstadosEnum.OPTIMO)
        );
    }
}
