package com.lzyd.annotation.interfaceAnnotation;

import java.lang.annotation.*;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/07/22]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface CronScheduled {
    /**
     * 执行时间表达式 0 0/1 * * *
     */
    String cron() default "";

    String desc() default "";


}
