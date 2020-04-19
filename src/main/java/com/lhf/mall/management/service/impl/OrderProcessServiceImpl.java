package com.lhf.mall.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import com.lhf.mall.management.domain.OrderProcessEntity;
import com.lhf.mall.management.dao.OrderProcessDao;
import com.lhf.mall.management.service.OrderProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-18
 */
@Service
public class OrderProcessServiceImpl extends ServiceImpl<OrderProcessDao, OrderProcessEntity> implements OrderProcessService {

    @Override
    public List<OrderProcessEntity> listOrderProcessByOrderId(Long orderId) {
        if (Objects.isNull(orderId)){
            return Lists.newArrayListWithCapacity(0);
        }

        LambdaQueryWrapper<OrderProcessEntity> queryWrapper = new LambdaQueryWrapper<OrderProcessEntity>()
                .eq(OrderProcessEntity::getOrderId, orderId)
                .isNull(OrderProcessEntity::getDeletedTime)
                .orderByAsc(OrderProcessEntity::getCreateTime)
                .orderByAsc(OrderProcessEntity::getId);
        return list(queryWrapper);
    }
}
