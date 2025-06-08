package pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries;

public class TransactionServiceTypeException extends RuntimeException { // extends MultiException

    public TransactionServiceTypeException(String message) {
        super(message);
    }

    public TransactionServiceTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
