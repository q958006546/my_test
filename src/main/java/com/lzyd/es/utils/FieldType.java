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
import lombok.Getter;

/**
 * es 类型参看
 * https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping-types.html
 */
@Getter
public enum FieldType {
    /**
     * text
     */
    TEXT("text"),

    KEYWORD("keyword"),

    INTEGER("integer"),

    DOUBLE("double"),

    DATE("date"),

    /**
     * 单条数据
     */
    OBJECT("object"),

    /**
     * 嵌套数组
     */
    NESTED("nested"),


    ;


    FieldType(String type){
        this.type = type;
    }

    private String type;


}
