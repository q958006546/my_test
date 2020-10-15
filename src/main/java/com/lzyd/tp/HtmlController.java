package com.lzyd.tp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/09/18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
@RequestMapping("/html")
public class HtmlController {
    @RequestMapping("/test1")
    public String test1() {
        return "test1";
    }


}
