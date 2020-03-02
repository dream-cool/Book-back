package com.clt.controller;

import com.clt.utils.ResultUtil;
import com.clt.utils.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author ：clt
 * @Date ：Created in 20:24 2020/02/25
 */
@Controller
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    @Value("${spring.servlet.multipart.location}")
    private String path;

    /**
     * @param fileName 文件名
     * @return 返回文件后缀名
     * 根据文件名获取文件后缀名
     */
    private String getFileSuffixName(String fileName) {
        return fileName.split("\\.")[1];
    }

    /**
     * 实现文件上传
     */
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil fileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultUtil.failed("文件为空");
        }
        String fileName = UUIDUtil.getUUID() + "." + getFileSuffixName(file.getOriginalFilename());
        int size = (int) file.getSize();
        logger.info("文件名:" + fileName + "-->" + size);
        File dest = new File(path + "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            return ResultUtil.success(fileName);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResultUtil.failed("文件为空");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResultUtil.failed("文件为空");
        }
    }

    /**
     * 实现多文件上传
     **/
    @RequestMapping(value = "/multifile", method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil multifileUpload(
            @RequestParam("fileName") List<MultipartFile> files) {
        if (files.isEmpty()) {
            return ResultUtil.failed("文件为空");
        }
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            int size = (int) file.getSize();
            logger.info(fileName + "-->" + size);

            if (file.isEmpty()) {
                return ResultUtil.failed("文件为空");
            } else {
                File dest = new File(path + "/" + fileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return ResultUtil.failed();
                }
            }
        }
        return ResultUtil.success(null);
    }

    @RequestMapping("/download")
    public ResultUtil downLoad(HttpServletResponse response,
                               @RequestParam(value = "filename") String filename,
                               @RequestParam(value = "filePath", required = false) String filePath) throws UnsupportedEncodingException {
        filePath = filePath == null ? "" : filePath;
        File file = new File(path + "/" + filePath + "/" + filename);
        if (file.exists()) {
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode(filename, "UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            OutputStream os = null;
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            logger.info("----------file download---" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}