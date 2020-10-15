package com.lzyd.es.utils;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/10/14]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
import java.lang.annotation.*;

/**
 * Es 文档注解，用于做索引实体映射
 * 作用在类上
 * @author ls
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface Document {

    /**
     * index : 索引名称
     * @return
     */
    String index();

    /**
     * 类型名称
     * @return
     */
    String type();

}
