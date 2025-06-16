package pl.corp.kkf.kkf.services.impl.dao.exceptions;

public class TransactionPositionException extends RuntimeException { // extends MultiException

    public TransactionPositionException(String message) {
        super(message);
    }

    public TransactionPositionException(String message, Throwable cause) {
        super(message, cause);
    }
}
