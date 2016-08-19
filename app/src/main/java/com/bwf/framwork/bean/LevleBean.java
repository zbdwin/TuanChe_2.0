package com.bwf.framwork.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 2016/8/17.
 */
public class LevleBean implements Parcelable{

    public String id;

    public String name;

    public boolean isSelected;

    @Override
    public String toString() {
        return "LevleBean{" +
                "id='" + id + '\'' +
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
        dest.writeString(this.name);
        dest.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
    }

    public LevleBean() {
    }

    protected LevleBean(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.isSelected = in.readByte() != 0;
    }

    public static final Creator<LevleBean> CREATOR = new Creator<LevleBean>() {
        @Override
        public LevleBean createFromParcel(Parcel source) {
            return new LevleBean(source);
        }

        @Override
        public LevleBean[] newArray(int size) {
            return new LevleBean[size];
        }
    };
}
