package pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries;

public class TransactionTypeException extends RuntimeException { // extends MultiException

    public TransactionTypeException(String message) {
        super(message);
    }

    public TransactionTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
