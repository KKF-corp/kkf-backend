package pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries;

public class AddressException extends RuntimeException {

    public AddressException(String message) {
        super(message);
    }

    public AddressException(String message, Throwable cause) {
        super(message, cause);
    }
}
