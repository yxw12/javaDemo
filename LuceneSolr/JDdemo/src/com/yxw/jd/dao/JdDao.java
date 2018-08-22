package com.yxw.jd.dao;

import com.yxw.jd.pojo.ProductModel;
import org.apache.solr.client.solrj.SolrServerException;

import java.util.List;

/**
 * Created by Yan on 2018/8/9.
 */
public interface JdDao {
    List<ProductModel> queryProductAll(int start,String queryString, String catalog_name, String price, String sort) throws SolrServerException;

    int getTotal();
}

