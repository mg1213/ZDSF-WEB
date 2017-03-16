package com.ztesoft.controller;

import com.ztesoft.dto.SimpleResult;
import com.ztesoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 研发二科 王永梅 .
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "userlogin")
    @ResponseBody
    public SimpleResult userLogin(String userName, String pwd, HttpServletRequest request) {

        return userService.userLogin(userName, pwd, request);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "getUserRole")
    @ResponseBody
    public String getUserRole(HttpServletRequest request) {
        return userService.getUserRole(request);
    }

    @RequestMapping(value = "getUserName")
    @ResponseBody
    public String getSessionUserName(HttpServletRequest request) {
        return userService.getSessionUserName(request);
    }


}
