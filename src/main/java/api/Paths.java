package api;

public class Paths {
    public static class Api {
        public static final String CLIMA = "/clima";
        public static final String CLIMA_ID = "/clima/:id";
        public static final String PLANETA = "/planeta";
        public static final String PLANETA_ID = "/planeta/:id";
        public static final String RESET = "/reset";
        public static final String RESET_FULL = "/reset_full";
        public static final String PRONOSTICO = "/pronostico/:dias";
        public static final String PRONOSTICO_PERIODO = "/pronostico/:diaInicio/:diaFinal";
        public static final String ANALISIS = "/analisis";
    }
}
