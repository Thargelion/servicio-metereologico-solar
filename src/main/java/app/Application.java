package app;

import app.clima.ClimaController;
import utils.Paths;

import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.Spark.*;

public class Application {

    public static void main(String[] args) {

        // Configure Spark
        port(4567);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        // enableDebugScreen();

        // Set up after-filters (called after each get/post)
        // after("*",                   Filters.addGzipHeader);
        get(Paths.Api.CLIMA, ClimaController.getWeather);
    }

}
