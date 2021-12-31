package com.lzyd.es.controller;

import com.lzyd.common.model.Result;
import com.lzyd.common.model.StatusCode;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.RequestLine;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseListener;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/08/11]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

@RestController
@RequestMapping("/low")
@Slf4j
public class UserChapterFiveController {

    @Autowired
    private RestClient restClient;
    /**
     * 同步执行HTTP请求
     *
     * @param
     * @return org.springframework.http.ResponseEntity<java.lang.String>
     * @throws IOException
     * @author wliduo[i@dolyw.com]
     * @date 2019/8/8 17:15
     */
    @PostMapping("/es")
    public Result getEsInfo() throws IOException {
        Request request = new Request("GET", "/");
        // performRequest是同步的，将阻塞调用线程并在请求成功时返回Response，如果失败则抛出异常
        Response response = restClient.performRequest(request);
        // 获取请求行
        RequestLine requestLine = response.getRequestLine();
        // 获取host
        HttpHost host = response.getHost();
        // 获取状态码
        int statusCode = response.getStatusLine().getStatusCode();
        // 获取响应头
        Header[] headers = response.getHeaders();
        // 获取响应体
        String responseBody = EntityUtils.toString(response.getEntity());
        return new Result(true,StatusCode.OK, "查询成功", JSONObject.fromObject(responseBody));
    }

    /**
     * 异步执行HTTP请求
     *
     * @param
     * @return org.springframework.http.ResponseEntity<java.lang.String>
     * @author wliduo[i@dolyw.com]
     * @date 2019/8/8 17:15
     */
    @PostMapping("/es/async")
    public Result asynchronous() {
        Request request = new Request("GET", "/");
        restClient.performRequestAsync(request, new ResponseListener() {
            @Override
            public void onSuccess(Response response) {
                log.info("异步执行HTTP请求并成功");
            }

            @Override
            public void onFailure(Exception exception) {
                log.info("异步执行HTTP请求并失败");
            }
        });
        return new Result(true,StatusCode.OK, "异步请求中", null);
    }


    @PostMapping("/book")
    public Result getBookList() {
        Request request = new Request("POST", new StringBuilder("/_search").toString());
        request.addParameter("pretty", "true");
//        restClient.performRequestAsync(request,);
        return new Result(true,StatusCode.OK, "异步请求中", null);
    }

    /**
    * @Author: 根据ID查询
    * @Description:
    * @Date: 2020/8/17  17:42
    * @Param null:
            * @return: null
    **/
    @PostMapping("/book/getById/{id}")
    public Result getById(@PathVariable(value = "id") Integer id) {
        Request request = new Request("GET", new StringBuilder("/product/_doc/").append(id).toString());
        request.addParameter("pretty", "true");
        Response response = null;
        String responseBody = null;
        try {
            // 执行HTTP请求
            response = restClient.performRequest(request);
            responseBody = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(true,StatusCode.ERROR, "can not found the book by your id", null);
        }
        return new Result(true,StatusCode.OK, "查询成功",  JSONObject.fromObject(responseBody));
    }

    public static void main(String[] args) {

    }




}
