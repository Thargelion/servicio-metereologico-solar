package app.enums;

import app.clima.ClimaDao;
import app.dia.DiaDao;
import app.planeta.PlanetaDao;

public enum DaoEnum {
    instance;
    private ClimaDao climaDao = new ClimaDao();
    private PlanetaDao planetaDao = new PlanetaDao();
    private DiaDao diaDao = new DiaDao();
    DaoEnum(){}
    public ClimaDao getClimaDao() {
        return climaDao;
    }
    public PlanetaDao getPlanetaDao() {
        return planetaDao;
    }
    public DiaDao getDiaDao() { return diaDao; }
}
