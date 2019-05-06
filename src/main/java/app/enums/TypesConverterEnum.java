package app.enums;

import com.google.gson.Gson;

public enum TypesConverterEnum {
    instance;
    private Gson gson = new Gson();

    public Gson getGson() {
        return gson;
    }
}
