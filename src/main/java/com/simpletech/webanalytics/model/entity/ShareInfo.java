package com.simpletech.webanalytics.model.entity;

import java.util.Date;

/**
 * main.model
 * Created by ChenQi on 2016/1/8 11:34.
 */
public class ShareInfo {
    private String id;
    private int idsite;
    private String idsubsite;
    private String idurl;
    private String idvisitor;
    private String idrefervisitor;
    private Boolean isStartPoint;
    private String province;
    private String city;
    private String headImgUrl;
    private String nickName;
    private String sex;
    private String shareTo;
    private int countPv;
    private Date shareTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdsite() {
        return idsite;
    }

    public void setIdsite(int idsite) {
        this.idsite = idsite;
    }

    public String getIdsubsite() {
        return idsubsite;
    }

    public void setIdsubsite(String idsubsite) {
        this.idsubsite = idsubsite;
    }

    public String getIdurl() {
        return idurl;
    }

    public void setIdurl(String idurl) {
        this.idurl = idurl;
    }

    public String getIdvisitor() {
        return idvisitor;
    }

    public void setIdvisitor(String idvisitor) {
        this.idvisitor = idvisitor;
    }

    public String getIdrefervisitor() {
        return idrefervisitor;
    }

    public void setIdrefervisitor(String idrefervisitor) {
        this.idrefervisitor = idrefervisitor;
    }

    public int getCountPv() {
        return countPv;
    }

    public void setCountPv(int countPv) {
        this.countPv = countPv;
    }

    public Date getShareTime() {
        return shareTime;
    }

    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getShareTo() {
        return shareTo;
    }

    public void setShareTo(String shareTo) {
        this.shareTo = shareTo;
    }

    public Boolean getIsStartPoint() {
        return isStartPoint;
    }

    public void setIsStartPoint(Boolean isStartPoint) {
        this.isStartPoint = isStartPoint;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
