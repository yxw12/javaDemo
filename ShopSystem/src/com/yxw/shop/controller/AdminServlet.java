package com.yxw.shop.controller;

import com.google.gson.Gson;
import com.yxw.shop.modal.Category;
import com.yxw.shop.modal.Orders;
import com.yxw.shop.modal.Product;
import com.yxw.shop.service.AdminService;
import com.yxw.shop.service.Impl.AdminServiceImpl;
import com.yxw.shop.utils.CommonsUtils;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/7/22.
 */
@WebServlet(name="AdminServlet",urlPatterns="/admin")
public class AdminServlet extends BaseServlet{
    /**
     * 后台查询商品类别
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void adminCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //提供一个List<Category> 转成json字符串
        AdminService service = new AdminServiceImpl();
        List<Category> categoryList = service.findByCategory();

        Gson gson = new Gson();
        String json = gson.toJson(categoryList);

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().write(json);
    }

    /**
     * 查询所有商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAllProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdminService service = new AdminServiceImpl();
        List<Product> productList = service.findAllProduct();
        request.setAttribute("productList",productList);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(request.getContextPath()+"/admin/product/list.jsp").forward(request,response);
 //       response.sendRedirect(request.getContextPath()+"/admin/product/list.jsp");

    }

    /**
     * 根据pid删除商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByPid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String pid=request.getParameter("pid");
        AdminService service = new AdminServiceImpl();
        service.deleteByPid(pid);

        List<Product> productList = service.findAllProduct();
        request.setAttribute("productList",productList);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(request.getContextPath()+"/admin/product/list.jsp").forward(request,response);
    }

    /**
     * 根据pid更新商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        String pid = request.getParameter("pid");
        AdminService service = new AdminServiceImpl();
        Product product = service.selectByPid(pid);

        session.setAttribute("product", product);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(request.getContextPath() + "/admin/product/edit.jsp").forward(request, response);
    }

    /**
     * 查询商品分类
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAllCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        AdminService service = new AdminServiceImpl();
        List<Category> categoryList = service.findByCategory();
        request.setAttribute("categoryList",categoryList);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(request.getContextPath()+"/admin/category/list.jsp").forward(request,response);

    }

    /**
     * 添加商品类别
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String cname=request.getParameter("cname");
        Category category=new Category();
        category.setCname(cname);
        category.setCid(CommonsUtils.getUUID());
        AdminService service = new AdminServiceImpl();
        service.addCategory(category);

        //添加完成后显示
        List<Category> categoryList = service.findByCategory();
        request.setAttribute("categoryList",categoryList);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(request.getContextPath()+"/admin/category/list.jsp").forward(request,response);
    }

    /**
     * 根据商品类别cid删除商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByCid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String cid=request.getParameter("cid");
        AdminService service = new AdminServiceImpl();
        service.deleteByCid(cid);

        //删除完成后显示
        List<Category> categoryList = service.findByCategory();
        request.setAttribute("categoryList",categoryList);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(request.getContextPath()+"/admin/category/list.jsp").forward(request,response);
    }

    /**
     * 根据Cid查询类别
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByCid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        String cid = request.getParameter("cid");
        AdminService service = new AdminServiceImpl();
        Category category = service.selectByCid(cid);

        request.setAttribute("category", category);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(request.getContextPath() + "/admin/category/edit.jsp").forward(request, response);
    }

    /**
     * 编辑类别
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void editCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String cid=request.getParameter("cid");
        String cname=request.getParameter("cname");
        Category category=new Category();
        category.setCid(cid);
        category.setCname(cname);
        AdminService adminService=new AdminServiceImpl();

        adminService.editCategory(category);

        //添加完成后显示
        List<Category> categoryList = adminService.findByCategory();
        request.setAttribute("categoryList",categoryList);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(request.getContextPath()+"/admin/category/list.jsp").forward(request,response);
    }

    /**
     * 查找所有订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAllOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        AdminService adminService=new AdminServiceImpl();
        List<Orders> ordersList=adminService.findAllOrders();
        request.setAttribute("ordersList",ordersList);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher(request.getContextPath()+"/admin/order/list.jsp").forward(request,response);
    }

    /**
     * 根据oid查询商品中的订单详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOrderInfoByOid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String oid=request.getParameter("oid");
        AdminService adminService=new AdminServiceImpl();
        List<Map<String, Object>> mapOrderList = adminService.findOrderInfoByOid(oid);

        Gson gson=new Gson();
        String json = gson.toJson(mapOrderList);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(json);
    }


}
