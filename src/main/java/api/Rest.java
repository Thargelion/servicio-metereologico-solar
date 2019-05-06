package api;

import spark.ResponseTransformer;

import java.util.List;

public class Rest {
    public static String getList(List objects, ResponseTransformer responseTransformer) throws Exception {
        return responseTransformer.render(objects);
    }

    public static String get(Object object, ResponseTransformer responseTransformer) throws Exception {
        return responseTransformer.render(object);
    }

    public static String post(Object message, ResponseTransformer responseTransformer) throws Exception {
        return responseTransformer.render(message);
    }

    public static String put(Object object, ResponseTransformer responseTransformer) throws Exception {
        return responseTransformer.render(object);
    }
}
