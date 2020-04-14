package com.lhf.mall.management.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhf.mall.management.constant.RedisKeyConstant;
import com.lhf.mall.management.constant.StrConstant;
import com.lhf.mall.management.domain.UserEntity;
import com.lhf.mall.management.dao.UserDao;
import com.lhf.mall.management.domain.enums.UserStatus;
import com.lhf.mall.management.domain.std.Pagination;
import com.lhf.mall.management.domain.std.StdErrorCodeEnum;
import com.lhf.mall.management.domain.std.StdException;
import com.lhf.mall.management.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhf.mall.management.util.RandomUtils;
import com.lhf.mall.management.util.SecurityUtils;
import com.lhf.mall.management.util.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-10
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public String login(UserEntity userEntity) {
        UserEntity dbUser = getUserByPhoneForUpdate(userEntity.getPhone());
        if (Objects.nonNull(dbUser)&& dbUser.getPassword().equals(SecurityUtils.md5(userEntity.getPassword()))){
            if(UserStatus.DISABLE.getCode() == dbUser.getStatus()){
                throw new StdException(StdErrorCodeEnum.MALL_USER_00003);
            }

            dbUser.setPassword(null);
            String token = RandomUtils.randomStr(32);
            log.info("密码正确..登陆成功,token={}",token);
            String tokenRedisKey = MessageFormat.format(RedisKeyConstant.USER_TOKEN, token);
            redisTemplate.opsForValue().set(tokenRedisKey, JSON.toJSONString(dbUser));
            return token;
        }else{
            throw new StdException(StdErrorCodeEnum.MALL_USER_00002);
        }
    }

    @Override
    public List<UserEntity> listData() {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<UserEntity>()
                .isNull(UserEntity::getDeletedTime);
        return list(queryWrapper);
    }

    @Override
    public UserEntity userInfo() {
        UserEntity userEntity = SessionUtils.getUserEntity();
        return userEntity;
    }

    @Override
    public Pagination<UserEntity> pageUsers(String name, String phone, Integer pageNo, Integer pageSize) {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<UserEntity>()
                .isNull(UserEntity::getDeletedTime);

        if (!StringUtils.isEmpty(name)){
            queryWrapper.like(UserEntity::getName,name);
        }

        if (!StringUtils.isEmpty(phone)){
            queryWrapper.like(UserEntity::getPhone,phone);
        }

        IPage<UserEntity> page = page(new Page<>(pageNo, pageSize), queryWrapper);
        return new Pagination<>(page.getTotal(),page.getRecords());
    }

    @Override
    public void add(UserEntity userEntity) {
        UserEntity dbUser = getUserByPhoneForUpdate(userEntity.getPhone());
        if (Objects.nonNull(dbUser)){
            throw new StdException(StdErrorCodeEnum.MALL_USER_00004);
        }

        userEntity.setPassword(StrConstant.INIT_PASSWORD)
                .setCreateTime(LocalDateTime.now());
        save(userEntity);
    }

    @Override
    public void delete(Long id) {
        UserEntity dbUser = getUserByIdForUpdate(id);
        if (Objects.isNull(dbUser)){
            throw new StdException(StdErrorCodeEnum.MALL_USER_00005);
        }

        dbUser.setDeletedTime(LocalDateTime.now());
        updateById(dbUser);
    }

    private UserEntity getUserByIdForUpdate(Long id) {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<UserEntity>()
                .eq(UserEntity::getId, id)
                .isNull(UserEntity::getDeletedTime)
                .last(" FOR UPDATE ");
        return getOne(queryWrapper,false);
    }

    private UserEntity getUserByPhoneForUpdate(String phone) {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<UserEntity>()
                .eq(UserEntity::getPhone, phone)
                .isNull(UserEntity::getDeletedTime)
                .last(" FOR UPDATE ");
        return getOne(queryWrapper,false);
    }
}
