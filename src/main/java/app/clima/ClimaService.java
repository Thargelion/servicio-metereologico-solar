package app.clima;

import app.dia.DiaService;
import app.enums.CrudServiceEnum;
import app.enums.EstadosEnum;
import app.planeta.Planeta;
import app.services.CrudService;
import app.enums.DaoEnum;
import com.mongodb.client.MongoCollection;
import lib.math.geometry.Punto;
import lib.math.utils.Trigonometry;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

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

    public void cache(Clima clima) {
        climaDao.cache(clima);
    }

    public Integer countByTiempo(EstadosEnum estadosEnum) {
        MongoCollection<Clima> climas = climaDao.all();
        return (int) climas.countDocuments(eq("clima", estadosEnum.getEstado()));
    }

    public Integer getMaxSize() {
        return climaDao.max().getDia();
    }

    public void generateClimas(int startingPoint, int endingPoint) {
        for (int i = startingPoint; i < endingPoint; i++) {
            generateClima(i);
        }
    }

    public void generateClima(int dia) {
        DiaService diaService = new DiaService();
        ClimaService climaService = (ClimaService) CrudServiceEnum.CLIMA_SERVICE.getCrudService();
        Planeta vulcano = diaService.getPlaneta(dia, "vulcano");
        Planeta ferengi = diaService.getPlaneta(dia, "ferengi");
        Planeta betasoide = diaService.getPlaneta(dia, "betasoide");
        Punto vulcanoPoint = new Punto(vulcano.getPosicionX(), vulcano.getPosicionY());
        Punto ferengiPoint = new Punto(ferengi.getPosicionX(), ferengi.getPosicionY());
        Punto betasoidePoint = new Punto(betasoide.getPosicionX(), betasoide.getPosicionY());
        EstadosEnum climaAlineado = calcularAlineacion(vulcanoPoint, ferengiPoint, betasoidePoint);
        if (climaAlineado != null) {
            climaService.create(new Clima(dia, climaAlineado, 0));
        } else {
            climaService.create(standardClimaBuilder(dia, vulcano, ferengi, betasoide));
        }
    }

    private static EstadosEnum calcularAlineacion(Punto vulcano, Punto ferengi, Punto betasoide) {
        double[][] matriz = {{0, 0}, vulcano.getCoords(), ferengi.getCoords(), betasoide.getCoords()};
        if (Trigonometry.arePointsAligned(vulcano, ferengi, betasoide)) {
            return analizarAlineacion(matriz);
        } else {
            return null;
        }
    }

    private static EstadosEnum analizarAlineacion(double[][] coordenadasSistema) {
        if (Trigonometry.arePointsAligned(new Array2DRowRealMatrix(coordenadasSistema))) {
            return EstadosEnum.SEQUIA;
        } else {
            return EstadosEnum.OPTIMO;
        }
    }

    private static Clima standardClimaBuilder(int dia, Planeta vulcano, Planeta ferengi, Planeta betasoide) {
        double[] coordsVulcano = {vulcano.getPosicionX(), vulcano.getPosicionY()};
        double[] coordsFerengi = {ferengi.getPosicionX(), ferengi.getPosicionY()};
        double[] coordsBetasoide = {betasoide.getPosicionX(), betasoide.getPosicionY()};
        EstadosEnum tiempo = analizarClima(coordsVulcano, coordsFerengi, coordsBetasoide);
        double intensidad = Trigonometry.crossProduct(coordsVulcano, coordsFerengi, coordsBetasoide);
        return new Clima(dia, tiempo, intensidad);
    }

    private static EstadosEnum analizarClima(double[] coordsVulcano, double[] coordsFerengi, double[] cordsBetasoide) {
        double[] coordsSol = {0, 0};
        if (Trigonometry.isPointInTri(coordsSol, coordsVulcano, coordsFerengi, cordsBetasoide)) {
            return EstadosEnum.LLUVIA;
        } else {
            return EstadosEnum.SOLEADO;
        }
    }
}
