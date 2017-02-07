package com.zondy.jwt.jwtmobile.entity;

/**
 * Created by sheep on 2016/12/28.
 */

public class EntitySearchResult {
    private int imageResourceID;
    private String mc;
    private String dz;
    private String distance;
    private String rs;

    public EntitySearchResult() {

    }
    public EntitySearchResult(String mc, int imageResourceID, String dz, String jl, String rs) {
        this.mc = mc;
        this.imageResourceID = imageResourceID;
        this.dz = dz;
        this.distance = jl;
        this.rs = rs;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }
}
