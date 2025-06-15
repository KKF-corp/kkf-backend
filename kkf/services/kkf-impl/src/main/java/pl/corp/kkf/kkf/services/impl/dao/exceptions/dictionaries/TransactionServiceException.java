package pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries;

public class TransactionServiceException extends RuntimeException { // extends MultiException

    public TransactionServiceException(String message) {
        super(message);
    }

    public TransactionServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
