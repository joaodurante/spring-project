package com.joaodurante.springproject.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

public class StandardError implements Serializable {
    private Integer status;
    private String msg;
    private Long timeStamp;

    public StandardError(Integer status, String msg, Long timeStamp) {
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    public void setStatus(Integer status) { this.status = status; }
    public void setMsg(String msg) { this.msg = msg; }
    public void setTimeStamp(Long timeStamp) { this.timeStamp = timeStamp; }

    public Integer getStatus() { return status; }
    public String getMsg() { return msg; }
    public Long getTimeStamp() { return timeStamp; }
}
