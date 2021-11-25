package com.zmx.webmagicspider.processor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component(value = "giteePageProcessor")
public class GiteePageProcessor implements PageProcessor {

    @Autowired
    private Site giteeSite;

    @Override
    public void process(Page page) {
        List<Selectable> nodes = page.getHtml().xpath("//*[@id=\"open-source-vip-page\"]/div[2]/div/div//a").nodes();
        for (Selectable s : nodes) {
            Document document = Jsoup.parse(s.toString());
            page.putField(document.getElementsByTag("a").get(0).child(0).child(0).attr("title"), document.getElementsByTag("a").get(0).child(1).child(0).attr("title"));
        }
//        if (page.getResultItems().get("name") == null) {
//            page.setSkip(true);
//        }
        List<Selectable> a = page.getHtml().xpath("//a").nodes();
        ArrayList<String> list = Lists.newArrayList();
        for (Selectable s : a) {
            Elements a1 = Jsoup.parseBodyFragment(s.toString()).select("a");

            list.add(StringUtils.contains(a1.attr("href").toString(), "http") ? a1.attr("href") : "http://gitee.com/" + a1.attr("href"));
        }
        page.addTargetRequests(list);
    }

    @Override
    public Site getSite() {
        return giteeSite;
    }
}