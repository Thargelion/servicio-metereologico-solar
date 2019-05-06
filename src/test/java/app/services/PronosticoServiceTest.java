package app.services;

import app.enums.DaoEnum;
import app.planeta.Planeta;
import app.planeta.PlanetaDao;
import org.junit.jupiter.api.Test;

public class PronosticoServiceTest {

    void generarDiasGeneraDias() {
        PlanetaDao planetaDao = DaoEnum.instance.getPlanetaDao();
        Planeta planeta = planetaDao.read("vulcano");
        PronosticoService.generarDias(planeta, 72, DaoEnum.instance.getDiaDao());
    }

    void generarPosicionesDePlanetas() {
        PronosticoService.generarPosicionesDePlanetas(72);
    }
}
