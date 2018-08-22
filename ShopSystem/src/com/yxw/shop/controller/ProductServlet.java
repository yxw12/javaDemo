package com.yxw.shop.controller;

import com.google.gson.Gson;
import com.yxw.shop.modal.*;
import com.yxw.shop.service.Impl.ProductServiceImpl;
import com.yxw.shop.service.ProductService;
import com.yxw.shop.utils.CommonsUtils;
import com.yxw.shop.utils.JedisPoolUtils;
import com.yxw.shop.utils.PaymentUtil;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Yan on 2018/7/19.
 */
@WebServlet(name="ProductServlet",urlPatterns="/product")
public class ProductServlet extends BaseServlet {
    //模块中的方法同功能进行区分

    /**
     * 分页获得订单信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void myPageOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        //判断用户是否登录
        User user = (User) session.getAttribute("user");
        if(user == null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        ProductService productService = new ProductServiceImpl();

        String currentPageStr = request.getParameter("currentNumber");
        if(currentPageStr == null || currentPageStr=="")currentPageStr="1";
        Integer currentPage = Integer.parseInt(currentPageStr);
        Integer pageSize=2;
        PageBean<Orders> pageBean=null;
        try {
            pageBean = productService.findPageAllOrders(user.getUid(),currentPage,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("pageBean",pageBean);

        //查询该用户的所有的订单信息(单表查询orders表)
        //集合中的每一个Order对象的数据是不完整的 缺少List<OrderItem> orderItems数据
//        List<Orders> orderList = productService.findAllOrders(user.getUid());
        //循环所有的订单 为每个订单填充订单项集合信息
        List<Orders> orderList=pageBean.getList();
        if(orderList!=null){
            for(Orders order : orderList){
                //获得每一个订单的oid
                String oid = order.getOid();
                //查询该订单的所有的订单项---mapList封装的是多个订单项和该订单项中的商品的信息
                List<Map<String, Object>> mapList = productService.findAllOrderItemByOid(oid);
                //将mapList转换成List<OrderItem> orderItems
                for(Map<String,Object> map : mapList){
                    try {
                        //从map中取出count subtotal 封装到OrderItem中
                        OrderItem item = new OrderItem();
                        //item.setCount(Integer.parseInt(map.get("count").toString()));
                        BeanUtils.populate(item, map);
                        //从map中取出pimage pname shop_price 封装到Product中
                        Product product = new Product();
                        BeanUtils.populate(product, map);
                        //将product封装到OrderItem
                        item.setProduct(product);
                        //将orderitem封装到order中的orderItemList中
                        order.getOrderItems().add(item);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //orderList封装完整了
        request.setAttribute("orderList", orderList);

        request.getRequestDispatcher("/order_list.jsp").forward(request, response);
    }

    /**
     * 获得我的订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        //判断用户是否登录
        User user = (User) session.getAttribute("user");
        if(user == null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        ProductService productService = new ProductServiceImpl();

        //查询该用户的所有的订单信息(单表查询orders表)
        //集合中的每一个Order对象的数据是不完整的 缺少List<OrderItem> orderItems数据
        List<Orders> orderList = productService.findAllOrders(user.getUid());
        //循环所有的订单 为每个订单填充订单项集合信息
        if(orderList!=null){
            for(Orders order : orderList){
                //获得每一个订单的oid
                String oid = order.getOid();
                //查询该订单的所有的订单项---mapList封装的是多个订单项和该订单项中的商品的信息
                List<Map<String, Object>> mapList = productService.findAllOrderItemByOid(oid);
                //将mapList转换成List<OrderItem> orderItems
                for(Map<String,Object> map : mapList){
                    try {
                        //从map中取出count subtotal 封装到OrderItem中
                        OrderItem item = new OrderItem();
                        //item.setCount(Integer.parseInt(map.get("count").toString()));
                        BeanUtils.populate(item, map);
                        //从map中取出pimage pname shop_price 封装到Product中
                        Product product = new Product();
                        BeanUtils.populate(product, map);
                        //将product封装到OrderItem
                        item.setProduct(product);
                        //将orderitem封装到order中的orderItemList中
                        order.getOrderItems().add(item);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //orderList封装完整了
        request.setAttribute("orderList", orderList);

        request.getRequestDispatcher("/order_list.jsp").forward(request, response);
    }


    /**
     * 确认订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void confirmOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Map<String, String[]> properties = request.getParameterMap();
        Orders orders=new Orders();
        try {
            BeanUtils.populate(orders,properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ProductService productService=new ProductServiceImpl();
        productService.updateOrders(orders);

        //2.在线支付
       // 获得 支付必须基本数据
        String orderid = request.getParameter("oid");
        String money = orders.getTotal()+"";
        // 银行
        String pd_FrpId = request.getParameter("pd_FrpId");

        // 发给支付公司需要哪些数据
        String p0_Cmd = "Buy";
        String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
        String p2_Order = orderid;
        String p3_Amt = money;
        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        // 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
        // 第三方支付可以访问网址
        String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("callback");
        String p9_SAF = "";
        String pa_MP = "";
        String pr_NeedResponse = "1";
        // 加密hmac 需要密钥
        String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
                "keyValue");
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
                p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
                pd_FrpId, pr_NeedResponse, keyValue);


        String url = "https://www.yeepay.com/app-merchant-proxy/node?pd_FrpId="+pd_FrpId+
                "&p0_Cmd="+p0_Cmd+
                "&p1_MerId="+p1_MerId+
                "&p2_Order="+p2_Order+
                "&p3_Amt="+p3_Amt+
                "&p4_Cur="+p4_Cur+
                "&p5_Pid="+p5_Pid+
                "&p6_Pcat="+p6_Pcat+
                "&p7_Pdesc="+p7_Pdesc+
                "&p8_Url="+p8_Url+
                "&p9_SAF="+p9_SAF+
                "&pa_MP="+pa_MP+
                "&pr_NeedResponse="+pr_NeedResponse+
                "&hmac="+hmac;

        //重定向到第三方支付平台
        response.sendRedirect(url);
    }


    /**
     * 提交购物车订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void submitCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();

        //判断用户是否登录
        User user = (User) session.getAttribute("user");
        if(user == null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        //用户已登录提交订单
        //目的，封装好一个orders对象，传递给service层
        Orders orders = new Orders();

        //1.private String oid;//该订单的订单号
        orders.setOid(CommonsUtils.getUUID());
        // 2. private Date ordertime;//下单时间
        orders.setOrdertime(new Date());
        //    private double total;//该订单的总金额
        Cart cart = (Cart) session.getAttribute("cart");
        double total=cart.getCartTotal();
        orders.setTotal(total);
        //    private Integer state;//订单支付状态 1代表已付款  0代表未付款
        orders.setState(0);
         //    private String address;//收货地址
        orders.setAddress(null);
         //    private String name;//收货人
        orders.setName(null);
         //    private String telephone;//收货人电话
        orders.setTelephone(null);
         //    private User user;//该订单属于哪个用户
         orders.setUser(user);

        //该订单中有多少订单项List<OrderItem> orderItems = new ArrayList<OrderItem>();
        //获得购物车中的购物项的集合map
        Map<String, CartItem> cartItemMap = cart.getCartItemMap();
        for (Map.Entry<String,CartItem> entity:cartItemMap.entrySet()
             ) {
            //取出每一个购物项
            CartItem cartItem = entity.getValue();
            //创建新的购物项
            OrderItem orderItem=new OrderItem();
            //private String itemid;//订单项的id
            orderItem.setItemid(CommonsUtils.getUUID());
            //private Integer count;//订单项内商品的购买数量
            orderItem.setCount(cartItem.getNumber());
            //private double subtotal;//订单项小计
            orderItem.setSubtotal(cartItem.getProductTotalPrice());
            //private Product product;//订单项内部的商品
            orderItem.setProduct(cartItem.getProduct());
            //private Orders orders;//该订单项属于哪个订单
            orderItem.setOrders(orders);

            //将该订单项添加到订单的订单项集合中
            orders.getOrderItems().add(orderItem);
        }
        //对象封装完毕
        //传递数据到service层
        ProductService productService=new ProductServiceImpl();
        productService.submitOrders(orders);

        session.setAttribute("orders", orders);
        response.sendRedirect(request.getContextPath()+"/order_info.jsp");

    }

    /**
     * 清空购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void cleanCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session=request.getSession();
        //跳转回cart.jsp
        session.removeAttribute("cart");
        response.sendRedirect(request.getContextPath()+"/cart.jsp");
    }


    /**
     * 根据购物车商品pid删除购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteCartByPid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        //1.获取要删除购物车的商品的pid
        String pid = request.getParameter("pid");
        //删除session中的购物车中的购物项集合中的item
        HttpSession session=request.getSession();
        Cart cart=(Cart)session.getAttribute("cart");
        if(cart!=null){
            Map<String,CartItem> cartItemMap=cart.getCartItemMap();
            //需要修改总价
            cart.setCartTotal(cart.getCartTotal()-cartItemMap.get(pid).getProductTotalPrice());
            //删除
            cartItemMap.remove(pid);
            cart.setCartItemMap(cartItemMap);
        }
        session.setAttribute("cart",cart);

        //跳转回cart.jsp
        response.sendRedirect(request.getContextPath()+"/cart.jsp");

    }

    /**
     * 加入产品进购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addProductToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //获取session
        HttpSession session=request.getSession();

        ProductService productService=new ProductServiceImpl();
        //获取要放到购物车的商品的pid
        String pid = request.getParameter("pid");
        //获得该商品的购买数量
        String buyNumberStr = request.getParameter("buyNumber");
        Integer buyNumber = Integer.parseInt(buyNumberStr);
        //获得product对象
        Product product=null;
        try {
            product=productService.findProductByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //计算小计
        double productTotalPrice = buyNumber*product.getShop_price();
        //封装CartItem
        CartItem cartItem=new CartItem();
        cartItem.setProduct(product);
        cartItem.setNumber(buyNumber);
        cartItem.setProductTotalPrice(productTotalPrice);

        //获得购物车---判断是否在session中已经存在购物车
        Cart cart=(Cart) session.getAttribute("cart");
        if(cart==null){
            cart=new Cart();
        }
        //将购物车放在车中-----key是pid
        //先判断购物车中是否已将包含此购物项了 ----- 判断key是否已经存在
        //如果购物车中已经存在该商品----将现在买的数量与原有的数量进行相加操作
        Map<String,CartItem> cartItemMap=cart.getCartItemMap();
        double newCartTotal=0.0;
        if(cartItemMap.containsKey(pid)){
            //取出原有商品的数量
            CartItem cartItem1=cartItemMap.get(pid);
            Integer oldBuyNumber = cartItem1.getNumber();
            oldBuyNumber+=buyNumber;
            cartItem1.setNumber(oldBuyNumber);
            cart.setCartItemMap(cartItemMap);
            //修改小计
            //原来该商品的小计
            double oldCartTotal = cartItem1.getProductTotalPrice();
            //新买的商品的小计
            newCartTotal = buyNumber*product.getShop_price();
            cartItem1.setProductTotalPrice(oldCartTotal+newCartTotal);
        }else{
            //如果车中没有该商品
            cart.getCartItemMap().put(product.getPid(),cartItem);
            newCartTotal = buyNumber*product.getShop_price();
        }
        //计算总计
        double total = cart.getCartTotal()+newCartTotal;
        cart.setCartTotal(total);

        //将车再次访问session
        session.setAttribute("cart",cart);

        //直接跳转到购物车页面
        response.sendRedirect(request.getContextPath()+"cart.jsp");

    }

    /**
     * 商品信息、历史浏览
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void profuctInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取查询商品的id
        String pid = request.getParameter("pid");
        //获取商品类别cid
        String cid = request.getParameter("cid");
        //获取当前页
        String currentNumber = request.getParameter("currentNumber");

        ProductService productService=new ProductServiceImpl();
        Product product= null;
        try {
            product = productService.findProductByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("product",product);
        request.setAttribute("cid",cid);
        request.setAttribute("currentNumber",currentNumber);

        //获得客户端携带cookie---获得名字是pids的cookie（用cookie实现历史浏览）
        String pids=pid;
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for (Cookie cookie:cookies) {
                if("pids".equals(cookie.getName())){
                    pids = cookie.getValue();
                    //1-3-2 本次访问商品pid是8----->8-1-3-2
                    //1-3-2 本次访问商品pid是3----->3-1-2
                    //1-3-2 本次访问商品pid是2----->2-1-3
                    //将pids拆成一个数组
                    String[] split = pids.split("-");//{3,1,2}
                    List<String> asList = Arrays.asList(split);//[3,1,2]
                    LinkedList<String> list = new LinkedList<String>(asList);//[3,1,2]
                    //判断集合中是否存在当前pid
                    if(list.contains(pid)){
                        //包含当前查看商品的pid
                        list.remove(pid);
                        list.addFirst(pid);
                    }else{
                        //不包含当前查看商品的pid 直接将该pid放到头上
                        list.addFirst(pid);
                    }
                    //将[3,1,2]转成3-1-2字符串
                    StringBuffer sb = new StringBuffer();
                    for (int i=0; i < list.size()&&i<7;i++){
                        sb.append(list.get(i));
                        sb.append("-");//3-1-2
                    }
                    //去掉3-1-2后面的-
                    pids = sb.substring(0,sb.length()-1);
                }
            }
        }

        //转发之前用cookie存储要转发的pid
        Cookie cookie_pids = new Cookie("pids",pids);
        response.addCookie(cookie_pids);

        request.getRequestDispatcher("/product_info.jsp").forward(request,response);

    }

    /**
     * 显示商品首页、显示商品类别
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        ProductService productService = new ProductServiceImpl();

        List<Product> listHotPro=null;
        List<Product> listNewPro=null;
        //获取热门商品
        try {
            listHotPro = productService.findByHotProduct();
            listNewPro = productService.findByNewProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("listHotPro",listHotPro);
        request.setAttribute("listNewPro",listNewPro);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    /**
     * 查询商品类别
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void category(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();

        //先从缓存中查询categoryList，如果有直接使用，没有在从数据库中查询  存到缓存中
        //1.获得jedis对象查询 连接Redis数据库
        Jedis jedis = JedisPoolUtils.getJedis();
        String CategoryListJson=jedis.get("CategoryListJson");
        //判断缓存中是否有数据
        if(CategoryListJson == null){
            System.out.println("缓存中没有数据，查询数据库");
            List<Category> categoryList=null;
            //获取商品种类
            try {
                categoryList = productService.findByCategory();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Gson categoryGson = new Gson();
            CategoryListJson= categoryGson.toJson(categoryList);
            jedis.set("CategoryListJson",CategoryListJson);
        }

        response.setContentType("text/html;charset=UTF-8"); //解决页面传输数据中文乱码问题
        response.getWriter().print(CategoryListJson);
    }



    /**
     * 根据cid查找商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findProductByCid(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cid = request.getParameter("cid");
        String currentPageStr = request.getParameter("currentNumber");
        if(currentPageStr == null || currentPageStr=="")currentPageStr="1";
        Integer currentPage = Integer.parseInt(currentPageStr);
        Integer pageSize=12;
        ProductService productService = new ProductServiceImpl();
        PageBean<Product> pageBean=null;
        try {
            pageBean = productService.findProductByCid(cid,currentPage,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("cid",cid);

        //定义一个记录历史记录商品信息的集合
        List<Product> historyCookieList = new ArrayList<Product>();

        //获得客户端携带名字叫pids的cookie
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if("pids".equals(cookie.getName())){
                    String pids=cookie.getValue();//3-2-1
                    String[] split = pids.split("-");
                    for (String pid :
                            split) {
                        Product pro = null;
                        try {
                            pro = productService.findProductByPid(pid);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        historyCookieList.add(pro);
                    }
                }
            }
        }
        //将历史集合放到域中
        request.setAttribute("historyCookieList",historyCookieList);

        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }
}
