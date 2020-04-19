package com.lhf.mall.management.controller;


import com.alibaba.fastjson.JSON;
import com.lhf.mall.management.domain.GoodsEntity;
import com.lhf.mall.management.domain.std.Pagination;
import com.lhf.mall.management.domain.std.StdResponse;
import com.lhf.mall.management.dto.GoodsDto;
import com.lhf.mall.management.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-15
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/page")
    public StdResponse pageData(@RequestParam(value = "pageNo",required = false,defaultValue = "1") Integer pageNo,
                                @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize){
        Pagination<GoodsEntity> pagination = goodsService.pageData(pageNo,pageSize);
        return StdResponse.newCorrectPageStdResponse(pagination);
    }

    @GetMapping("/get/{id}")
    public StdResponse get(@PathVariable("id") Long id){
        GoodsEntity goodsEntity = goodsService.getGoodsById(id);
        return StdResponse.newCorrectStdResponse(goodsEntity);
    }

    @GetMapping("/detail/{id}")
    public StdResponse detail(@PathVariable("id") Long id){
        GoodsDto goodsDto = goodsService.detail(id);
        return StdResponse.newCorrectStdResponse(goodsDto);
    }

    @PostMapping("/add")
    public StdResponse add(@RequestBody GoodsDto goodsDto){
        goodsService.add(goodsDto);
        return StdResponse.newCorrectStdResponse();
    }

    @PutMapping("/update/{id}")
    public StdResponse update(@PathVariable("id") Long id,
                              @RequestBody GoodsDto goodsDto){
        goodsService.updateGoods(id,goodsDto);
        return StdResponse.newCorrectStdResponse();
    }

    @DeleteMapping("/delete/{id}")
    public StdResponse delete(@PathVariable("id") Long id){
        goodsService.deleteById(id);
        return StdResponse.newCorrectStdResponse();
    }
}
