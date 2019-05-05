package app.enums;

import com.google.gson.Gson;

public enum ResponseUtilsEnum {
    instance;
    private Gson gson = new Gson();

    public Gson getGson() {
        return gson;
    }
}
