package pl.corp.kkf.commons.base.service.validate;

import java.util.function.Supplier;

public interface BaseValidator {
    //    default <T> void check(boolean check, List<T> fieldErrors, String message) {
//        if (check) {
//            fieldErrors.add(new T())
//        }
//    }
    RuntimeException createException(String message);

    default void check(boolean condition, String message) {
        if (condition) {
            throw createException(message);
        }
    }
}
