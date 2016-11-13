package com.ymatamoros.web.controller.model;

import com.ymatamoros.web.controller.Result;
import junit.framework.TestCase;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by yehoshuamatamorosvalverde on 11/12/16.
 */
public class LoginControllerTest extends TestCase {
    public void testIndex() throws Exception {
    }

    public void testInit() throws Exception {

    }

    public void testDoSubmit() throws Exception {

    }


    public void testCheckRestrictedUser() throws Exception {
        LoginController login= new LoginController();
        ModelMap model = new ModelMap();
        LoginBean loginBean = new LoginBean();
        loginBean.setName("admin");
        boolean checkRestricted = false;
        com.ymatamoros.web.controller.Result<Boolean,List<String>> result= new Result<Boolean, List<String>>(false,null);
        checkRestricted = login.checkRestrictedUser(model,loginBean);
        assertEquals(checkRestricted,false);
        assertEquals(result.getIsvaild(),false);
    }

    public void testCheckUsername() throws Exception {

        LoginController login= new LoginController();
        com.ymatamoros.web.controller.Result<Boolean,List<String>> result= new Result<Boolean, List<String>>(false,null);
        result = login.checkUsername("admon");
        assertEquals(result.getIsvaild(),true);

    }


}