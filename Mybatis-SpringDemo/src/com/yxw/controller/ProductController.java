package com.yxw.controller;

import com.yxw.modal.MyException;
import com.yxw.modal.Product;
import com.yxw.modal.QueryVo;
import com.yxw.modal.User;
import com.yxw.service.ProductService;
import com.yxw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Yan on 2018/8/4.
 */
@Controller
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    private UserService userService;
    @RequestMapping("/findAll")
    public String findAll(Model model,HttpSession session) {
        // 自定义异常
      /*  if (true) {
            throw new MyException("自定义异常出现了~");
        }*/

        // 运行时异常
 //       int a = 1 / 0;

        List<Product> productList=productService.findAll();
        model.addAttribute("username",session.getAttribute("username"));
        model.addAttribute("itemList",productList);
        return "itemList";
    }
    @RequestMapping("/findProById")
    public String findProById(int pid,Model model){
        Product product=productService.findProById(pid);
        model.addAttribute("item",product);
        return "editItem";
    }


    @RequestMapping("/updateProById")
    public String updateProById(Product product,Model model){
        productService.updateProById(product);
        return "redirect:/findAll.do";
    }
    @RequestMapping("/queryitem")
        public String queryitem(QueryVo queryVo, Model model){
        List<Product> productList=productService.queryitem(queryVo);
        model.addAttribute("itemList",productList);
        return "itemList";
    }


    @RequestMapping("/deleteitem")
    public String deleteitem(QueryVo queryVo, Model model){
        productService.deleteitem(queryVo);
        return "redirect:/findAll.do";
    }

    @RequestMapping("/updatePros")
    public String updatePros(QueryVo queryVo, Model model){
        productService.updatePros(queryVo);
        return "redirect:/findAll.do";
    }
    /**
     * 文件上传
     */
    @RequestMapping("/uploadFile")
    public String uploadFile(QueryVo vo, MultipartFile pictureFile, HttpServletRequest request) throws IOException {
        // 图片上传
        // 设置图片名称，不能重复，可以使用uuid
        String picName = UUID.randomUUID().toString();

        // 获取文件名
        String oriName = pictureFile.getOriginalFilename();
        // 获取图片后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        String path =request.getSession().getServletContext().getRealPath("upload");
        System.out.println(path);

   //     String path = this.getServletContext().getRealPath("upload");

        File headPath = new File(path);//获取文件夹路径
        if(!headPath.exists()){//判断文件夹是否创建，没有创建则创建新文件夹
            headPath.mkdirs();
        }
        // 开始上传
        pictureFile.transferTo(new File(path +"/"+ picName + extName));
        // 设置图片名到商品中
        System.out.println(vo.getProduct().toString());
        vo.getProduct().setPic("upload/"+picName + extName);

        // ---------------------------------------------
        // 更新商品
        productService.updateProById(vo.getProduct());

        return "redirect:/findAll.do";

    }

    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String loginUser(User user, HttpSession session){
        User user1 = userService.findUser(user);
        if(null!=user1){
            session.setAttribute("username", user1.getUsername());
            return "redirect:/findAll.do";
        }
        return "index";
    }
    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login.do",method = RequestMethod.GET)
    public String login() {
        return "index";
    }


     //json数据交互
    @RequestMapping("/json")
    @ResponseBody
    public Product json(@RequestBody Product product){
        System.out.println(product.toString());
        return product;
    }

    //json数据交互
    @RequestMapping("/user/checkName")
    @ResponseBody
    public boolean json(String username){
        System.out.println(username);
        return true;
    }
    @RequestMapping(path = "user/findUser")
    @ResponseBody
    public Product findUser(){
        //Gson gson=new Gson();
        // String u=gson.toJson(userService.findUser());
        //System.out.println(u);
        return  productService.findProById(1);
    }
    @RequestMapping(path = "user/findUsers")
    @ResponseBody
    public List<Product> findUsers(){
        return  productService.findAll();
    }
}
