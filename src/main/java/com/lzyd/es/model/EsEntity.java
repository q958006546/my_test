package com.lzyd.es.model;

import lombok.Data;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/10/14]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Data
public class EsEntity<T> {

    private String id;
    private T data;
    public EsEntity() {
    }

    public EsEntity(String id, T data) {
        this.data = data;
        this.id = id;
    }
}
