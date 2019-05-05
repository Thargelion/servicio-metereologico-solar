package api.types;

import spark.ResponseTransformer;

public enum ResponseTypesEnum {
    JSON(new JsonResponse());
    ResponseTransformer responseTransformer;
    ResponseTypesEnum(ResponseTransformer type) {
        responseTransformer = type;
    }

    public ResponseTransformer getResponseType() {
        return responseTransformer;
    }
}
