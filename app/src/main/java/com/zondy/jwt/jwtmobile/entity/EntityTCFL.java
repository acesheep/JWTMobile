package com.zondy.jwt.jwtmobile.entity;

/**
 * Created by sheep on 2017/1/19.
 */

public class EntityTCFL {
    private int id;
    private int layerid;
    private String layername;
    private String mc;
    private int parentid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public int getLayerid() {
        return layerid;
    }

    public void setLayerid(int layerid) {
        this.layerid = layerid;
    }

    public String getLayername() {
        return layername;
    }

    public void setLayername(String layername) {
        this.layername = layername;
    }
}
