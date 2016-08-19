package com.bwf.framwork.bean;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class FactorResultBean {

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
}
