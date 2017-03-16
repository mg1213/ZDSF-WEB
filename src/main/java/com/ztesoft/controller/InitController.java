package com.ztesoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 技术二科 王永梅 on 2017/3/16.
 */
@Controller
@RequestMapping
public class InitController {
    /**
     * 系统首页
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        return "index";
    }
}

