package com.lzyd.es.controller;

import com.lzyd.es.model.EsEvent;
import com.lzyd.es.service.BaseElasticService;
import com.lzyd.es.utils.ElasticsearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/09/19]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping("/es")
@RestController
public class EsUserController {
    @Autowired
    BaseElasticService baseElasticService;


    @Autowired
    ElasticsearchUtil esUtil;

    @PostMapping("createIndex")
    public String createIndex() {
        try {
            esUtil.createIndexIfNotExist(EsEvent.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

}
