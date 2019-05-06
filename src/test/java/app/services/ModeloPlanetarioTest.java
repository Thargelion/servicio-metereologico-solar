package app.services;

import app.enums.DaoEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ModeloPlanetarioTest {

    @Test()
    void unPlanetaGira() {
        double startingPosition = DaoEnum.instance.getPlanetaDao().read("vulcano").getPosicionX();
        ModeloPlanetario.recorrerDias("vulcano", 5);
        double endingPosition = DaoEnum.instance.getPlanetaDao().read("vulcano").getPosicionX();
        assertNotEquals(startingPosition, endingPosition, 0.0);
    }
}
