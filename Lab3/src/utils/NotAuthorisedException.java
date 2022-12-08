package utils;

public class NotAuthorisedException extends Exception {
    public NotAuthorisedException(String errorMessage) {
        super(errorMessage);
    }
}
