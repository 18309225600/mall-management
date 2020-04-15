package com.lhf.mall.management.config;

import com.google.common.collect.Maps;
import com.lhf.mall.management.domain.std.StdResponse;
import com.lhf.mall.management.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author lhf
 * @since v1.0
 */
@RestController
@RequestMapping("/oss")
public class OSSController {

    @Autowired
    private FdfsConfig fdfsConfig;
    @Autowired
    private FileUtils fileUtils;

    @PostMapping("/upload")
    public StdResponse upload(@RequestParam("file") MultipartFile file) throws IOException {
        String path = fileUtils.uploadFile(file);
        String url = fdfsConfig.getResHost()+path;
        HashMap<String, String> result = Maps.newHashMapWithExpectedSize(1);
        result.put("url",url);
        return StdResponse.newCorrectStdResponse(result);
    }
}
