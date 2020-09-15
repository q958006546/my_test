package com.lzyd.reptile;

import com.lzyd.reptile.proxy.ReptileProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/08/03]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
@RequestMapping("/api/reptile")
public class ReptileController {
    @Autowired
    private ReptileProxyService reptileProxyService;


    @RequestMapping(value = "quBiGe", method = RequestMethod.POST)
    public Object taskList(@RequestBody Map<String,Object> map) {
        Object o = reptileProxyService.quBiGe(map);
        return o;
    }


}
