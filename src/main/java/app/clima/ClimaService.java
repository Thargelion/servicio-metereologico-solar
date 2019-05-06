package app.clima;

import app.services.CrudService;
import app.enums.DaoEnum;

import java.util.List;

public class ClimaService implements CrudService<Clima> {

    private ClimaDao climaDao = DaoEnum.instance.getClimaDao();

    @Override
    public void create(Clima object) {
        climaDao.save(object);
    }

    @Override
    public Clima read(Integer id) {
        return climaDao.read(id);
    }

    @Override
    public void update(Clima object) {

    }

    @Override
    public void delete(Clima object) {

    }

    @Override
    public List<Clima> list() {
        return null;
    }

    public static void generateClimas() {

    }
}
