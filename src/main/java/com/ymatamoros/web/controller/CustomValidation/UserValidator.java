package com.ymatamoros.web.controller.CustomValidation;


import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        boolean result = false;
        if(user.verifySpecialChar()){
            Pattern p = Pattern.compile("[^A-Za-z0-9]");//. represents single character
            boolean b = p.matcher(t.toString()).find();
            return !(b);
        }else{
            return true;
        }
    }
}
