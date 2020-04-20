package com.lhf.mall.management.controller;


import com.lhf.mall.management.domain.GoodsSpecificationEntity;
import com.lhf.mall.management.domain.std.StdResponse;
import com.lhf.mall.management.service.GoodsSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-20
 */
@RestController
@RequestMapping("/goods-specification")
public class GoodsSpecificationController {

    @Autowired
    private GoodsSpecificationService goodsSpecificationService;

    @GetMapping("/list/{goodsId}")
    public StdResponse listSpecification(@PathVariable("goodsId") Long goodsId){
        List<GoodsSpecificationEntity> list = goodsSpecificationService.listSpecificationByGoodsId(goodsId);
        return StdResponse.newCorrectStdResponse(list);
    }

    @PostMapping("/config/{goodsId}")
    public StdResponse configSpecification(@PathVariable("goodsId") Long goodsId,
                                           @RequestBody List<GoodsSpecificationEntity> goodsSpecificationEntitys){
        goodsSpecificationService.configSpecification(goodsId,goodsSpecificationEntitys);
        return StdResponse.newCorrectStdResponse();
    }
}
