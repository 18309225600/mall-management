package com.lhf.mall.management.controller;


import com.google.common.collect.Maps;
import com.lhf.mall.management.domain.OrderEntity;
import com.lhf.mall.management.domain.std.Pagination;
import com.lhf.mall.management.domain.std.StdResponse;
import com.lhf.mall.management.dto.OrderDetailDto;
import com.lhf.mall.management.dto.OrderDto;
import com.lhf.mall.management.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-15
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/page")
    public StdResponse pageOrder(@RequestParam(value = "pageNo",required = false,defaultValue = "1") Integer pageNo,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize){
        Pagination<OrderEntity> pagination = orderService.pageOrder(pageNo,pageSize);
        return StdResponse.newCorrectPageStdResponse(pagination);
    }

    @GetMapping("/get/{id}")
    public StdResponse getById(@PathVariable("id") Long id){
        OrderEntity orderEntity = orderService.getOrderById(id);
        return StdResponse.newCorrectStdResponse(orderEntity);
    }

    @GetMapping("/detail/{id}")
    public StdResponse orderDetail(@PathVariable("id") Long id){
        OrderDetailDto orderDetailDto = orderService.getOrderDetail(id);
        return StdResponse.newCorrectStdResponse(orderDetailDto);
    }

    @PostMapping("/add")
    public StdResponse addOrder(@RequestBody OrderDto orderDto){
        Long orderId = orderService.addOrder(orderDto);
        HashMap<String, Long> result = Maps.newHashMapWithExpectedSize(1);
        result.put("id",orderId);
        return StdResponse.newCorrectStdResponse(result);
    }

    @PutMapping("/update/{id}")
    public StdResponse updateOrderById(@PathVariable("id") Long id,
                                       @RequestBody OrderEntity orderEntity){
        orderService.updateOrderById(id,orderEntity);
        return StdResponse.newCorrectStdResponse();
    }

    @PutMapping("/add/remark/{id}")
    public StdResponse addRemark(@PathVariable("id") Long id,
                                 @RequestBody OrderDto orderDto){
        orderService.addRemark(id,orderDto);
        return StdResponse.newCorrectStdResponse();
    }

    @PutMapping("/update/status/{id}")
    public StdResponse updateStatus(@PathVariable("id") Long id,
                                    @RequestBody OrderDto orderDto){
        orderService.updateStatus(id,orderDto);
        return StdResponse.newCorrectStdResponse();
    }

    @PutMapping("/update/delivery/{id}")
    public StdResponse updateDelivery(@PathVariable("id") Long id,
                                      @RequestBody OrderDto orderDto){
        orderService.updateDelivery(id,orderDto);
        return StdResponse.newCorrectStdResponse();
    }
}
