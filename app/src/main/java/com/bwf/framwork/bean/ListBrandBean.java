package com.bwf.framwork.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 2016/8/17.
 */
public class ListBrandBean implements Parcelable{

    public String id;

    public String penname;

    public String logo;

    public String name;

    public String baseNum;

    public String pinyin;

    public String separator;

    public ListBrandBean(String separator){
        this.separator = separator;
    }

    public ListBrandBean(){

    }

    public ListBrandBean(String penname,String name){
        this.name = name;
        this.penname = penname;
    }

    @Override
    public String toString() {
        return "ListBrandBean{" +
                "id=" + id +
                ", pinyin='" + pinyin + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", baseNum=" + baseNum +
                ", penname='" + penname + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.pinyin);
        dest.writeString(this.name);
        dest.writeString(this.logo);
        dest.writeString(this.baseNum);
        dest.writeString(this.penname);
        dest.writeString(this.separator);
    }

    protected ListBrandBean(Parcel in) {
        this.id = in.readString();
        this.pinyin = in.readString();
        this.name = in.readString();
        this.logo = in.readString();
        this.baseNum = in.readString();
        this.penname = in.readString();
        this.separator = in.readString();
    }

    public static final Creator<ListBrandBean> CREATOR = new Creator<ListBrandBean>() {
        @Override
        public ListBrandBean createFromParcel(Parcel source) {
            return new ListBrandBean(source);
        }

        @Override
        public ListBrandBean[] newArray(int size) {
            return new ListBrandBean[size];
        }
    };
}
