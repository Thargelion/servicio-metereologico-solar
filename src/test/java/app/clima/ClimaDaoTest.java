package app.clima;

import org.junit.jupiter.api.Test;

public class ClimaDaoTest {
    @Test()
    void createClimaTest() {
        ClimaDao climaDao = new ClimaDao();
        climaDao.save(new Clima(10, "pato"));
    }
}
