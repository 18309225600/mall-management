package com.lhf.mall.management.controller;


import com.lhf.mall.management.domain.TemplateEntity;
import com.lhf.mall.management.domain.std.StdResponse;
import com.lhf.mall.management.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 刘宏飞
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @GetMapping("/list")
    public StdResponse list(){
        List<TemplateEntity> templates = templateService.listTemplates();
        return StdResponse.newCorrectStdResponse(templates);
    }
}
