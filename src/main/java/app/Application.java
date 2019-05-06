package app;

import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.Spark.*;

import api.Paths;
import api.controllers.*;
import api.responses.GenericErrorResponse;
import api.types.TypesEnum;
import app.analisis.AnalisisService;
import app.enums.CrudServiceEnum;
import app.enums.DatabaseEnum;
import app.enums.ToolsEnum;
import app.planeta.PlanetaService;
import lib.redis.RedisConnect;


public class Application {

    public static void main(String[] args) {
        // Configure Spark
        port(Integer.parseInt(System.getProperty("port", "4567")));
        staticFiles.expireTime(600L);
        get("/", HomeController.index);
        // Clima
        get(Paths.Api.CLIMA_ID, ClimaController.get(CrudServiceEnum.CLIMA_SERVICE.getCrudService()));
        // get(Paths.Api.CLIMA, ClimaController.get(CrudServiceEnum.CLIMA_SERVICE.getCrudService()));
        // post(Paths.Api.CLIMA, ClimaController.post(CrudServiceEnum.CLIMA_SERVICE.getCrudService()));

        // Planeta
        get(Paths.Api.PLANETA, PlanetaController.get(CrudServiceEnum.PLANETA_SERVICE.getCrudService()));
        get(Paths.Api.PLANETA_ID, PlanetaController.get(CrudServiceEnum.PLANETA_SERVICE.getCrudService()));
        post(Paths.Api.PLANETA, PlanetaController.post((PlanetaService) CrudServiceEnum.PLANETA_SERVICE.getCrudService()));

        // Herramientas
        get(Paths.Api.RESET, ResetController.resetPlanets(new PlanetaService()));
        get(Paths.Api.PRONOSTICO, PronosticoController.get());
        get(Paths.Api.ANALISIS, AnalisisController.get(ToolsEnum.INSTANCE.getAnalisisService()));

        // Excepciones
        exception(IllegalArgumentException.class, (exception, request, response) -> {
            response.status(400);
            try {
                response.body(
                        TypesEnum.JSON.getResponseType().render(new GenericErrorResponse(exception.getMessage()))
                );
            } catch (Exception e) {
                e.printStackTrace();
                response.body("Error");
            }
        });
    }

    public static void end() {
        stop();
    }

}
