package api.controllers;

import api.Rest;
import api.responses.GenericCreateResponse;
import api.types.TypesEnum;
import app.enums.TypesConverterEnum;
import app.planeta.Planeta;
import app.planeta.PlanetaService;
import app.services.CrudService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class PlanetaController extends BaseController {
    public static Route post(PlanetaService crudService) {
        return (Request request, Response response) -> {
            response.status(201);
            Gson gson = TypesConverterEnum.instance.getGson();
            Planeta planetaNuevo = gson.fromJson(request.body(), Planeta.class);
            crudService.create(planetaNuevo);
            return Rest.post(
                    new GenericCreateResponse<>("Creado", planetaNuevo),
                    TypesEnum.JSON.getResponseType()
            );
        };
    }

    public static Route put(CrudService crudService) {
        return (Request request, Response response) ->
                Rest.get(crudService.read(Integer.parseInt(request.params("id"))), TypesEnum.JSON.getResponseType());
    }
}
