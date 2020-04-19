package com.lhf.mall.management.dto;

import com.lhf.mall.management.domain.OrderEntity;
import com.lhf.mall.management.domain.OrderProcessEntity;
import lombok.Data;

import java.util.List;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/4/18
 **/
@Data
public class OrderDetailDto {
    private OrderEntity order;
    private List<OrderProcessEntity> orderProcess;
}
