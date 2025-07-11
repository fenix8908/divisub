package co.com.api.divisub.excepciones;

public class FoundUserException extends RuntimeException {

    public FoundUserException(String email) {
        super("Este usuario ya se ha registrado: " + email);
    }
}
