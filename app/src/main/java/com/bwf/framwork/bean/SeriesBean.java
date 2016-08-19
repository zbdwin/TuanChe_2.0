package com.bwf.framwork.bean;

/**
 * Created by admin on 2016/8/17.
 */
public class SeriesBean {

    public String id;

    public String icon;

    public String name;

    public boolean isSelected;

    @Override
    public String toString() {
        return "SeriesBean{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
