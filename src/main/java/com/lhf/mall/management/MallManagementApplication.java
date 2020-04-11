package com.lhf.mall.management;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan(basePackages = {"com.lhf.mall.management.dao"})
public class MallManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallManagementApplication.class, args);
        log.info("====================localhost:8888============================");
    }

}
