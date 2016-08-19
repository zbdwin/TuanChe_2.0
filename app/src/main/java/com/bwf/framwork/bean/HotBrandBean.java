package com.bwf.framwork.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 2016/8/17.
 */
public class HotBrandBean {

    public String id;

    public String name;

    public String logo;

    public String baseNum;

    public String modelType;


    @Override
    public String toString() {
        return "HotBrandBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", baseNum=" + baseNum +
                ", modelType=" + modelType +
                '}';
    }
}
