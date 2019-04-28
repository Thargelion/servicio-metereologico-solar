package app.clima;

import api.Rest;
import lib.transformers.JsonResponse;
import spark.Request;
import spark.Response;
import spark.Route;

public class ClimaController {
    public static Route getWeather = (Request request, Response response) ->  {
        ClimaDao climaDao = new ClimaDao();
        return Rest.read(climaDao.read(request.params("id")), new JsonResponse());
    };
}
