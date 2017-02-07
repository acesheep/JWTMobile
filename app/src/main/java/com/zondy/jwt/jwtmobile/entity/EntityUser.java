package com.zondy.jwt.jwtmobile.entity;


import java.io.Serializable;

public class EntityUser implements Serializable{
    private String userId;// 用户id
    private String userName;//用户登陆名
    private String password;// 登陆密码
    private String usertype;//用户类型
    private String zzjgdm;//组织机构代码
    private String zzjgmc;//组织机构名称
    private String ctname;//用户中文名
    private String carid;//车id
    private String phone;//电话
    private String roleId;//权限id
    private String ssxq;//所属辖区代码
    private String timeInterval;//定位时间间隔
    private String distanceInterval;//定位距离间隔

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }

    public String getZzjgmc() {
        return zzjgmc;
    }

    public void setZzjgmc(String zzjgmc) {
        this.zzjgmc = zzjgmc;
    }

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getSsxq() {
        return ssxq;
    }

    public void setSsxq(String ssxq) {
        this.ssxq = ssxq;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getDistanceInterval() {
        return distanceInterval;
    }

    public void setDistanceInterval(String distanceInterval) {
        this.distanceInterval = distanceInterval;
    }
}
