package api.controllers;

import api.Rest;
import api.types.TypesEnum;
import app.services.CrudService;
import spark.Request;
import spark.Response;
import spark.Route;

public class BaseController {

    public static Route get(CrudService crudService) {
        return (Request request, Response response) ->
                Rest.get(crudService.read(Integer.parseInt(request.params("id"))), TypesEnum.JSON.getResponseType());
    }

}
