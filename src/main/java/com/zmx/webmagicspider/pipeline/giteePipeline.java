package com.zmx.webmagicspider.pipeline;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Iterator;
import java.util.Map;

@Slf4j
@Component(value = "giteePipeline")
public class giteePipeline implements Pipeline {


    @Override
    public void process(ResultItems resultItems, Task task) {
        Iterator it = resultItems.getAll().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) it.next();
            log.info("gitee:{}", JSONObject.toJSONString(entry));
        }

    }
}