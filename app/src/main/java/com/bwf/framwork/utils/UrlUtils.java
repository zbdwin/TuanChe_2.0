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

}
