package com.kuanghui.controller;


import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class UploadController{
    //@RequestParam("file1")将name=file1控件得到的文件封装成CommonMultipartFile
    //批量上传CommonMultipartFile则为数组
    @RequestMapping("/upload")
    public String upload(@RequestParam("file1") CommonsMultipartFile file, HttpServletRequest req) throws IOException {
        //获取文件名
        String uploadFileName=file.getOriginalFilename();

        //如果文件名为空，返回首页
        if(uploadFileName.equals("")){
            return "redirect:/index.jsp";
        }
        System.out.println("文件名==>"+uploadFileName);

        //上传路径保存设置
        String Path = req.getServletContext().getRealPath("/upload");
        File realPath = new File(Path);
        if(!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址==>"+Path);

        InputStream inputStream = file.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(realPath, uploadFileName));

        //进行读写
        int len=0;
        byte[] buffer=new byte[1024];
        while((len=inputStream.read(buffer))!=-1){
            fileOutputStream.write(buffer,0,len);
            fileOutputStream.flush();
        }
        fileOutputStream.close();
        inputStream.close();
        return "redirect:/index.jsp";
    }


    @RequestMapping("/upload1")
    public String upload1(@RequestParam("file1")CommonsMultipartFile file, HttpServletRequest req) throws IOException {
        //获取文件名
        String uploadFileName=file.getOriginalFilename();

        //如果文件名为空，返回首页
        if(uploadFileName.equals("")){
            return "redirect:/index.jsp";
        }
        System.out.println("文件名==>"+uploadFileName);

        //上传路径保存设置
        String Path = req.getServletContext().getRealPath("/upload");
        File realPath = new File(Path);
        if(!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址==>"+Path);

        file.transferTo(new File(realPath+"/"+uploadFileName));
        return "redirect:/index.jsp";
    }

    @RequestMapping( "/download")
    public String downloads(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //要下载的图片地址
        String realPath = "D:\\Java\\Idea-project\\SSM\\web\\WEB-INF\\statics";
        String fileName="img.png";
        System.out.println(realPath+"\\"+fileName);

        //1.设置 response响应头
        response.reset();
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName,"utf-8"));

        File file = new File(realPath, fileName);
        //2.执行读写操作
        FileInputStream fileInputStream = new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();
        int index=0;
        byte[] buff=new byte[1024];
        while((index=fileInputStream.read(buff))!=-1){
            outputStream.write(buff,0,index);
            outputStream.flush();
        }
        outputStream.close();
        fileInputStream.close();
        return null;
    }

}
