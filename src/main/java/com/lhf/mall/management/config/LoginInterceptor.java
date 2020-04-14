package com.lhf.mall.management.config;

import com.alibaba.fastjson.JSON;
import com.lhf.mall.management.constant.RedisKeyConstant;
import com.lhf.mall.management.constant.StrConstant;
import com.lhf.mall.management.domain.UserEntity;
import com.lhf.mall.management.domain.std.StdErrorCodeEnum;
import com.lhf.mall.management.domain.std.StdException;
import com.lhf.mall.management.util.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.MessageFormat;
import java.util.Objects;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/11
 **/
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(StrConstant.TOKEN);
        if (StringUtils.isEmpty(token)){
            throw new StdException(StdErrorCodeEnum.MALL_USER_00001);
        }

        String tokenRedisKey = MessageFormat.format(RedisKeyConstant.USER_TOKEN, token);
        String userJson = redisTemplate.opsForValue().get(tokenRedisKey);
        UserEntity user = JSON.parseObject(userJson,UserEntity.class);


        log.info("current login username is : {}",user.getName());
        SessionUtils.set(user);
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
