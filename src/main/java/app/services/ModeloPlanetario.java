package app.services;

import app.enums.DaoEnum;
import app.planeta.Planeta;
import app.planeta.PlanetaDao;
import lib.math.geometry.Punto;

public class ModeloPlanetario {

    public static Planeta recorrerDias(String nombrePlaneta, int dias) {
        PlanetaDao planetaDao = DaoEnum.instance.getPlanetaDao();
        Planeta planeta = planetaDao.read(nombrePlaneta);
        Punto punto = new Punto(planeta.getPosicionX(), planeta.getPosicionY());
        punto.Rotacion(planeta.getVelocidad() * dias);
        planeta.setPosicionX(punto.getCoordX());
        planeta.setPosicionY(punto.getCoordY());
        return planeta;
    }
}
