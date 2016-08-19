package com.bwf.framwork.bean;

/**
 * Created by admin on 2016/8/17.
 */
public class BosBean {

    public String id;

    public String icon;

    public String name;

    public String defIcon;

    public boolean isSelected;

    @Override
    public String toString() {
        return "BosBean{" +
                "id='" + id + '\'' +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", defIcon='" + defIcon + '\'' +
                '}';
    }
}
