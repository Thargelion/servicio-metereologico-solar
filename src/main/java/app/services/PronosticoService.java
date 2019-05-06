package app.services;

import app.clima.ClimaService;
import app.dia.Dia;
import app.dia.DiaDao;
import app.enums.CrudServiceEnum;
import app.planeta.Planeta;
import app.planeta.PlanetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public void asyncGenerarPronostico(int dias) {
        CompletableFuture.runAsync(() -> generarPosicionesDePlanetas(dias));
    }

    public void asyncGenerarPosicionesDePlanetas(int dias) {
        CompletableFuture.runAsync(() -> generarPosicionesDePlanetas(dias));
    }

    public void generarPosicionesDePlanetas(int dias) {
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
                () -> generarClimas(dias)
        );
    }

    public static void generarClimas(int dias) {
        Logger logger = LoggerFactory.getLogger(PronosticoService.class);
        logger.info("Empezando a generar pronóstico");
        ClimaService climaService = (ClimaService)CrudServiceEnum.CLIMA_SERVICE.getCrudService();
        climaService.generateClimas(0, dias);
        logger.info(String.format("Generados %s pronósticos", dias));
    }

    public static void generarClimas(int diaInicio, int diaFinal) {
        Logger logger = LoggerFactory.getLogger(PronosticoService.class);
        logger.info("Empezando a generar pronóstico");
        ClimaService climaService = (ClimaService)CrudServiceEnum.CLIMA_SERVICE.getCrudService();
        climaService.generateClimas(diaInicio, diaFinal);
        logger.info(String.format("Generados %s pronósticos", diaFinal - diaInicio));
    }
}
