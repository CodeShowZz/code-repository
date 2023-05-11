package com.crawler;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.scheduler.Scheduler;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * @author junlin_huang
 * @create 2021-07-16 12:23 上午
 **/

public class Category implements HtmlBean {

    private static final long serialVersionUID = 3018760488621382659L;

    @Text
    @HtmlField(cssPath="dt > a")
    private String parentName;

    @Text
    @HtmlField(cssPath="dd > a")
    private List<HrefBean> categorys;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<HrefBean> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<HrefBean> categorys) {
        this.categorys = categorys;
    }

    public static void main(String[] args) {
        GeccoEngine.create()
                //工程的包路径
                .classpath("com.crawler")
                //开始抓取的页面地址
                .start("https://www.jd.com/allSort.aspx")
                //.start("https://list.jd.com/list.html?cat=9987,653,655&delivery=1&page=1&JL=4_10_0&go=0")
                //开启几个爬虫线程
                .thread(1)
//                //单个爬虫每次抓取完一个请求后的间隔时间
//                .interval(2000)
//                //循环抓取
//                .loop(true)
                //使用pc端userAgent
                .mobile(false)
                .loop(false)
                //开始运行
                .run();
    }

}