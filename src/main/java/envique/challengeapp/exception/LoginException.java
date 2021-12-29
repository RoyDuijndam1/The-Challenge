package envique.challengeapp.exception;

public class LoginException extends Exception {
    public String message;

    public LoginException(String message) {
        this.message = message;
    }
}
