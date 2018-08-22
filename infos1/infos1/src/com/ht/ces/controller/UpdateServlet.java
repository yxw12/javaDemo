package com.ht.ces.controller;

import com.ht.ces.DButils;
import com.ht.ces.model.User;
import com.ht.ces.service.CSUsrService;
import com.ht.ces.service.Impl.CSUsrServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> suffixs=new ArrayList<String >();
        suffixs.add(".jpg");
        suffixs.add(".png");
        suffixs.add(".gif");
        String username =null;
        String password=null;
        String gender=null;
        String address=null;
        String birthday=null;
        String pic=null;
        String userId=null;
        //创建工厂模式
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
        //创建解析对象
        ServletFileUpload sfu=new ServletFileUpload(diskFileItemFactory);
        sfu.setSizeMax(1024*1024);
        try {
            List <FileItem> fiList=sfu.parseRequest(request);
            for (FileItem fi: fiList){
                //获得表单文本域的名字
                String fieldName=fi.getFieldName();
                //是否是文件类型
                Boolean isComm = fi.isFormField();
                //获得原始文件名字
                String origFileName = fi.getName();

                if(isComm && fieldName!=null && !"".equals(fieldName)) {
                    String content = fi.getString();
                    content=new String(content.getBytes("ISO-8859-1"),"UTF-8");
                    if("username".equals(fieldName)){
                        username=content;
                    }else if("password".equals(fieldName)){
                        password=content;
                    }else if("gender".equals(fieldName)){
                        gender=content;
                    }else if("address".equals(fieldName)){
                        address=content;
                    }else if("birthday".equals(fieldName)){
                        birthday=content;
                    }else if("userId".equals(fieldName)){
                        userId=content;
                    }
                }

                if(!isComm && fieldName!=null && !"".equals(fieldName)){
                    //获得需要上传的路径
                    String realPath = request.getSession().getServletContext().getRealPath("/upload/");
                    if (origFileName!=null && !"".equals(origFileName)){
                        //获得文件后缀名
                        String  suffix= origFileName.substring(origFileName.lastIndexOf("."));
                        if (suffixs.contains(suffix)){
                            String tFileName=UUID.randomUUID().toString();
                            String realtivePath="/upload/"+tFileName+suffix;
                            pic=realtivePath;
                            System.out.println(pic);
                            File file=new File(realPath,tFileName+suffix);
                            fi.write(file);
                        }else{
                            response.getWriter().print("图片格式错误，请上传.jpg.png.gif");
                            return;
                        }
                    }

                }
            }
            //把参数转换成相应的数据类型
            java.util.Date data=null;
            Integer gende1r=null;
            Integer userIdStr=null;
            if(gender!=null){
                gende1r=new Integer(gender);
            }
            if(birthday!=null){
                try {
                    data=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            if(userId!=null){
                 userIdStr=new Integer(userId);
            }
            User u=new User();
            u.setName(username);
            u.setPassword(password);
            u.setGender(gende1r);
            u.setBirthday(data);
            u.setAddress(address);
            u.setPic(pic);
            u.setUserId(userIdStr);

            CSUsrService csUsrService=new CSUsrServiceImpl();
            csUsrService.updateUser(u);
            String path=request.getContextPath();
            response.sendRedirect(path+"/QuseryServlet");

        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof FileUploadBase.FileSizeLimitExceededException){
                response.getWriter().print("文件过大 最大为1M");
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);

}
}