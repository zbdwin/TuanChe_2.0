package com.bwf.framwork.bean;

import java.util.List;

/**
 * Created by admin on 2016/8/22.
 */
public class CityListBean {

    public List<CityBean> hotCitys;

    public List<CityBean> openCitys;

    @Override
    public String toString() {
        return "CityListBean{" +
                "hotCitys=" + hotCitys +
                ", openCitys=" + openCitys +
                '}';
    }
}
