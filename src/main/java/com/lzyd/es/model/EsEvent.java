package com.lzyd.es.model;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/10/15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lzyd.es.utils.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @className: EsEvent
 * @description:
 * @author: sh.Liu
 * @date: 2020-07-22 10:51
 */
@Data
@Document(index = "es_event", type = "")
public class EsEvent {
    private static final long serialVersionUID=1L;

    @EsId
    @Field(type = FieldType.KEYWORD)
    private Integer eventId;

    /**
     * 唯一标识码
     */
    @Field(type = FieldType.KEYWORD)
    private String uniqueCode;

    /**
     * 任务号
     */
    @Field(type = FieldType.KEYWORD)
    private String eventCode;

    /**
     * 事件来源编号
     */
    @Field(type = FieldType.INTEGER)
    private Integer eventSrcId;

    /**
     * 事件来源名称
     */
    @Field(type = FieldType.TEXT, analyzer = AnalyzerType.IK_SMART)
    private String eventSrcName;

    /**
     * 来源分组
     */
    @Field(type = FieldType.KEYWORD)
    private String srcGroupCode;

    /**
     * 事件大类编码
     */
    @Field(type = FieldType.KEYWORD)
    private String eventTypeCode;

    /**
     * 事件大类名称
     */
    @Field(type = FieldType.TEXT, analyzer = AnalyzerType.IK_SMART)
    private String eventTypeName;

    /**
     * 事件小类编码
     */
    @Field(type = FieldType.KEYWORD)
    private String eventSubtypeCode;

    /**
     * 事件小类名称
     */
    @Field(type = FieldType.TEXT, analyzer = AnalyzerType.IK_SMART)
    private String eventSubtypeName;

    /**
     * 重要程度
     */
    @Field(type = FieldType.INTEGER)
    private Integer eventGradeId;

    /**
     * 重要程度名称
     */
    @Field(type = FieldType.KEYWORD)
    private String eventGradeName;

    /**
     *紧急程度标识
     */
    @Field(type = FieldType.INTEGER)
    private Integer eventUrgencyId;

    /**
     *紧急程度名称
     */
    @Field(type = FieldType.KEYWORD)
    private String eventUrgencyName;

    /**
     *事件级别标识
     */
    @Field(type = FieldType.INTEGER)
    private Integer eventLevelId;

    /**
     *事件级别名称
     */
    @Field(type = FieldType.KEYWORD)
    private String eventLevelName;

    /**
     *事件升级标志
     */
    @Field(type = FieldType.INTEGER)
    private Integer eventUpgradeFlag;

    /**
     *处置级别标识
     */
    @Field(type = FieldType.INTEGER)
    private Integer dealLevelId;

    /**
     *处置级别标识
     */
    @Field(type = FieldType.KEYWORD)
    private String dealLevelName;

    /**
     *公众上报人名称
     */
    @Field(type = FieldType.TEXT , analyzer = AnalyzerType.IK_SMART)
    private String publicReporterName;

    /**
     *公众上报人身份证号
     */
    @Field(type = FieldType.KEYWORD)
    private String publicReporterIdcard;

    /**
     *公众上报人联系方式
     */
    @Field(type = FieldType.KEYWORD)
    private String publicReporterTel;
    /**
     * 事件描述
     */
    @Field(type = FieldType.TEXT, analyzer = AnalyzerType.IK_SMART)
    private String eventDesc;
    /**
     * 地址
     */
    @Field(type = FieldType.TEXT, analyzer = AnalyzerType.IK_SMART)
    private String address;
    /**
     * 地区名称
     */
    @Field(type = FieldType.TEXT, analyzer = AnalyzerType.IK_SMART)
    private String areaRegionName;

    /**
     * 地区编码
     */
    @Field(type = FieldType.KEYWORD)
    private String areaRegionCode;

    /**
     * 社区名称
     */
    @Field(type = FieldType.TEXT, analyzer = AnalyzerType.IK_SMART)
    private String commRegionName;

    /**
     * 区编码
     */
    @Field(type = FieldType.KEYWORD)
    private String commRegionCode;

    /**
     * 街道名称
     */
    @Field(type = FieldType.TEXT, analyzer = AnalyzerType.IK_SMART)
    private String streetRegionName;

    /**
     * 街道编码
     */
    @Field(type = FieldType.KEYWORD)
    private String streetRegionCode;

    /**
     * 社区名称
     */
    @Field(type = FieldType.TEXT, analyzer = AnalyzerType.IK_SMART)
    private String regionName;

    /**
     * 社区编码
     */
    @Field(type = FieldType.KEYWORD)
    private String regionCode;

    /**
     * 经度
     */
    private BigDecimal coordX;

    /**
     * 纬度
     */
    private BigDecimal coordY;

    /**
     *坐标系
     */
    private String mapcoordinate;

    /**
     *网格员标识
     */
    private Integer griderId;

    /**
     *网格员标识
     */
    private String griderName;

    /**
     *网格员电话
     */
    private String griderPhone;

    /**
     *核实状态标识
     */
    @Field(type = FieldType.INTEGER)
    private Integer verifyStateId;

    /**
     *核查状态标识
     */
    @Field(type = FieldType.INTEGER)
    private Integer checkStateId;

    /**
     *事件建立时间
     */
    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String createTime;

    /**
     *流程结束时间
     */
    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String endTime;

    /**
     *延期天数
     */
    private Float postponedDays;

    /**
     *延期标志
     */
    private Integer postponedFlag;

    /**
     *受理时间
     */
    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String acceptTime;

    /**
     *立案时间
     */
    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String establishTime;

    /**
     *调度时间
     */
    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String dispatchTime;

    /**
     *流程开始时间
     */
    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String procStartTime;

    /**
     *流程结束时间
     */
    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String procEndTime;

    /**
     *流程截止时间
     */
    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String procDeadLine;

    /**
     *流程警告时间
     */
    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String procWarningTime;

    /**
     *处置开始时间
     */
    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String funcBeginTime;

    /**
     *处置完成时间
     */
    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String funcFinishTime;

    /**
     *自处置标识
     */
    private Integer gridDealFlag;

    /**
     *跨网格标志
     */
    private Integer overGridFlag;

    /**
     *是否督办
     */
    @Field(type = FieldType.INTEGER)
    private Integer pressFlag;

    /**
     *是否催办
     */
    @Field(type = FieldType.INTEGER)
    private Integer hurryFlag;

    /**
     *超期标志
     */
    @Field(type = FieldType.INTEGER)
    private Integer overtimeFlag;

    /**
     *活动属性
     */
    @Field(type = FieldType.INTEGER)
    private Integer actPropertyId;

    /**
     *活动属性名称
     */
    @Field(type = FieldType.KEYWORD)
    private String actPropertyName;

    /**
     *流程实例标识
     */
    @Field(type = FieldType.KEYWORD)
    private String procInstId;

    /**
     *流程定义标识
     */
    @Field(type = FieldType.KEYWORD)
    private String procDefId;

    /**
     *事件状态
     */
    @Field(type = FieldType.INTEGER)
    private Integer eventStateId;

    /**
     * 上一操作项
     */
    @Field(type = FieldType.KEYWORD)
    private String preActionName;

    /**
     * 登记人Id
     */
    @Field(type = FieldType.INTEGER)
    private Integer registerId;

    /**
     * 登记人姓名
     */
    @Field(analyzer = AnalyzerType.IK_SMART)
    private String registerName;

    /**
     * 回访标识：0-未回访 1-已回访 2-无法回访
     */
    @Field(type = FieldType.INTEGER)
    private Integer visitorStateId;

    /**
     * 删除标识
     */
    @Field(type = FieldType.INTEGER)
    private Integer deleteFlag;

    /**
     * 删除用户标识
     */
    @Field(type = FieldType.INTEGER)
    private Integer deleteUserId;

    /**
     * 删除时间
     */
    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String deleteTime;

    /**
     * 是否下发督查
     * 0：否，1：是
     */
    @Field(type = FieldType.INTEGER)
    private Integer overseerFlag;

    @Field(type = FieldType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String updateTime;

    @Field(type = FieldType.OBJECT)
    private EsAct act;

}
