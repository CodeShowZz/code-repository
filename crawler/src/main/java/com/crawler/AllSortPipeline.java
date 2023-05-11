package com.crawler;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.geccocrawler.gecco.spider.HrefBean;

import java.util.List;

/**
 * @author junlin_huang
 * @create 2021-07-16 12:40 上午
 **/

@PipelineName("allSortPipeline")
public class AllSortPipeline implements Pipeline<AllSort> {

    @Override
    public void process(AllSort allSort) {
        System.out.println(JSON.toJSON(allSort));
        List<Category> categorys = allSort.getMobile();
        HttpRequest r = allSort.getRequest();
        for(Category category : categorys) {
            List<HrefBean> hrefs = category.getCategorys();
            for(HrefBean href : hrefs) {
                String url = href.getUrl()+"&delivery=1&page=1&JL=4_10_0&go=0";
                HttpRequest currRequest = allSort.getRequest();
                currRequest.addCookie("cookie","__jdu=995453669; shshshfpa=e5a3b2c9-f6d1-5f43-ae87-9e811e378511-1612284464; shshshfpb=rlOQair6bg0kHGqu6fmi1vQ%3D%3D; __jdv=122270672|direct|-|none|-|1626363168917; areaId=19; ipLoc-djd=19-1607-3155-0; TrackID=10FSlm4X399IFObM4IKZVMBL0QE1emELuOdhU6nS2WlMc7q-A4aPG4-UydNNS1PzXZWUmunAYvL16PDWO0TmRrMo3KTcWI59nAvLsqScZpRcgUPW8VtbCcNcSO1cdeChc; pinId=hzYGgZBExgt4LF7FK8COGg; pin=JunLin625; unick=JunLin625; ceshi3.com=000; _tp=jkt7mc4g%2BOB7nBA2pBWY7g%3D%3D; _pst=JunLin625; PCSYCityID=CN_440000_440300_440305; user-key=0160c280-8937-4714-8f21-c639cb13e760; __jda=122270672.995453669.1612284461.1626366836.1626369425.4; __jdc=122270672; shshshfp=598dfd7e295cbfb54fa25ef208493e44; 3AB9D23F7A4B3C9B=DFA5GVQBUUDTSBWZ7N4NBKH2U6BMFDKGVMEQ223U3MUUUSCL56VEFZ32GMBXBBPDTAN7F3FXZYKZ6LTNQCLZAAK7TA; __jdb=122270672.31.995453669|4.1626369425; shshshsID=db5a0937b6c27793482cd092db731e50_8_1626373743346; thor=35E6918E349BBE89633F1284D071E23FBE4DA0E5D0CE08BA27EFA78116ECA2EDDD623C7FCB9B2745291E44343B330D74FF5E9C8F2254F7FDAE231E1896899E9F8A46849D81E45EA6BDBE6F5ADA79AD785906806AEB6B198C0F86A932D690067564F48498FE0341BA1F4925276ABE1DBB8C527FD9EF1A25960C0E9789128D950521928DB7A0F6BFF5CE8D616652814095");
                DeriveSchedulerContext.into(currRequest.subRequest(url));
            }
        }
    }

}