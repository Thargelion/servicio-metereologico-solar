package lib.transformers;

import app.enums.ResponseUtilsEnum;
import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonResponse implements ResponseTransformer {

    @Override
    public String render(Object model) {
        Gson gson = ResponseUtilsEnum.instance.getGson();
        return gson.toJson(model);
    }
}
