package app.clima;

import app.dia.DiaService;
import app.enums.CrudServiceEnum;
import app.planeta.Planeta;
import app.services.CrudService;
import app.enums.DaoEnum;
import lib.math.utils.Trigonometry;

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

    public static void generateClimas(int startingPoint, int endingPoint) {
        for (int i = startingPoint; i < endingPoint; i++) {
            generateClima(i);
        }
    }

    public static void generateClima(int dia) {
        DiaService diaService = new DiaService();
        ClimaService climaService = (ClimaService) CrudServiceEnum.CLIMA_SERVICE.getCrudService();
        Planeta vulcano = diaService.getPlaneta(dia, "vulcano");
        Planeta ferengi = diaService.getPlaneta(dia, "ferengi");
        Planeta betasoide = diaService.getPlaneta(dia, "betasoide");
        double vulcanoX = vulcano.getPosicionX();
        double vulcanoY = vulcano.getPosicionY();
        double ferengiX = ferengi.getPosicionX();
        double ferengiY = ferengi.getPosicionY();
        double betasoideX = betasoide.getPosicionX();
        double betasoideY = betasoide.getPosicionY();
        double[][] coordenadasPlanetas = {{vulcanoX, vulcanoY}, {ferengiX, ferengiY}, {betasoideX, betasoideY}};
        double[][] coordenadasSistema = {{0, 0}, {vulcanoX, vulcanoY}, {ferengiX, ferengiY}, {betasoideX, betasoideY}};
        String climaAlineado = calcularAlineacion(coordenadasPlanetas, coordenadasSistema);
        if (climaAlineado != null) {
            climaService.create(new Clima(dia, climaAlineado, 0));
        } else {
            climaService.create(standardClimaBuilder(dia, vulcano, ferengi, betasoide));
        }
    }

    private static String calcularAlineacion(double[][] coordenadasPlanetas, double[][] coordenadasSistema) {
        if (Trigonometry.arePointsAligned(coordenadasPlanetas)) {
            return analizarAlineacion(coordenadasSistema);
        } else {
            return null;
        }
    }

    private static String analizarAlineacion(double[][] coordenadasSistema) {
        if (Trigonometry.arePointsAligned(coordenadasSistema)) {
            return "sequia";
        } else {
            return "optimo";
        }
    }

    private static Clima standardClimaBuilder(int dia, Planeta vulcano, Planeta ferengi, Planeta betasoide) {
        double[] coordsVulcano = {vulcano.getPosicionX(), vulcano.getPosicionY()};
        double[] coordsFerengi = {ferengi.getPosicionX(), ferengi.getPosicionY()};
        double[] coordsBetasoide = {betasoide.getPosicionX(), betasoide.getPosicionY()};
        String tiempo = analizarClima(coordsVulcano, coordsFerengi, coordsBetasoide);
        double intensidad = Trigonometry.crossProduct(coordsVulcano, coordsFerengi, coordsBetasoide);
        return new Clima(dia, tiempo, intensidad);
    }

    private static String analizarClima(double[] coordsVulcano, double[] coordsFerengi, double[] cordsBetasoide) {
        double[] coordsSol = {0, 0};
        if (Trigonometry.isPointInTri(coordsSol, coordsVulcano, coordsFerengi, cordsBetasoide)) {
            return "lluvia";
        } else {
            return "soleado";
        }
    }
}
