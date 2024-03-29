package com.crawler;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

import java.util.List;

/**
 * @author junlin_huang
 * @create 2021-07-16 12:49 上午
 **/

@Data
@Gecco(matchUrl="https://list.jd.com/list.html?cat={cat}&delivery={delivery}&page={page}&JL={JL}&go=0", pipelines={"productListPipeline"})
public class ProductList implements HtmlBean {

    private static final long serialVersionUID = 4369792078959596706L;

    @Request
    private HttpRequest request;

    /**
     * 抓取列表项的详细内容，包括titile，价格，详情页地址等
     */
    @HtmlField(cssPath="#J_goodsList > ul > li")
    private List<ProductBrief> details;
    /**
     * 获得商品列表的当前页
     */
    @Text
    @HtmlField(cssPath="#J_topPage > span > b")
    private int currPage;
    /**
     * 获得商品列表的总页数
     */
    @Text
    @HtmlField(cssPath="#J_topPage > span > i")
    private int totalPage;


}