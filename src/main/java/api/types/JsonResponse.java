package api.types;

import app.enums.TypesConverterEnum;
import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonResponse implements ResponseTransformer {

    @Override
    public String render(Object model) {
        Gson gson = TypesConverterEnum.instance.getGson();
        return gson.toJson(model);
    }
}
