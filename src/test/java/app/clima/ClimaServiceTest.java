package app.clima;

import org.junit.jupiter.api.Test;
import testutils.DbTestBase;

public class ClimaServiceTest extends DbTestBase {

    @Test()
    void generateClimaGeneratesClima() {
        ClimaService.generateClima(0);
    }

    @Test()
    void generateClimaGeneratesClimas() {
        ClimaService.generateClimas(1, 4);
    }
}
