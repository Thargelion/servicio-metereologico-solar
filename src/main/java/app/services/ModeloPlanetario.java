package app.services;

import app.enums.DaoEnum;
import app.planeta.Planeta;
import app.planeta.PlanetaDao;
import lib.math.geometry.Point;

public class ModeloPlanetario {

    public static Planeta recorrerDias(String nombrePlaneta, int dias) {
        PlanetaDao planetaDao = DaoEnum.instance.getPlanetaDao();
        Planeta planeta = planetaDao.read(nombrePlaneta);
        Point point = new Point(planeta.getPosicionX(), planeta.getPosicionY());
        point.Rotacion(planeta.getVelocidad() * dias);
        planeta.setPosicionX(point.getCoordX());
        planeta.setPosicionY(point.getCoordY());
        planetaDao.save(planeta);
        return planeta;
    }
}
