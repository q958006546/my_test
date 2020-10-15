package com.lzyd.es.service;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/09/19]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface BaseElasticService {
    Object createIndex(String idxName,String idxSQL);
}
