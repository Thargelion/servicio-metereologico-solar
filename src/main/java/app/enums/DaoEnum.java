package app.enums;

import app.clima.ClimaDao;

public enum DaoEnum {
    instance;
    private ClimaDao climaDao = new ClimaDao();
    private DaoEnum(){}

    public ClimaDao getClimaDao() {
        return climaDao;
    }
}
