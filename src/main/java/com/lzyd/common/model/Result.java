package com.lzyd.common.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
  private boolean flag; // 是否成功
  private Integer code; // 返回码
  private String msg; // 返回消息
  private T data; // 返回数据

  public Result(boolean flag, Integer code, String msg, Object data) {
    this.flag = flag;
    this.code = code;
    this.msg = msg;
    this.data = (T) data;
  }

  public Result(boolean flag, Integer code, String msg) {
    this.flag = flag;
    this.code = code;
    this.msg = msg;
  }

  public Result() {
    this.flag = true;
    this.code = StatusCode.OK;
    this.msg = "操作成功!";
  }
}
