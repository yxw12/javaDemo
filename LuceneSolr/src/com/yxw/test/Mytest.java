package com.yxw.test;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;


/**
 * Created by Yan on 2018/8/8.
 */
public class Mytest {
    @Test
    public void createIndex() throws IOException {
        //指定索引库存放的路径
        //G:\index\index
        Directory directory= FSDirectory.open(new File("G:\\index\\index"));
        //索引库还可以存放到内存中
        //Directory directory1=new RAMDirectory();
        //创建一个标准分析器
        Analyzer analyzer=new StandardAnalyzer();
        //创建indexwriterConfig对象
        //第一个参数：Lucene 的版本信息，可以选择对应的Lucene版本，也可以是LATEST
        //第二个参数：分析器对象
        IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        //创建indexwriter对象
        IndexWriter indexWriter=new IndexWriter(directory,config);
        //原始文档路径E:\index\searchsource
        File file=new File("E:\\index\\searchsource");
        for (File file1:file.listFiles()) {
            //文件名
            String fileName=file1.getName();
            //文件内容
            String fileContent= FileUtils.readFileToString(file1);
            //文件路径
            String filePath = file1.getPath();
            //文件大小
            long fileSize = FileUtils.sizeOf(file1);
            //创建文件名域
            //第一个参数：域的名称
            //第二个参数：域的内容
            //第三个参数：是否存储
            Field fileNameField = new TextField("filename", fileName, Field.Store.YES);
            //文件内容域
            Field fileContentField = new TextField("content",fileContent, Field.Store.YES);
            //文件路径域（不分析、不索引、只存储）
            Field filePathField = new StoredField("path",filePath);
            //文件大小域
       //     Field fileSizeField = new TextField("size",fileSize, Field.Store.YES);
            Field fileSizeField = new StoredField("size", fileSize);

            //创建document对象
            Document document=new Document();
            document.add(fileNameField);
            document.add(fileContentField);
            document.add(filePathField);
            document.add(fileSizeField);
            //创建索引，并写入索引库
            indexWriter.addDocument(document);
        }
        //关闭indexwriter
        indexWriter.close();

    }
    //查看标准分析器的分词效果
    @Test
    public void testTokenStream() throws IOException {
        //创建一个标准分析器对象
    //    Analyzer analyzer=new StandardAnalyzer();
        //Ik解析器
        Analyzer analyzer=new IKAnalyzer();
        //获得tokenStream 对象
        //第一个参数：域名，可以随便给一个
        //第二个参数：要分析的文本内容
   //     TokenStream tokenStream=analyzer.tokenStream("test","The Spring Framework provides a comprehensive programming and configuration model.");
        TokenStream tokenStream=analyzer.tokenStream("test", "你是高富帅数据库查询和全文检索的区别高富帅");
        //添加一个引用，可以获得每个关键词
        CharTermAttribute charTermAttribute=tokenStream.addAttribute(CharTermAttribute.class);
        //添加一个偏移量的引用，记录了关键词的开始位置以及结束位置
        OffsetAttribute offsetAttribute=tokenStream.addAttribute(OffsetAttribute.class);
        //将指针调整到列表的头部
        tokenStream.reset();
        //遍历关键词列表，通过increamToken方法判断列表是否结束
        System.out.println(tokenStream.incrementToken());
        while (tokenStream.incrementToken()){
            //关键词的起始位置
            System.out.println("start->"+offsetAttribute.startOffset());
            //取关键词的
            System.out.println(charTermAttribute);
            //结束位置
            System.out.println("end->"+offsetAttribute.endOffset());
        }
        tokenStream.close();
    }

    //添加索引
    @Test
    public void addDocument() throws IOException {
        //索引库存放路径
        Directory directory=FSDirectory.open(new File("G:\\index\\index"));

        IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_4_10_3,new StandardAnalyzer());
        //创建indexwriter对象
        IndexWriter indexWriter=new IndexWriter(directory,config);
        //创建一个document 对象
        Document document=new Document();
        //向document 对象中添加域
        //不同的document可以有不同的域，同一个document可以有相同的域。
        document.add(new TextField("filename","新添加的文档", Field.Store.YES));
        document.add(new TextField("content","新添加的内容", Field.Store.NO));
        document.add(new TextField("content","新添加的内容第二个", Field.Store.YES));
        document.add(new TextField("content1","新添加的文档的内容要看得到", Field.Store.YES));
        //添加文档到索引库
        indexWriter.addDocument(document);
        //关闭indexwriter
        indexWriter.close();
    }

    public IndexWriter getIndexWriter() throws IOException {
        //索引库存放路径
        Directory directory=FSDirectory.open(new File("G:\\index\\index"));
        IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_4_10_3,new StandardAnalyzer());
        //创建indexwriter对象
        return  new IndexWriter(directory,config);
    }

    //删除全部索引
    //说明：将索引目录的索引信息全部删除，直接彻底删除，无法恢复。
    //此方法慎用！！！
    @Test
    public void deleteAllIndex() throws IOException {
        //创建indexwriter对象
        IndexWriter indexWriter=getIndexWriter();
        //删除全部索引
        indexWriter.deleteAll();
        //关闭indexwriter
        indexWriter.close();
    }


    //根据查询条件删除索引
    @Test
    public void deleteIndexByQuery() throws IOException {
        IndexWriter indexWriter=getIndexWriter();
        //创建一个查询条件
        Query query=new TermQuery(new Term("filename","apache"));
        //根据查询条件删除
        indexWriter.deleteDocuments(query);
        //关闭indexwriter
        indexWriter.close();
    }

    //修改索引库
    @Test
    public void updateIndex() throws IOException {
        IndexWriter indexWriter=getIndexWriter();
        //创建一个Document 对象
        Document document=new Document();
        //向 document 对象中添加域
        //不同的document可以有不同的域，同一个document可以有相同的域
        document.add(new TextField("filename","要更新的文档", Field.Store.YES));
        document.add(new TextField("content","2013年11月18日 - Lucene 简介 Lucene " +
                "是一个基于 Java 的全文信息检索工具包,它不是一个完整的搜索应用程序," +
                "而是为你的应用程序提供索引和搜索功能。", Field.Store.YES));
        indexWriter.updateDocument(new Term("content","java"),document);
        //关闭indexwriter
        indexWriter.close();
    }

    //IndexReader  IndexSearcher
    public IndexSearcher getIndexSearcher() throws Exception{
        // 第一步：创建一个Directory对象，也就是索引库存放的位置。
        Directory directory = FSDirectory.open(new File("G:\\index\\index"));// 磁盘
        // 第二步：创建一个indexReader对象，需要指定Directory对象。
        IndexReader indexReader = DirectoryReader.open(directory);
        // 第三步：创建一个indexsearcher对象，需要指定IndexReader对象
        return new IndexSearcher(indexReader);
    }

    //执行查询的结果
    public void printResult(IndexSearcher indexSearcher,Query query)throws Exception{
        // 第五步：执行查询。
        TopDocs topDocs = indexSearcher.search(query, 16);
        // 第六步：返回查询结果。遍历查询结果并输出。
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document document = indexSearcher.doc(doc);
            // 文件名称
            String fileName = document.get("filename");
            System.out.println(fileName);
            // 文件内容
            String fileContent = document.get("content");
            System.out.println(fileContent);
            // 文件大小
            String fileSize = document.get("size");
            System.out.println(fileSize);
            // 文件路径
            String filePath = document.get("path");
            System.out.println(filePath);
            System.out.println("------------");
        }
    }

    //使用MatchAllDocsQuery查询索引目录中的所有文档
    //查询所有
    @Test
    public void testMatchAllDocsQuery() throws Exception {
        IndexSearcher indexSearcher=getIndexSearcher();
        //创建查询条件
        Query query=new MatchAllDocsQuery();
        //执行查询
        printResult(indexSearcher,query);
        //关闭资源
        indexSearcher.getIndexReader().close();
    }

    //指定要查询的域和要查询的关键词
    //使用Termquery查询
    @Test
    public void testTermquery() throws Exception {
        IndexSearcher indexSearcher=getIndexSearcher();
        //创建查询对象
        Query query=new TermQuery(new Term("content","apache"));
        //执行查询
        TopDocs topDocs = indexSearcher.search(query, 10);
        //共查询到的 document 个数
        System.out.println("查询结果总数量"+topDocs.totalHits);
        //遍历查询结果
        for (ScoreDoc scoreDoc:topDocs.scoreDocs) {
            Document document = indexSearcher.doc(scoreDoc.doc);
            System.out.println(document.get("filename"));
            System.out.println(document.get("content"));
            System.out.println(document.get("size"));
            System.out.println(document.get("path"));
        }
        //关闭indexReader
        indexSearcher.getIndexReader().close();
    }

    //NumericRangeQuery可以根据数值范围查询
    //根据数值范围查询
    @Test
    public void testNumericRangeQuery() throws Exception {
        IndexSearcher indexSearcher=getIndexSearcher();
        //创建查询对象
        //参数：
        //1.域名
        //2.最小值
        //3.最大值
        //4.是否包含最小值
        //5.是否包含最大值
        Query query=NumericRangeQuery.newLongRange("size",(long)1,(long)10001,true,true);
        System.out.println(query);
        //执行查询
        printResult(indexSearcher,query);
        //关闭资源
        indexSearcher.getIndexReader().close();
    }

    //BooleanQuery可以组合查询条件
    //组合条件查询
    @Test
    public void testBooleanQuery() throws Exception {
        IndexSearcher indexSearcher=getIndexSearcher();
        //创建布尔查询对象
        BooleanQuery query=new BooleanQuery();
        //创建第一个查询条件
        Query query1=new TermQuery(new Term("filename","lucene"));
        Query query2=new TermQuery(new Term("content","apache"));
        //组合查询条件
        query.add(query1, BooleanClause.Occur.SHOULD);
        query.add(query2, BooleanClause.Occur.SHOULD);
        //执行查询
        printResult(indexSearcher,query);
        //关闭资源
        indexSearcher.getIndexReader().close();
    }

    //QueryParser创建Query
    @Test
    public void testQueryParser() throws Exception {
        IndexSearcher indexSearcher=getIndexSearcher();
        //创建QueryParser对象
        //第一个参数值默认的搜索域
        //第二个参数就是分析器对象
        QueryParser queryParser=new QueryParser("content",new IKAnalyzer());
        Query query = queryParser.parse("Lucene是Java开发的");
        //执行查询
        printResult(indexSearcher,query);
    }

    //MultiFieldQueryParser可以指定多个默认搜索域
    @Test
    public void testMultiFieldQueryParser() throws Exception {
        IndexSearcher indexSearcher=getIndexSearcher();
        //可以指定默认搜索的域是多个
        String[] fields={"filename","content"};
        //创建一个MultiFieldQueryParser对象
        MultiFieldQueryParser queryParser=new MultiFieldQueryParser(fields,new IKAnalyzer());
        Query query = queryParser.parse("java and apache");
        //执行查询
        printResult(indexSearcher,query);
    }
}
