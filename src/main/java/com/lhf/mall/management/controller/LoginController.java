package com.lhf.mall.management.controller;

import com.lhf.mall.management.domain.UserEntity;
import com.lhf.mall.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/11
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/page")
    public String loginPage(){
        return "lyear_pages_login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, UserEntity userEntity){
        UserEntity user = userService.login(userEntity);
        request.getSession().setAttribute("user",user);
        if (Objects.nonNull(user)){
            return "index";
        }else{
            return "lyear_pages_login";
        }

    }
}
