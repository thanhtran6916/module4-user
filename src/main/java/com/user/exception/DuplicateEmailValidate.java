package com.user.exception;

import com.user.model.User;
import com.user.service.user.IUserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class DuplicateEmailValidate implements ConstraintValidator<DuplicateEmail, String> {

    private IUserService userService;

    public DuplicateEmailValidate(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email.equals("")) {
            return true;
        }
        Optional<User> user = userService.findByEmail(email);
        if (user.isPresent()) {
            return false;
        }
        return true;
    }
}
