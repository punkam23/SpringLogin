package com.ymatamoros.web.controller.CustomValidation;


import java.lang.annotation.Annotation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by yehoshuamatamorosvalverde on 11/12/16.
 */
public class UserValidator implements ConstraintValidator<User, String> {

    private User user;

    @Override
    public void initialize(User user) {
        this.user = user;
    }

    @Override
    public boolean isValid(String t, ConstraintValidatorContext constraintValidatorContext) {
        if( user.caseSensitive() )
            return t.length()<7;
        else
            return true;
    }
}
