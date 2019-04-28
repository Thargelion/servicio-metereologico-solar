package lib.transformers;

import com.google.gson.Gson;

public abstract class JsonObject {
    private Gson gson = new Gson();

    public String toJson() {
        return gson.toJson(this);
    }
}
