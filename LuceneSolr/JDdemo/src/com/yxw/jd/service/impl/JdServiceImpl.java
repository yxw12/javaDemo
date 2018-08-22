package com.yxw.jd.service.impl;

import com.yxw.jd.dao.JdDao;
import com.yxw.jd.pojo.Page;
import com.yxw.jd.pojo.ProductModel;
import com.yxw.jd.pojo.QueryVo;
import com.yxw.jd.service.JdService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yan on 2018/8/9.
 */
@Service
public class JdServiceImpl implements JdService{
    @Resource
    private JdDao jdDao;
    @Override
    public List<ProductModel> queryProductAll(int start,String queryString, String catalog_name, String price, String sort) throws SolrServerException {
        return jdDao.queryProductAll(start,queryString,catalog_name,price,sort);
    }

    @Override
    public Page<ProductModel> queryQueryVoAll(QueryVo queryVo) throws SolrServerException {
        Page<ProductModel> page=new Page<ProductModel>();

        page.setCurPage(queryVo.getPage().getCurPage());
        int total=jdDao.getTotal();
        page.setRecordCount(total);

        page.setPageCount((total + 8 - 1) / 8);

        int start=(queryVo.getPage().getCurPage()-1)*8;

        System.out.println(page.toString()+"..."+start);
        page.setProductList(queryProductAll(start,queryVo.getQueryString(),queryVo.getCatalog_name(),queryVo.getPrice(),queryVo.getSort()));

        return page;
    }
}
