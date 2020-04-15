package com.lhf.mall.management.service;

import com.lhf.mall.management.domain.OrderEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhf.mall.management.domain.std.Pagination;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-15
 */
public interface OrderService extends IService<OrderEntity> {

    Pagination<OrderEntity> pageOrder(Integer pageNo, Integer pageSize);

    OrderEntity getOrderById(Long id);

    Long addOrder(OrderEntity orderEntity);

    void updateOrderById(Long id, OrderEntity orderEntity);
}
