package com.koala.servlet.manage;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
/**
  *图片上传.
  *@author Marting.Lee
  *date 2020/1/7
  **/
@WebServlet("/api/manage/uploadpic")
public class uploadpic extends HttpServlet {
    public uploadpic() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("uploadpic");
        PrintWriter out = response.getWriter();
        JSONObject msg = new JSONObject();
        DiskFileItemFactory factory = new DiskFileItemFactory();

        String path = "/usr/local/jetty/webapps/imgs";
        System.out.println("path "+path);
        File file = new File(path);
        if (!file.exists())
            file.mkdirs();
        factory.setRepository(new File(path));
        factory.setSizeThreshold(1024*1024);

        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
            for (FileItem item : list) {
                String name = item.getFieldName();
                if (item.isFormField()) {
                    String value = item.getString();
                    request.setAttribute(name, value);
                } else {
                    String value = item.getName();

                    int start = value.lastIndexOf("\\");

                    String filename = value.substring(start + 1);
                    request.setAttribute(name, filename);
                    item.write(new File(path, filename));

                    System.out.println("上传成功");
                    msg.put("url",filename);
                    msg.put("tag",1);
                }
            }
        }catch (Exception e){
            System.out.println("上传失败");
            e.printStackTrace();
            try {
                msg.put("url",e.getMessage());
                msg.put("tag",0);
            } catch (JSONException ex) {
                ex.printStackTrace();
            }

        }

        out.print(msg);
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}