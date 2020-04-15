package com.lhf.mall.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhf.mall.management.domain.CustomerEntity;
import com.lhf.mall.management.domain.OrderEntity;
import com.lhf.mall.management.dao.OrderDao;
import com.lhf.mall.management.domain.std.Pagination;
import com.lhf.mall.management.domain.std.StdErrorCodeEnum;
import com.lhf.mall.management.domain.std.StdException;
import com.lhf.mall.management.service.CustomerService;
import com.lhf.mall.management.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhf.mall.management.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-15
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Autowired
    private CustomerService customerService;

    @Override
    public Pagination<OrderEntity> pageOrder(Integer pageNo, Integer pageSize) {
        LambdaQueryWrapper<OrderEntity> queryWrapper = new LambdaQueryWrapper<OrderEntity>()
                .isNull(OrderEntity::getDeletedTime);

        IPage<OrderEntity> page = page(new Page<>(pageNo, pageSize), queryWrapper);
        return new Pagination<>(page.getTotal(),page.getRecords());
    }

    @Override
    public OrderEntity getOrderById(Long id) {
        LambdaQueryWrapper<OrderEntity> queryWrapper = new LambdaQueryWrapper<OrderEntity>()
                .eq(OrderEntity::getId, id)
                .isNull(OrderEntity::getDeletedTime);
        return getOne(queryWrapper,false);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long addOrder(OrderEntity orderEntity) {
        CustomerEntity customerEntity = customerService.getCustomerByPhone(orderEntity.getCustomerPhone());
        if (Objects.isNull(customerEntity)){
            customerEntity = new CustomerEntity();
            customerEntity.setName(orderEntity.getCustomerName())
                    .setPhone(orderEntity.getCustomerPhone())
                    .setCreateTime(LocalDateTime.now());

            customerService.save(customerEntity);
        }

        orderEntity.setCustomerId(customerEntity.getId())
                .setCreateTime(LocalDateTime.now());
        save(orderEntity);
        return orderEntity.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrderById(Long id, OrderEntity orderEntity) {
        OrderEntity dbOrder = getOrderByIdForUpdate(id);
        if (Objects.isNull(dbOrder)){
            throw new StdException(StdErrorCodeEnum.MALL_ORDER_00001);
        }

        orderEntity.setId(id);
        updateById(orderEntity);
    }

    private OrderEntity getOrderByIdForUpdate(Long id) {
        LambdaQueryWrapper<OrderEntity> queryWrapper = new LambdaQueryWrapper<OrderEntity>()
                .eq(OrderEntity::getId, id)
                .isNull(OrderEntity::getDeletedTime)
                .last(" FOR UPDATE ");
        return getOne(queryWrapper,false);
    }
}
