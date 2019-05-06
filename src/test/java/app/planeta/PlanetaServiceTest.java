package app.planeta;

import org.junit.jupiter.api.Test;
import testutils.DbTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanetaServiceTest extends DbTestBase {
    @Test()
    void resetPlanetsResetsPlanets() {
        PlanetaService planetaService = new PlanetaService();
        planetaService.resetPlanets();
        assertEquals(0.0, planetaService.read("vulcano").getPosicionX());
    }
}
