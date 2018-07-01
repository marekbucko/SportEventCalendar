package pl.sda.calendar.exception;

public class UserNameTakenException extends RuntimeException {
    public UserNameTakenException(String message) {
        super(message);
    }
}
