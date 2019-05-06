package api.controllers;

import app.planeta.PlanetaService;
import app.services.ToolsService;
import spark.Request;
import spark.Response;
import spark.Route;

public class ResetController {
    public static Route resetPlanets(PlanetaService planetaService) {
        return (Request request, Response response) -> {
            response.status(202);
            planetaService.resetPlanets();
            return "Planetas reseteados!";
        };
    }

    public static Route resetAll(ToolsService toolsService) {
        return (Request request, Response response) -> {
            response.status(202);
            toolsService.resetAll();
            return "Todo ha sido reseteado!";
        };
    }
}
