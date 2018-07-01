package pl.sda.calendar.model.exception;

public class UserNameTakenException extends RuntimeException {

    public UserNameTakenException(String message){
        super(message);
    }
}
