package com.lhf.mall.management.controller;


import com.lhf.mall.management.domain.UserEntity;
import com.lhf.mall.management.domain.std.StdResponse;
import com.lhf.mall.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/list")
    public StdResponse list(){
        List<UserEntity> userEntities = userService.listData();
        return StdResponse.newCorrectStdResponse(userEntities);
    }

}
