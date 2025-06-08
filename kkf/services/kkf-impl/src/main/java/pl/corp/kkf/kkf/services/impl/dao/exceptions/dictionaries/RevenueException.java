package pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries;

public class RevenueException extends RuntimeException { // extends MultiException

    public RevenueException(String message) {
        super(message);
    }

    public RevenueException(String message, Throwable cause) {
        super(message, cause);
    }
}
