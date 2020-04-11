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

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/list/page")
    public String listPage(){
        return "user_list";
    }

}
