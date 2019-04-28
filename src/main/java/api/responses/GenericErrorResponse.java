package api.responses;

public class GenericErrorResponse {
    public String message;
    public GenericErrorResponse(String errorMessage) {
        message = errorMessage;
    }
}
