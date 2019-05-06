package app.services;

import app.enums.DaoEnum;
import org.junit.jupiter.api.Test;
import testutils.DbTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModeloPlanetarioTest extends DbTestBase {

    void unPlanetaGira() {
        double startingPosition = DaoEnum.instance.getPlanetaDao().read("vulcano").getPosicionX();
        ModeloPlanetario.recorrerDias("vulcano", 5);
        double endingPosition = DaoEnum.instance.getPlanetaDao().read("vulcano").getPosicionX();
        assertEquals(startingPosition, endingPosition);
    }
}
