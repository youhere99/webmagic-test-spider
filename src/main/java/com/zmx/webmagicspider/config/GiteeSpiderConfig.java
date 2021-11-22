package com.zmx.webmagicspider.config;

import com.zmx.webmagicspider.pipeline.giteePipeline;
import com.zmx.webmagicspider.processor.GiteePageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;


@Configuration
public class GiteeSpiderConfig {

    @Autowired
    private giteePipeline giteePipeline;

    @Autowired
    private GiteePageProcessor giteePageProcessor;


    /**
     * 站点配置
     *
     * @return
     */
    @Bean("giteeSite")
    public Site giteeSite() {
        return Site.me().setRetryTimes(3).setSleepTime(1000);
    }

    /**
     * 配置代理
     *
     * @return
     */
    public Downloader giteeHttpClientDownloader() {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
//        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(new Proxy("101.101.101.101",8888,"username","password")));
        return httpClientDownloader;
    }

    @Bean("giteeSpider")
    public Spider giteeSpider() {
        Spider spider = Spider.create(giteePageProcessor);
        spider.addUrl("https://gitee.com/gvp");
        spider.setDownloader(giteeHttpClientDownloader());
        spider.setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000000)));
        spider.addPipeline(giteePipeline);
        spider.thread(5);
        return spider;
    }

}
