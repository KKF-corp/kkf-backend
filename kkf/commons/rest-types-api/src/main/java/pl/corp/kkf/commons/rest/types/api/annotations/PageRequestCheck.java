package pl.corp.kkf.commons.rest.types.api.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, ANNOTATION_TYPE, FIELD, PARAMETER, CONSTRUCTOR, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface PageRequestCheck {

    int pageMaxSize() default 100;

    boolean disableSortByCheck() default false;

    String[] sortByAllowed() default {};

    String message() default "PageRequestCheckDTO invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
