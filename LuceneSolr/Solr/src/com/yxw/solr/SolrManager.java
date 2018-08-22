package com.yxw.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Yan on 2018/8/9.
 */
public class SolrManager {

    //向索引库中添加索引

    /*在solrJ中修改没有对应的update方法，只有add方法，只需要添加一条新的文档，
    和被修改的文档id一致就，可以修改了。本质上就是先删除后添加。*/
    @Test
    public void addDocument() throws IOException, SolrServerException {
        //和solr服务器创建连接
        //参数：solr服务器的地址
        SolrServer solrServer=new HttpSolrServer("http://localhost:8080/solr");
        //创建一个文档对象
        SolrInputDocument document=new SolrInputDocument();
        //向文档中添加域
        //第一个参数：域的名称，域的名称必须是在schema.xml 中定义的
        //第二个参数：域的值
        document.addField("id","c0001");
        document.addField("title_ik","使用solrJ添加的文档");
        document.addField("content_ik","文档的内容");
        document.addField("product_name","商品名称");
        //把document 对象添加到索引库中
        solrServer.add(document);
        //提交修改
        solrServer.commit();
    }

    //删除文档，根据id删除
    @Test
    public void deleteDocumentById() throws IOException, SolrServerException {
        //创建连接
        SolrServer solrServer=new HttpSolrServer("http://localhost:8080/solr");
        //根据id 删除文档
        solrServer.deleteById("c0001");
        //提交修改
        solrServer.commit();
    }

    //根据查询条件删除文档
    @Test
    public void deleteDocumentByQuery() throws IOException, SolrServerException {
        //创建连接
        SolrServer solrServer=new HttpSolrServer("http://localhost:8080/solr");
        //根据查询条件删除文档
        solrServer.deleteByQuery("*:*");
        //提交修改
        solrServer.commit();
    }

    //简单查询索引
    @Test
    public void queryIndex() throws SolrServerException {
        //创建连接
        SolrServer solrServer=new HttpSolrServer("http://localhost:8080/solr");
        //创建一个query 对象
        SolrQuery query=new SolrQuery();
        //设置查询条件
        query.setQuery("*:*");
        //执行查询
        QueryResponse queryResponse=solrServer.query(query);
        //取查询结果
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        //共查询到商品数量
        System.out.println("共查询到商品数量"+solrDocumentList.getNumFound());
        //遍历查询结果
        for (SolrDocument solrDocument :solrDocumentList) {
            System.out.println(solrDocument.get("id"));
            System.out.println(solrDocument.get("product_name"));
            System.out.println(solrDocument.get("product_price"));
            System.out.println(solrDocument.get("product_catalog_name"));
            System.out.println(solrDocument.get("product_picture"));
        }
    }

    //复杂查询索引
    @Test
    public void queryIndex2() throws SolrServerException {
        //创建连接
        SolrServer solrServer=new HttpSolrServer("http://localhost:8080/solr/collection1");
        //创建一个query 对象
        SolrQuery query=new SolrQuery();
        //设置查询条件
        query.setQuery("台灯");
        //过滤条件
        query.setFilterQueries("product_catalog_name:幽默杂货");
        query.set("fq","product_price:[* TO 10]");
        //排序条件
        query.addSort("product_price", SolrQuery.ORDER.asc);
        //分页处理
        query.setStart(0);
        query.setRows(5);
        //默认域
        query.set("df","product_name");
        //只查询指定的域
        query.set("fl","id,product_name");
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
        for (SolrDocument solrDocument:solrDocumentList) {
            System.out.println(solrDocument.get("product_name"));
            System.out.println(solrDocument.get("product_price"));
            System.out.println(solrDocument.get("product_catalog_name"));
            System.out.println(solrDocument.get("product_picture"));
            System.out.println(solrDocument.get("id"));
            System.out.println("======================================");
            Map<String, List<String>> map = highlighting.get(solrDocument.get("id"));
            List<String> list = map.get("product_name");
            System.out.println(list.get(0));
        }

    }
}
