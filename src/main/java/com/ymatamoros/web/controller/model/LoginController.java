package com.ymatamoros.web.controller.model;

import com.ymatamoros.web.controller.CustomValidation.User;
import com.ymatamoros.web.controller.CustomValidation.UserValidator;
import com.ymatamoros.web.controller.GetPropertyValues;
import com.ymatamoros.web.controller.Result;
import com.ymatamoros.web.controller.model.LoginBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by yehoshuamatamorosvalverde on 11/11/16.
 */
@Controller
public class LoginController{

    List<String> UserNames = Arrays.asList("User", "Admin", "Sudo");
    //List<String> RestrictedWords = Arrays.asList("cannabis", "abuse","crack","damn","drunk","grass");

    @RequestMapping("/")
    public String index(ModelMap map) {
        if( map.get("LoginBean") == null ){
            map.addAttribute("LoginBean", new LoginBean());
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }

    @RequestMapping(value="/dosomething", method= RequestMethod.POST)
    public String doSubmit(
            @ModelAttribute("LoginBean") @Valid LoginBean loginBean,
            BindingResult bindResult,
            ModelMap map) throws IOException {
        if (loginBean != null && loginBean.getName() != null && loginBean.getName()!= "") {
            if( bindResult.hasErrors() ) {
                return "login";
            }
            if (checkRestrictedUser(map, loginBean)) return "login";
            Result<Boolean, List<String>> result = checkUsername(loginBean.getName());
            if (result.getIsvaild()) {
                map.addAttribute("msg", loginBean.getName());
                return "success";
            } else {
                String message = "the suggested alternates :";
                for(int i=0;i<result.getContent().size();i++){
                    message += " " + result.getContent().get(i) +"<br/>";
                }
                map.addAttribute("error", message);
                return "login";
            }
        } else {
            map.addAttribute("error", "Please enter Username");
            return "login";
        }
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) throws IOException {
//        if (loginBean != null && loginBean.getName() != null && loginBean.getName()!= "") {
//
//            if (checkRestrictedUser(model, loginBean)) return "login";
//            Result<Boolean, List<String>> result = checkUsername(loginBean.getName());
//            if (result.getIsvaild()) {
//                model.addAttribute("msg", loginBean.getName());
//                return "success";
//            } else {
//                String message = "the suggested alternates :";
//                for(int i=0;i<result.getContent().size();i++){
//                    message += " " + result.getContent().get(i) +"<br/>";
//                }
//                model.addAttribute("error", message);
//                return "login";
//            }
//        } else {
//            model.addAttribute("error", "Please enter Username");
//            return "login";
//        }
//    }


    public boolean checkRestrictedUser(ModelMap model, @ModelAttribute("loginBean") LoginBean loginBean) throws IOException {
        GetPropertyValues properties = new GetPropertyValues();
        String RestrictedWords = properties.getPropValues();
        if(RestrictedWords.toLowerCase().trim().contains(loginBean.getName().toLowerCase())){
                model.addAttribute("error", "Login name Restricted");
                return true;
         }
        return false;
    }

    Result<Boolean, List<String>> checkUsername(String username) {
        Result<Boolean,List<String>> box1 = new Result<Boolean,List<String>>(false,null);
        for(String str: UserNames) {
            if(str.toLowerCase().trim().equals(username.toLowerCase())){
                box1.setIsvaild(false);
                int count = 1;
                String newUserName;
                int max = 2000;
                int min = 1;
                List<String> alternatives = new ArrayList<String>();
                while (count < 15) {
                    Random rand = new Random();
                    int value = rand.nextInt((max - min) + 1) + min;
                    newUserName = (username + value).substring(0,6);
                    checkUsername(newUserName);
                    alternatives.add(newUserName);
                    count++;
                }
                box1.setContent(alternatives);
                break;
            }else{
                box1.setIsvaild(true);
            }
        }
        return box1;
    }
}
