package app.services;

import app.dia.Dia;
import app.dia.DiaDao;
import app.enums.CrudServiceEnum;
import app.enums.DaoEnum;
import app.planeta.Planeta;
import app.planeta.PlanetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PronosticoService {

    public static void generarDias(Planeta planeta, int dias, DiaDao diaDao) {
        Logger logger = LoggerFactory.getLogger(PronosticoService.class);
        logger.info(String.format("Generando: %s...", planeta.getNombre()));
        for (int i = 0; i < dias; i++) {
            diaDao.create(
                    new Dia(i, ModeloPlanetario.recorrerDias(planeta.getNombre(), i))
            );
        }
    }

    public static void asyncGenerarPronostico(int dias) {
        CompletableFuture.runAsync(() -> generarPosicionesDePlanetas(dias));
    }

    public static void asyncGenerarPosicionesDePlanetas(int dias) {
        CompletableFuture.runAsync(() -> generarPosicionesDePlanetas(dias));
    }

    public static void generarPosicionesDePlanetas(int dias) {
        PlanetaService planetaService = (PlanetaService)CrudServiceEnum.PLANETA_SERVICE.getCrudService();
        CompletableFuture<Void> processVulcano = CompletableFuture.runAsync(
                () -> generarDias(planetaService.read("vulcano"), dias, new DiaDao())
        );
        CompletableFuture<Void> processBetasoide = CompletableFuture.runAsync(
                () -> generarDias(planetaService.read("betasoide"), dias, new DiaDao())
        );
        CompletableFuture<Void> processFerengi = CompletableFuture.runAsync(
                () -> generarDias(planetaService.read("ferengi"), dias, new DiaDao())
        );
        CompletableFuture.allOf(processVulcano, processBetasoide, processFerengi).thenRun(
                PronosticoService::generarClimas
        );
    }

    public static void generarClimas() {

    }
}
