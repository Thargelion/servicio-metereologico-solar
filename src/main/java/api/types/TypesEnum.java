package api.types;

import spark.ResponseTransformer;

public enum TypesEnum {
    JSON(new JsonResponse());
    ResponseTransformer responseTransformer;
    TypesEnum(ResponseTransformer type) {
        responseTransformer = type;
    }

    public ResponseTransformer getResponseType() {
        return responseTransformer;
    }
}
