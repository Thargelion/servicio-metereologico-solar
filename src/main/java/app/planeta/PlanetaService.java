package app.planeta;

import app.enums.DaoEnum;
import app.services.CrudService;

import java.util.List;

public class PlanetaService implements CrudService<Planeta> {
    private PlanetaDao planetaDao = DaoEnum.instance.getPlanetaDao();
    @Override
    public void create(Planeta planeta) {
        planetaDao.create(planeta);
    }

    @Override
    public Planeta read(Integer id) {
        return null;
    }

    public Planeta read(String planetaName) {
        return planetaDao.read(planetaName);
    }

    @Override
    public void update(Planeta object) {

    }

    @Override
    public void delete(Planeta object) {

    }

    @Override
    public List<Planeta> list() {
        return planetaDao.list();
    }

    public void resetPlanets() {
        planetaDao.save(new Planeta("vulcano", 0.0, 1000.0, 5.0));
        planetaDao.save(new Planeta("ferengi", 0.0, 500.0, -1.0));
        planetaDao.save(new Planeta("betasoide", 0.0, 2000.0, -3.0));
    }
}
