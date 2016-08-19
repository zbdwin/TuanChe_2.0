package com.bwf.framwork.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 2016/8/17.
 */
public class BosBean implements Parcelable{

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.icon);
        dest.writeString(this.name);
        dest.writeString(this.defIcon);
        dest.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
    }

    public BosBean() {
    }

    protected BosBean(Parcel in) {
        this.id = in.readString();
        this.icon = in.readString();
        this.name = in.readString();
        this.defIcon = in.readString();
        this.isSelected = in.readByte() != 0;
    }

    public static final Creator<BosBean> CREATOR = new Creator<BosBean>() {
        @Override
        public BosBean createFromParcel(Parcel source) {
            return new BosBean(source);
        }

        @Override
        public BosBean[] newArray(int size) {
            return new BosBean[size];
        }
    };
}
