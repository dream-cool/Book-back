package com.clt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author ：clt
 * @Date ：Created in 20:24 2020/02/25
 */
@Controller
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    public String upload(@RequestParam(required = false) String dir, @RequestParam(required = false) MultipartFile file) {
        try {
            System.out.println("upload start = " + System.currentTimeMillis());
            String videoUrl = uploadFile(file, dir);
            System.out.println("upload end = " + System.currentTimeMillis());
            return "上传成功";
        } catch (Exception var3) {
            return "fail";
        }
    }

    public String uploadFile(MultipartFile file, String resSort) throws Exception {
        String shortPath =  file.getOriginalFilename();
        File dest = new File("D://file", shortPath);
        if (!dest.getParentFile().exists()) {
            boolean rel = dest.getParentFile().mkdirs();
            if (!rel) {
                throw new Exception("文件夹创建失败");
            }
        }
        InputStream is = file.getInputStream();
        OutputStream os = new FileOutputStream(dest);
        try {
            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        }
        return shortPath;
    }

    @RequestMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "aim_test.txt";// 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //设置文件路径
            String realPath = "D://aim//";
            File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
