package com.user.exception;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = DuplicateEmailValidate.class)
public @interface DuplicateEmail {

    String message() default "Email nay da ton tai";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
