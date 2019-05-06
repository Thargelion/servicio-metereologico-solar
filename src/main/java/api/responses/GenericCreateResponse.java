package api.responses;

public class GenericCreateResponse<T> {
    String message;
    T created;

    public GenericCreateResponse(String message, T object) {
        this.message = message;
        this.created = object;
    }
}
