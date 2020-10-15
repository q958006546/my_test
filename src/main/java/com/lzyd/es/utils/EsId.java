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
 * 用于标识使用 该字段作为ES数据中的id
 * @author sh.Liu
 * @create: 2020-07-22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface EsId {
}
