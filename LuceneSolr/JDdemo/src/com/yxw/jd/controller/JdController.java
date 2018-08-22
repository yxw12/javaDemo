package com.yxw.jd.controller;

import com.yxw.jd.pojo.Page;
import com.yxw.jd.pojo.ProductModel;
import com.yxw.jd.pojo.QueryVo;
import com.yxw.jd.service.JdService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yan on 2018/8/9.
 */
@Controller
public class JdController {
    @Resource
    private JdService jdService;
    @RequestMapping("/list.action")
    public String queryProduct(String queryString, String catalog_name, String price, String sort, Model model) throws SolrServerException {
        List<ProductModel> productModelList=jdService.queryProductAll(0,queryString,catalog_name,price,sort);
        model.addAttribute("productList",productModelList);
        model.addAttribute("queryString",queryString);
        model.addAttribute("catalog_name",catalog_name);
        model.addAttribute("price",price);
        model.addAttribute("sort",sort);
        return "product_list";
    }

    @RequestMapping("/list3.action")
    public String queryProduct1(String page,String queryString, String catalog_name, String price, String sort, Model model) throws SolrServerException {
  //      List<ProductModel> productModelList=jdService.queryProductAll(page,queryString,catalog_name,price,sort);
        QueryVo queryVo=new QueryVo();
        Page page2=new Page();
        if(null==page||page==""){
            page2.setCurPage(1);
        }else {
            page2.setCurPage(Integer.parseInt(page));
        }
  //      System.out.println(page2.getCurPage());
        queryVo.setPage(page2);
        queryVo.setCatalog_name(catalog_name);
        queryVo.setPrice(price);
        queryVo.setQueryString(queryString);
        queryVo.setSort(sort);
    //    System.out.println(queryVo.toString());
        Page<ProductModel> page1 = jdService.queryQueryVoAll(queryVo);
        model.addAttribute("productList",page1.getProductList());
        model.addAttribute("queryString",queryString);
        model.addAttribute("catalog_name",catalog_name);
        model.addAttribute("price",price);
        model.addAttribute("sort",sort);
        model.addAttribute("page",page1);
        return "product_list";
    }
    @RequestMapping("/show.action")
    public String show(){
        return "product_list";
    }

}
