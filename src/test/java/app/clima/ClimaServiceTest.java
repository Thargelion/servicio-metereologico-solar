package app.clima;

import org.junit.jupiter.api.Test;
import testutils.DbTestBase;

public class ClimaServiceTest extends DbTestBase {

    @Test()
    void generateClimaGeneratesClima() {
        ClimaService climaService = new ClimaService();
        climaService.generateClima(0);
    }

    @Test()
    void generateClimaGeneratesClimas() {
        ClimaService climaService = new ClimaService();
        climaService.generateClimas(1, 4);
    }
}
