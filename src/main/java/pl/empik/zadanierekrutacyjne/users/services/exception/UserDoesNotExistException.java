package pl.empik.zadanierekrutacyjne.users.services.exception;


public class UserDoesNotExistException extends Exception {
    public UserDoesNotExistException() {
        super("User does not exist on GitHub service");
    }
}