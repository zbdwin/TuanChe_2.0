package com.bwf.framwork.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class FactorResultBean implements Parcelable{

    public List<SeriesBean> series ;

    public List<LevleBean> levle ;

    public List<BosBean> bos ;

    @Override
    public String toString() {
        return "FactorResultBean{" +
                "series=" + series +
                ", levle=" + levle +
                ", bos=" + bos +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.series);
        dest.writeList(this.levle);
        dest.writeList(this.bos);
    }

    public FactorResultBean() {
    }

    protected FactorResultBean(Parcel in) {
        this.series = new ArrayList<SeriesBean>();
        in.readList(this.series, SeriesBean.class.getClassLoader());
        this.levle = new ArrayList<LevleBean>();
        in.readList(this.levle, LevleBean.class.getClassLoader());
        this.bos = new ArrayList<BosBean>();
        in.readList(this.bos, BosBean.class.getClassLoader());
    }

    public static final Creator<FactorResultBean> CREATOR = new Creator<FactorResultBean>() {
        @Override
        public FactorResultBean createFromParcel(Parcel source) {
            return new FactorResultBean(source);
        }

        @Override
        public FactorResultBean[] newArray(int size) {
            return new FactorResultBean[size];
        }
    };
}
