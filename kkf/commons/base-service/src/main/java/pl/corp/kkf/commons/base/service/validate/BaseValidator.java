package pl.corp.kkf.commons.base.service.validate;

import java.util.function.Supplier;

public interface BaseValidator {
    static <E extends RuntimeException> void check(boolean condition, Supplier<E> exceptionSupplier) {
        if (condition) {
            throw exceptionSupplier.get();
        }
    }
}
