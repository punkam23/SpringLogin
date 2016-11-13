package com.ymatamoros.web.controller.model;

import com.ymatamoros.web.controller.CustomValidation.User;
/**
 * Created by yehoshuamatamorosvalverde on 11/12/16.
 */
public class LoginBean {
    @User(message="User Name must be less than 6 characters", caseSensitive=true)
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
