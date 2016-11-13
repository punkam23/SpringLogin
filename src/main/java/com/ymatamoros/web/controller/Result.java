package com.ymatamoros.web.controller;

import java.util.List;

/**
 * Created by yehoshuamatamorosvalverde on 11/12/16.
 */
public class Result<T, E> {

    // Private variable
    private boolean isvaild;
    private List<String> content;

    // Constructor
    public Result(boolean isvaild, List<String> content) {
        this.isvaild =isvaild;
        this.content = content;
    }

    public boolean getIsvaild() {
        return isvaild;
    }

    public void setIsvaild(boolean isvaild) {
        this.isvaild = isvaild;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    //public String toString() {
   //     return content + " (" + content.getClass() + ")";
    //}
}
