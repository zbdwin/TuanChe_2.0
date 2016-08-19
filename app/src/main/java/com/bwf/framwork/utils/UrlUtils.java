package com.bwf.framwork.utils;

/**
 * Created by Lizhangfeng on 2016/7/19 0019.
 * Description:
 */
public class UrlUtils {

    public static final String BASE_URL = "http://123.56.145.151:8080";
    //购车流程
    public static final String BUY_CAR_LIUCHENG=BASE_URL+"/TuanCheNetWork/bwf_TuanChe_BuyInfoNogroupServlet";
    //购车评价
    public static final String BUY_CAR_PINGJIA=BASE_URL+"/TuanCheNetWork/bwf_TuanChe_BuyInfoEvaluateServlet";
    //常见问题
    public static final String BUY_CAR_QUESTION=BASE_URL+"/TuanCheNetWork/bwf_TuanChe_BuyInfoQuestionServlet";
    //汽车详情
    public static final String BUY_CAR_DETIAL=BASE_URL+"/TuanCheNetWork/bwf_TuanChe_BuyInfoServlet";
    //根据车品牌获取车列表
    public static final String BUY_CAR_DETIAL_PINGPAILIEBIAO=BASE_URL+"/TuanCheNetWork/bwf_TuanChe_BrandCarStyleServlet";

}
