package pl.corp.kkf.services.dictionaries.impl.dao.exceptions;

public class AddressException extends RuntimeException {

    public AddressException(String message) {
        super(message);
    }

    public AddressException(String message, Throwable cause) {
        super(message, cause);
    }
}
