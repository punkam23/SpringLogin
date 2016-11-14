package com.ymatamoros.web.controller.model;

import com.ymatamoros.web.controller.CustomValidation.User;

import javax.validation.constraints.Size;

/**
 * Created by yehoshuamatamorosvalverde on 11/12/16.
 */
public class LoginBean {

    @User(message="User Name Contains special characters",verifySpecialChar = true)
    @Size(min=1,max=6)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoginBean() {
    }

}