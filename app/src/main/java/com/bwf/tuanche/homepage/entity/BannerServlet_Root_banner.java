package com.bwf.tuanche.homepage.entity;

import java.util.List;

/**
 * Created by wanli on 2016/8/18.
 * Description:
 */
public class BannerServlet_Root_banner {
    public List<BannerServlet_Root> header_banner;
    private  List<BannerServlet_center_banner> center_banner;
    private List<BannerServlet_position_banner> position_banner;

    @Override
    public String toString() {
        return "BannerServlet_Root_banner{" +
                "header_banner=" + header_banner +
                ", center_banner=" + center_banner +
                ", position_banner=" + position_banner +
                '}';
    }
}
