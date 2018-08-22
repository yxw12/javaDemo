package com.yxw.jd.dao.impl;

import com.yxw.jd.dao.JdDao;
import com.yxw.jd.pojo.ProductModel;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/8/9.
 */
@Repository
public class JdDaoImpl implements JdDao{
    @Resource
    private SolrServer solrServer;

    @Override
    public List<ProductModel> queryProductAll(int start,String queryString, String catalog_name, String price, String sort)
            throws SolrServerException {
        //创建一个query 对象
        SolrQuery query=new SolrQuery();
        //设置查询条件
        query.setQuery(queryString);
        //过滤条件
        if(null!=catalog_name&&!"".equals(catalog_name)){
            query.setFilterQueries("product_catalog_name:"+catalog_name);
        }

        if(null!=price&&!"".equals(price)){
            String[] price1 = price.split("-");
            query.set("fq","product_price:["+price1[0]+" TO "+price1[1]+"]");
        }

        //排序条件
        if("1".equals(sort)){
            query.addSort("product_price", SolrQuery.ORDER.desc);
        }else {
            query.addSort("product_price", SolrQuery.ORDER.asc);
        }
        //分页处理
        query.setStart(start);
        query.setRows(8);
        //默认域
        query.set("df","product_keywords");
        //只查询指定的域
        query.set("fl","id,product_name,product_price,product_picture");
        //高亮显示
        //打开开关
        query.setHighlight(true);
        //高亮显示的域
        query.addHighlightField("product_name");
        //高亮显示的前缀
        query.setHighlightSimplePre("<span style='color:red'>");
        //高亮显示的后缀
        query.setHighlightSimplePost("</span>");
        //执行查询
        QueryResponse queryResponse = solrServer.query(query);
        //取出结果集
        SolrDocumentList solrDocumentList = queryResponse.getResults();

        //Map K id V Map
        //Map K 域名 V List
        //List list.get(0)
        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
        //共查询到商品数量
        System.out.println("共查询商品数量"+solrDocumentList.getNumFound());
        //遍历查询的结果
        List<ProductModel> productModelList=new ArrayList<ProductModel>();
        for (SolrDocument solrDocument:solrDocumentList) {
            ProductModel productModel=new ProductModel();

            productModel.setPid((String) solrDocument.get("id"));
            productModel.setPicture((String) solrDocument.get("product_picture"));
            productModel.setPrice((Float) solrDocument.get("product_price"));
            productModel.setCatalog_name((String) solrDocument.get("product_catalog_name"));

         /*   Map<String, List<String>> map = highlighting.get(solrDocument.get("id"));
            List<String> list = map.get("product_name");*/

            //分页高亮显示
            if(highlighting != null){
                List<String> listList = highlighting.get(solrDocument.get("id")).get("product_name");
                if(listList != null && listList.size() > 0){
                    productModel.setName(listList.get(0));
                } else {
                    productModel.setName(String.valueOf(solrDocument.get("product_name")));
                }
            } else {
//					封装商品对象 采用 （string强转的方式）
                productModel.setName((String) solrDocument.get("product_name"));
            }

           /* productModel.setName(list.get(0));*/
            productModelList.add(productModel);
        }
        return productModelList;
    }

    public int getTotal(){
        SolrQuery query=new SolrQuery();
        //设置查询条件
        query.setQuery("*:*");
        //执行查询
        QueryResponse queryResponse= null;
        try {
            queryResponse = solrServer.query(query);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        //取查询结果
        SolrDocumentList solrDocumentList = queryResponse.getResults();

        return (int) solrDocumentList.getNumFound();
    }
}
