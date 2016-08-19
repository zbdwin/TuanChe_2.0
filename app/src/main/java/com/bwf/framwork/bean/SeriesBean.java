package com.bwf.framwork.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 2016/8/17.
 */
public class SeriesBean implements Parcelable{

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.icon);
        dest.writeString(this.name);
        dest.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
    }

    public SeriesBean() {
    }

    protected SeriesBean(Parcel in) {
        this.id = in.readString();
        this.icon = in.readString();
        this.name = in.readString();
        this.isSelected = in.readByte() != 0;
    }

    public static final Creator<SeriesBean> CREATOR = new Creator<SeriesBean>() {
        @Override
        public SeriesBean createFromParcel(Parcel source) {
            return new SeriesBean(source);
        }

        @Override
        public SeriesBean[] newArray(int size) {
            return new SeriesBean[size];
        }
    };
}
