package com.lhf.mall.management.controller;


import com.lhf.mall.management.domain.UserEntity;
import com.lhf.mall.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-10
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String login(){
        return "lyear_pages_login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request,UserEntity userEntity){
        String token = userService.login(userEntity);
        request.setAttribute("token",token);
        return "index";
    }

}
