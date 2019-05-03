package app.config;

public enum SettingsEnum {
    APP_ENV (System.getenv("APP_ENV")),
    MONGO_DATABASE (System.getenv("MONGO_DATABASE")),
    MONGO_USER (System.getenv("MONGO_USER")),
    MONGO_PASSWORD (System.getenv("MONGO_PASSWORD")),
    MONGO_SRV (System.getenv("MONGO_SRV"));
    public String variable;
    SettingsEnum(String variable){
        this.variable = variable;
    }
}