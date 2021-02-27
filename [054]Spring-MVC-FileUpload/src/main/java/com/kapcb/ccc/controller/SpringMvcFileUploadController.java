package com.kapcb.ccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <a>Title: SpringMvcFileUploadController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25 22:23
 */
@Controller
@RequestMapping("springmvc")
public class SpringMvcFileUploadController {

    private static final Logger log = LoggerFactory.getLogger(SpringMvcFileUploadController.class);

    @RequestMapping(value = "UpLoad", method = RequestMethod.POST)
    public String springMvcUpLoad(HttpServletRequest request, MultipartFile upload) throws IOException {

        System.out.println("SpringMVC的传统上传方式");
        //获取文件上传的目录
        String realPath = request.getSession().getServletContext().getRealPath("/uploads");
        //创建 file 对象
        File file = new File(realPath);

        //判断路径是否存在,如果不存在则创建文件
        if (!file.exists()) {
            file.mkdirs();
        }

        //获取上传文件的名字
        String fileName = upload.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().toLowerCase();

        File uploadFile = new File(file, uuid + fileSuffix);

        //上传文件
        upload.transferTo(uploadFile);
        return "success";
    }

}
