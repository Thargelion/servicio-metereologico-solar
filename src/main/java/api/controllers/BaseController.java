package api.controllers;

import api.Rest;
import api.types.ResponseTypesEnum;
import app.enums.ResponseUtilsEnum;
import app.services.CrudService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class BaseController {

    public static Route get(CrudService crudService) {
        return (Request request, Response response) ->
                Rest.get(crudService.read(Integer.parseInt(request.params("id"))), ResponseTypesEnum.JSON.getResponseType());
    }

    public static Route post(CrudService crudService) {
        return (Request request, Response response) -> {
            response.status(201);
            Gson gson = ResponseUtilsEnum.instance.getGson();
            gson.fromJson(request.body(), request.)
            crudService.create(request.body());
            return Rest.post(crudService.create(Integer.parseInt(request.params("id"))), ResponseTypesEnum.JSON.getResponseType());
        };
    }

    public static Route put(CrudService crudService) {
        return (Request request, Response response) ->
                Rest.get(crudService.read(Integer.parseInt(request.params("id"))), ResponseTypesEnum.JSON.getResponseType());
    }

}
