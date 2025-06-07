package pl.corp.kkf.kkf.services.impl.dao.exceptions.dictionaries;

public class ContractorException extends RuntimeException { // extends MultiException

    public ContractorException(String message) {
        super(message);
    }

    public ContractorException(String message, Throwable cause) {
        super(message, cause);
    }
}
