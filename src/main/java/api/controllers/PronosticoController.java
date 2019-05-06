package api.controllers;

import app.services.PronosticoService;
import spark.Request;
import spark.Response;
import spark.Route;

public class PronosticoController {
    public static Route get() {
        return (Request request, Response response) -> {
            String dias = request.params("dias");
            response.status(201);
            PronosticoService pronosticoService = new PronosticoService();
            pronosticoService.asyncGenerarPosicionesDePlanetas(Integer.parseInt(dias));
            return String.format("%s días enviados a procesar", dias);
        };
    }
}
