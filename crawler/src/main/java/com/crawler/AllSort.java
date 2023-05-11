package com.crawler;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * @author junlin_huang
 * @create 2021-07-16 12:17 上午
 **/

@Gecco(matchUrl="https://www.jd.com/allSort.aspx", pipelines={"allSortPipeline"})
public class AllSort implements HtmlBean {

    private static final long serialVersionUID = 665662335318691818L;

    @Request
    private HttpRequest request;

    //手机
    @HtmlField(cssPath=".category-items > div:nth-child(1) > div:nth-child(2) > div.mc > div.items > dl")
    private List<Category> mobile;

    //家用电器
    @HtmlField(cssPath=".category-items > div:nth-child(1) > div:nth-child(3) > div.mc > div.items > dl")
    private List<Category> domestic;

    public List<Category> getMobile() {
        return mobile;
    }

    public void setMobile(List<Category> mobile) {
        this.mobile = mobile;
    }

    public List<Category> getDomestic() {
        return domestic;
    }

    public void setDomestic(List<Category> domestic) {
        this.domestic = domestic;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }
}
