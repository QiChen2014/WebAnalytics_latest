package com.simpletech.webanalytics.model.entity;

/**
 * ����ͳ��ֵ
 * Created by ���b on 2015/9/29.
 */
public class RankingValue {

    private String name;        //��������
    private String remark;      //���б�ע
    private int uv;             //�����û���
    private int vt;             //visit ��
    private int pv;             //pv ��
    private int ip;             //pv ��
    private float ruv;          //�����û� ռ��
    private float rvt;          //visit ռ��
    private float rpv;          //pv ռ��
    private float rip;          //ip ռ��

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getUv() {
        return uv;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }

    public int getVt() {
        return vt;
    }

    public void setVt(int vt) {
        this.vt = vt;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public float getRuv() {
        return ruv;
    }

    public void setRuv(float ruv) {
        this.ruv = ruv;
    }

    public float getRvt() {
        return rvt;
    }

    public void setRvt(float rvt) {
        this.rvt = rvt;
    }

    public float getRpv() {
        return rpv;
    }

    public void setRpv(float rpv) {
        this.rpv = rpv;
    }

    public float getRip() {
        return rip;
    }

    public void setRip(float rip) {
        this.rip = rip;
    }
}
