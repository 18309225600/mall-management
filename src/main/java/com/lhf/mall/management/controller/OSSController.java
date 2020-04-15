package com.lhf.mall.management.controller;

import com.google.common.collect.Maps;
import com.lhf.mall.management.config.FdfsConfig;
import com.lhf.mall.management.domain.std.StdResponse;
import com.lhf.mall.management.util.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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

    @GetMapping("/down")
    public void downExcel(HttpServletResponse response) throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/excel/houseFormWork.xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode("houseFormWork.xlsx", "UTF-8") + ".xls");
        IOUtils.copy(resourceAsStream,outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
