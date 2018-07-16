package com.rimi.cs.controller;

import com.rimi.cs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登录
 *
 * @author wenyan
 * @date 2018-06-25 19:43
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "manger/management";
    }


}
