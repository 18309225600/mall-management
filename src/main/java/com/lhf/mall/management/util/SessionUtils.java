package com.lhf.mall.management.util;

import com.lhf.mall.management.domain.UserEntity;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/11
 **/
public class SessionUtils {
    //线程本地变量
    private static ThreadLocal<SessionHolder> context = new ThreadLocal<>();


    public static void set(UserEntity user){
        clean();
        SessionHolder sessionHolder = new SessionHolder(user);
        context.set(sessionHolder);
    }

    public static void clean(){
        context.remove();
    }

    public static Long getUserId() {
        return context.get().getUserId();
    }

    public static String getUsername() {
        return context.get().getUserName();
    }

    public static UserEntity getUserEntity(){
        return context.get().getUserEntity();
    }

    public static class SessionHolder{
        private Long userId;
        private String userName;
        private String phone;
        private UserEntity userEntity;

        public SessionHolder() {
        }

        public SessionHolder(UserEntity user) {
            this.userEntity = user;
            this.userId = user.getId();
            this.userName = user.getName();
            this.phone = user.getPhone();
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public UserEntity getUserEntity() {
            return userEntity;
        }

        public void setUserEntity(UserEntity userEntity) {
            this.userEntity = userEntity;
        }
    }
}
