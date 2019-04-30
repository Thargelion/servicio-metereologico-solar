package app;
import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.Spark.*;
import app.clima.ClimaController;
import app.home.HomeController;
import utils.Paths;


public class Application {

    public static void main(String[] args) {
        // Configure Spark
        port(4567);
        staticFiles.expireTime(600L);
        get("/", HomeController.index);
        get(Paths.Api.CLIMA, ClimaController.getWeather);
    }

    public static void end() {
        stop();
    }

}
