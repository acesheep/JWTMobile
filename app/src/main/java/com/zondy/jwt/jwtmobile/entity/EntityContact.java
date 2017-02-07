package com.zondy.jwt.jwtmobile.entity;

import com.mcxtzhang.indexlib.IndexBar.bean.BaseIndexPinyinBean;

/**
 * Created by sheep on 2017/1/12.
 */

public class EntityContact extends BaseIndexPinyinBean{
    String jh;
    String xm;
    String dh;
    String ssdw;
    String pssdw;
    String ssdwmc;
    String zw;
    String id;

    public EntityContact() {

    }

    public EntityContact(String xm, String dh) {
        this.xm = xm;
        this.dh = dh;
    }

    public EntityContact(String jh, String xm, String dh, String ssdw, String ssdwmc, String pssdw, String zw, String id) {
        this.jh = jh;
        this.xm = xm;
        this.dh = dh;
        this.ssdw = ssdw;
        this.ssdwmc = ssdwmc;
        this.pssdw = pssdw;
        this.zw = zw;
        this.id = id;
    }

    public String getJh() {
        return jh;
    }

    public void setJh(String jh) {
        this.jh = jh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public String getSsdwmc() {
        return ssdwmc;
    }

    public void setSsdwmc(String ssdwmc) {
        this.ssdwmc = ssdwmc;
    }

    public String getPssdw() {
        return pssdw;
    }

    public void setPssdw(String pssdw) {
        this.pssdw = pssdw;
    }

    public String getSsdw() {
        return ssdw;
    }

    public void setSsdw(String ssdw) {
        this.ssdw = ssdw;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    @Override
    public String getTarget() {
        return xm;
    }
}
