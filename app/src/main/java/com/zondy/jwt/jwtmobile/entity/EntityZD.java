package com.zondy.jwt.jwtmobile.entity;

import com.mcxtzhang.indexlib.IndexBar.bean.BaseIndexPinyinBean;

import java.io.Serializable;

/**
 * Created by sheep on 2017/1/17.
 */

public class EntityZD extends BaseIndexPinyinBean implements Serializable {

        private static final long serialVersionUID = 1L;
        String bm;
        String mc;
        String pid;
        public String getBm() {
            return bm;
        }
        public void setBm(String bm) {
            this.bm = bm;
        }
        public String getMc() {
            return mc;
        }
        public void setMc(String mc) {
            this.mc = mc;
        }
        public String getPid() {
            return pid;
        }
        public void setPid(String pid) {
            this.pid = pid;
        }
        public EntityZD(String bm, String mc, String pid) {
            super();
            this.bm = bm;
            this.mc = mc;
            this.pid = pid;
        }
        public EntityZD() {
            super();
        }

    @Override
    public String getTarget() {
        return mc;
    }
}

