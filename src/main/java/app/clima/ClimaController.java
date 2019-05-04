package app.clima;

import api.Rest;
import app.enums.ServiceEnum;
import lib.transformers.JsonResponse;
import spark.Request;
import spark.Response;
import spark.Route;

public class ClimaController {
    public static Route getWeather = (Request request, Response response) ->  {
        ClimaService climaService = ServiceEnum.instance.getClimaService();
        return Rest.get(climaService.read(Integer.parseInt(request.params("id"))), new JsonResponse());
    };
}
