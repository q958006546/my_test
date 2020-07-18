package com.lzyd.pay.model;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentInfo {
    private Integer id;

    private Integer userid;

    private Integer typeid;

    private String orderid;

    private Long price;

    private String source;

    private Integer state;

    private Date created;

    private Date updated;

    private String platformorderid;


}