package com.lzyd.com.my_test;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/09/18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Test4 {
    @Test
    //创建索引+插入文档
    public void fun01() throws Exception {


    }


    public static void main(String[] args) {
        int year = 365;
        double money = 1;
        for (int i = 1; i <= year; i++) {
            money = money * 1.001;
//            if (i <= 12){
//                money += 1000;
//            }
        }
        System.out.println("总收益:" + money + "w");


    }
}
