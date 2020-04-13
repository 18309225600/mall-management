package com.lhf.mall.management.controller;

import com.google.common.collect.Maps;
import com.lhf.mall.management.domain.UserEntity;
import com.lhf.mall.management.domain.std.StdResponse;
import com.lhf.mall.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/11
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public StdResponse login(@RequestBody UserEntity userEntity){
        String token = userService.login(userEntity);
        Map<String,String> result = Maps.newHashMapWithExpectedSize(1);
        result.put("token",token);
        return StdResponse.newCorrectStdResponse(result);
    }
}
