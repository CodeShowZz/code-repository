package com.crawler;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @author junlin_huang
 * @create 2021-07-16 12:51 上午
 **/

public class ProductBrief implements HtmlBean {

    private static final long serialVersionUID = -377053120283382723L;

    @Attr("data-sku")
    @HtmlField(cssPath=".gl-item")
    private String code;

    @Text
    @HtmlField(cssPath=".p-name > a > em")
    private String title;

    @Image({"data-lazy-img", "src"})
    @HtmlField(cssPath=".p-img > a > img")
    private String preview;

    @Href(click=true)
    @HtmlField(cssPath=".p-name > a")
    private String detailUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
