package app.dia;

import app.enums.DaoEnum;
import app.planeta.Planeta;
import app.services.CrudService;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class DiaService implements CrudService<Dia> {

    private DiaDao diaDao = DaoEnum.instance.getDiaDao();

    @Override
    public void create(Dia dia) {
        diaDao.create(dia);
    }

    @Override
    public Dia read(Integer id) {
        return diaDao.read(id);
    }

    @Override
    public void update(Dia object) {

    }

    @Override
    public void delete(Dia object) {

    }

    @Override
    public List<Dia> list() {
        return null;
    }

    public List<Planeta> getPlanetas(int numeroDia) {
        List<Planeta> planetas = new ArrayList<>();
        Iterable<Dia> dias = diaDao.filter(eq("numero", numeroDia));
        dias.forEach(dia -> planetas.add(dia.getPlaneta()));
        return planetas;
    }

    public Planeta getPlaneta(int numeroDia, String nombrePlaneta) {
        return diaDao.findPlaneta(numeroDia, nombrePlaneta);
    }
}
