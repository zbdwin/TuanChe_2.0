package com.bwf.framwork.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 2016/8/20.
 */
public class CityBean implements Parcelable,Comparable<CityBean>{

    //            "id": 10,
//            "name": "北京",
//            "province": "直辖市",
//            "pinyin": "beijing",
//            "pname": "直辖市",
//            "py": "bj",
//            "openStatus": 1
    public String id;

    public String name;

    public String province;

    public String pinyin;

    public String pname;

    public String py;

    public String openStatus;

    public String separator;

    public CityBean(String separator,String name) {
        this.separator = separator;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CityBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", pname='" + pname + '\'' +
                ", py='" + py + '\'' +
                ", openStatus='" + openStatus + '\'' +
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
        dest.writeString(this.province);
        dest.writeString(this.pinyin);
        dest.writeString(this.pname);
        dest.writeString(this.py);
        dest.writeString(this.openStatus);
    }

    public CityBean() {
    }

    protected CityBean(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.province = in.readString();
        this.pinyin = in.readString();
        this.pname = in.readString();
        this.py = in.readString();
        this.openStatus = in.readString();
    }

    public static final Parcelable.Creator<CityBean> CREATOR = new Parcelable.Creator<CityBean>() {
        @Override
        public CityBean createFromParcel(Parcel source) {
            return new CityBean(source);
        }

        @Override
        public CityBean[] newArray(int size) {
            return new CityBean[size];
        }
    };

    @Override
    public int compareTo(CityBean obj) {
        if ( obj.py.charAt(0) < this.py.charAt(0))
            return 1;
        else if (obj.py.charAt(0) > this.py.charAt(0))
            return -1;
        else
            return 0;
    }
}
