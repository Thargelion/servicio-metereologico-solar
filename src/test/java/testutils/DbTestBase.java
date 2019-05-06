package testutils;

import app.config.SettingsEnum;
import app.enums.DaoEnum;
import app.planeta.Planeta;
import app.services.PronosticoService;
import lib.redis.RedisConnect;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class DbTestBase {

    @BeforeAll()
    public static void ignite() {
        SettingsEnum.MONGO_DATABASE.variable = "vulcano-test";
        PronosticoService.generarDias(new Planeta("vulcano", 0.0, 1000.0, 5.0), 5, DaoEnum.instance.getDiaDao());
        PronosticoService.generarDias(new Planeta("ferengi", 0.0, 500.0, -1.0), 5, DaoEnum.instance.getDiaDao());
        PronosticoService.generarDias(new Planeta("betasoide", 0.0, 2000.0, -3.0), 5, DaoEnum.instance.getDiaDao());
    }

    public static void end() {
    }
}
