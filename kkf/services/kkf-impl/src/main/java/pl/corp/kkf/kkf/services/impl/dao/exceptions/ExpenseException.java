package pl.corp.kkf.kkf.services.impl.dao.exceptions;

public class ExpenseException extends RuntimeException { // extends MultiException

    public ExpenseException(String message) {
        super(message);
    }

    public ExpenseException(String message, Throwable cause) {
        super(message, cause);
    }
}
