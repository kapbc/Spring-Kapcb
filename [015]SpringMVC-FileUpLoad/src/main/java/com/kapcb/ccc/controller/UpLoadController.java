package com.kapcb.ccc.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * <a>Title:UpLoadController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 16:23
 */
@Controller
@RequestMapping("test")
public class UpLoadController {

    /**
     * 传统文件上传
     *
     * @param request HttpServletRequest
     * @return success
     */
    @RequestMapping(path = "fileUpLoad", method = RequestMethod.POST)
    public String fileUpLoadTest(HttpServletRequest request) throws Exception {
        //获取文件上传目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");

        //创建File对象，一会向该路径下上传文件
        File file = new File(path);

        //判断路径是否存在，不存在则进行文件创建
        if (!file.exists()) {
            file.mkdirs();
        }
        //创建磁盘文件工程
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        //解析 request 对象
        List<FileItem> fileItems = servletFileUpload.parseRequest(request);

        for (FileItem fileItem : fileItems) {
            //判断文件项是普通字段还是上传文件
            if (fileItem.isFormField()) {

            } else {
                //上传文件
                //获取上传文件的名称
                String name = fileItem.getName();

                File uploadFile = new File(file, name);
                //上传文件
                fileItem.write(uploadFile);
                //删除临时文件
                fileItem.delete();
            }
        }
        return "success";
    }
}
