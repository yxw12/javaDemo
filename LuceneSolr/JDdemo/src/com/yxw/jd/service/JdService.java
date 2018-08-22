package com.yxw.jd.service;

import com.yxw.jd.pojo.Page;
import com.yxw.jd.pojo.ProductModel;
import com.yxw.jd.pojo.QueryVo;
import org.apache.solr.client.solrj.SolrServerException;

import java.util.List;

/**
 * Created by Yan on 2018/8/9.
 */
public interface JdService {
    List<ProductModel> queryProductAll(int start,String queryString, String catalog_name, String price, String sort) throws SolrServerException;

    Page<ProductModel> queryQueryVoAll(QueryVo queryVo) throws SolrServerException;


}
