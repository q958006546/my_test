package com.lzyd.es.utils;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/10/15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

import java.lang.annotation.*;

/**
 * 作用在字段上，用于定义类型，映射关系
 * @author ls
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface Field  {

    FieldType type() default FieldType.TEXT;

    /**
     * 指定分词器
     * @return
     */
    AnalyzerType analyzer() default AnalyzerType.STANDARD;
}