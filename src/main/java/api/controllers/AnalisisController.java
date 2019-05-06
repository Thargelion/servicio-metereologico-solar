package api.controllers;

import api.Rest;
import api.types.TypesEnum;
import app.analisis.AnalisisService;
import app.enums.ToolsEnum;
import app.services.CrudService;
import spark.Request;
import spark.Response;
import spark.Route;

public class AnalisisController {

    public static Route get(AnalisisService analisisService) {
        return (Request request, Response response) ->
                Rest.get(analisisService.buildAnalisis(), TypesEnum.JSON.getResponseType());
    }
}
