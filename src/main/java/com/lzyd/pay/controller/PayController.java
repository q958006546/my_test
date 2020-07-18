package com.lzyd.pay.controller;

import com.lzyd.config.AlipayConfig;
import com.lzyd.pay.controller.porxy.PayProxyService;
import com.lzyd.pay.controller.porxy.impl.PayProxyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.lzyd.pay.controller.utils.PayUtils.getUTF8XMLString;


/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/07/18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RequestMapping(value = "/api/pay")
@RestController
public class PayController {
    @Autowired
    PayProxyService payProxyService;

    @RequestMapping("/test")
    public void toAlipay(HttpServletRequest httpRequest , HttpServletResponse httpResponse, String payId, String totalFee, String body) throws IOException {

        //生成一笔支付记录，支付完成时将支付状态改为成功


        Map<String, String> sourceMap = new HashMap<>();
        sourceMap.put("out_trade_no",payId);
        sourceMap.put("total_amount",totalFee);
        sourceMap.put("body",getUTF8XMLString(body));


        String form = payProxyService.toAlipay(sourceMap);
        httpResponse.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }



    //将请求中的参数转换为Map
    public static Map<String, String> convertRequestParamsToMap(HttpServletRequest request) {
        Map<String, String>              retMap   = new HashMap();
        Set<Map.Entry<String, String[]>> entrySet = request.getParameterMap().entrySet();
        Iterator                         var3     = entrySet.iterator();

        while (true) {
            while (var3.hasNext()) {
                Map.Entry<String, String[]> entry  = (Map.Entry) var3.next();
                String                      name   = (String) entry.getKey();
                String[]                    values = (String[]) entry.getValue();
                int                         valLen = values.length;
                if (valLen == 1) {
                    retMap.put(name, values[0]);
                } else if (valLen <= 1) {
                    retMap.put(name, "");
                } else {
                    StringBuilder sb    = new StringBuilder();
                    String[]      var9  = values;
                    int           var10 = values.length;

                    for (int var11 = 0; var11 < var10; ++var11) {
                        String val = var9[var11];
                        sb.append(",").append(val);
                    }

                    retMap.put(name, sb.toString().substring(1));
                }
            }

            return retMap;
        }



    }
    @RequestMapping("/test2")
    public String test2(HttpServletRequest httpRequest , HttpServletResponse httpResponse ,Integer num) throws IOException {
        if (num == null){
            System.out.println(0 + "," + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            return "别看了";
        }
        if (num == 1){
            System.out.println(1 + "," + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            return "gb老何";
        }
        if (num == 520){
            System.out.println(520 + "," + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            return "看啥";
        }
        return "666";

    }

    @RequestMapping("/test3")
    public String test3(HttpServletRequest httpRequest , HttpServletResponse httpResponse ,Integer num) throws IOException {
        if (httpRequest.getHeader("x-forwarded-for") == null) {
            return httpRequest.getRemoteAddr();
        }
        return httpRequest.getHeader("x-forwarded-for");
    }






}
