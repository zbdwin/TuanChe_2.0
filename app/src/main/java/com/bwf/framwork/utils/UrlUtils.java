package com.bwf.framwork.utils;

/**
 * Created by Lizhangfeng on 2016/7/19 0019.
 * Description:
 */
public class UrlUtils {


    //服务器地址
    public static final String BASE_URL = "http://123.56.145.151:8080/TuanCheNetWork/";

    //热门车型
    public static final String HOT_CAR_TYPE = BASE_URL+"bwf_TuanChe_Hotstyle";

    //热门品牌
    public static final String SELECT_HOT_CAR_BRAND = BASE_URL+"bwf_TuanChe_TopBrand";

    //品牌选车-列表
    public static final String SELECT_LIST_CAR_BRAND = BASE_URL+"bwf_TuanChe_XuanbrandmapServlet";

    //条件选车--级别/国别/排量
    public static final String SELECT_CAR_FACTOR = BASE_URL+"bwf_TuanChe_SelectCarInfosServlet";


    public static final String   SIMPLEDRAWEEVIEW = "http://pic.tuanche.com/ams/20160215/14555012465214662.png";
    /**
     *
     * 低价购车
     * 1
     、首页topBrand
     接口地址：bwf_TuanChe_HomeServlet
     */
    public static final String   TOPBRAND =BASE_URL+ "bwf_TuanChe_HomeServlet";

    /**
     * 3
     、热门车型
     接口地址：bwf_TuanChe_TopBrand
     */

    public static final String   HOTSTYLE =BASE_URL+ "bwf_TuanChe_TopBrand";

    /**
     * 6、首页Banner
     接口地址：bwf_TuanChe_BannerServlet
     请求参数：
     cityId：城市Id
     */
    public static final String   BANNERSERVLET =BASE_URL+ "bwf_TuanChe_BannerServlet";
    /**
     * 3
     、热门车型
     接口地址：bwf_TuanChe_Hotstyle
     请求参数：
     count： “2” 一行显示个数
     offset： “0” 页数
     cityId：城市Id
     */
    public static final String   TUANCHE_HOTSTYLE =BASE_URL+ "bwf_TuanChe_Hotstyle";
}
