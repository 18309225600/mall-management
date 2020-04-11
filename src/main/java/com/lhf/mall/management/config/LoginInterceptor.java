package com.lhf.mall.management.config;

import com.lhf.mall.management.domain.UserEntity;
import com.lhf.mall.management.util.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/11
 **/
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //check session invalid
        UserEntity user = (UserEntity) session.getAttribute("user");

        if (Objects.isNull(user)){
            log.info("用户凭证不存在,跳转登录页。。");
            response.sendRedirect(request.getContextPath()+"/login/page");
            return false;
        }

        log.info("current login username is : {}",user.getName());
        SessionUtils.set(user);
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
