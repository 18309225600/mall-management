package com.lhf.mall.management.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 刘宏飞
 * @version v1.0
 * @date 2020/3/20
 **/
@Data
@Component
public class FdfsConfig {

    @Value("${fdfs.resHost}")
    private String resHost;

    @Value("${fdfs.storagePort}")
    private String storagePort;
}
