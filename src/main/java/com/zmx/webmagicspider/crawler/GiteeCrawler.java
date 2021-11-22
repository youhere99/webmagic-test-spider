package com.zmx.webmagicspider.crawler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping(value = "/gitee")
public class GiteeCrawler {

    @Resource(name = "giteeSpider")
    private Spider giteeSpider;


    @GetMapping(value = "/start")
    public void start() {
        giteeSpider.start();
    }

    @GetMapping(value = "/status")
    public void status() {
        log.info("status-{}", giteeSpider.getStatus().name());
        log.info("uuid-{}", giteeSpider.getUUID());
        log.info("pageCount-{}", giteeSpider.getPageCount());
    }

    @GetMapping(value = "/stop")
    public void stop() {
        giteeSpider.stop();
        log.info("status-{}", giteeSpider.getStatus().name());
        log.info("uuid-{}", giteeSpider.getUUID());
        log.info("pageCount-{}", giteeSpider.getPageCount());
    }
}