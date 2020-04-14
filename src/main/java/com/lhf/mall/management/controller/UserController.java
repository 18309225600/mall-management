package com.lhf.mall.management.controller;


import com.lhf.mall.management.domain.UserEntity;
import com.lhf.mall.management.domain.std.Pagination;
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

    @GetMapping("/info")
    public StdResponse userInfo(){
        UserEntity userInfo = userService.userInfo();
        return StdResponse.newCorrectStdResponse(userInfo);
    }

    @GetMapping("/page/users")
    public StdResponse pageUsers(@RequestParam(value = "name",required = false) String name,
                                 @RequestParam(value = "phone",required = false) String phone,
                                 @RequestParam(value = "pageNo",required = false,defaultValue = "1") Integer pageNo,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize){
        Pagination<UserEntity> pagination = userService.pageUsers(name,phone,pageNo,pageSize);
        return StdResponse.newCorrectPageStdResponse(pagination);
    }

    @PostMapping("/add")
    public StdResponse add(@RequestBody UserEntity userEntity){
        userService.add(userEntity);
        return StdResponse.newCorrectStdResponse();
    }

    @DeleteMapping("/delete/{id}")
    public StdResponse delete(@PathVariable("id") Long id){
        userService.delete(id);
        return StdResponse.newCorrectStdResponse();
    }
}
