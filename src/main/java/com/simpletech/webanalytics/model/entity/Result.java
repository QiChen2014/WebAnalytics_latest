package com.simpletech.webanalytics.model.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/1/21.
 */
public class Result {
    private String id;
    private List<IspValue> ispValue;
    private List<ErrorValue> errorValue;
    private int pv;
    private int uv;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<IspValue> getIspValue() {
        return ispValue;
    }

    public void setIspValue(List<IspValue> ispValue) {
        this.ispValue = ispValue;
    }

    public List<ErrorValue> getErrorValue() {
        return errorValue;
    }

    public void setErrorValue(List<ErrorValue> errorValue) {
        this.errorValue = errorValue;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getUv() {
        return uv;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }
}
