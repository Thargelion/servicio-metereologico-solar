package app.home;

import spark.Request;
import spark.Response;
import spark.Route;

public class HomeController {
    public static Route index = (Request request, Response response) -> "Live long and prosper";
}
