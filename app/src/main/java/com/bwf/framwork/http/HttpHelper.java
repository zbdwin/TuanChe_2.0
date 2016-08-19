package com.bwf.framwork.http;


import com.bwf.framwork.utils.UrlUtils;
import com.zhy.http.okhttp.OkHttpUtils;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {


    public static void getDetail(String url, String pageNo, String pageSize, HttpCallBack callBack) {
        OkHttpUtils
                .post()
                .url(url)
                .addParams("pageNo", pageNo)
                .addParams("pageSize", pageSize)
                .build()
                .execute(callBack);
    }

    /**
     * 1
     * 、首页topBrand
     * 接口地址：bwf_TuanChe_HomeServlet
     * 请求参数：
     * cityId： 城市Id
     */

    public static void getTopBrand(String cityId, HttpCallBack callBack) {
        OkHttpUtils
                .post()
                .url(UrlUtils.TOPBRAND)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    /**
     * 5、热门品牌
     接口地址：bwf_TuanChe_TopBr
     请求参数：
     isBuy：此处传“2”
     cityId：城市Id
     */
    public static void getTuanChe_TopBr(String isBuy,String cityId, HttpCallBack callBack) {
        OkHttpUtils
                .post()
                .url(UrlUtils.HOTSTYLE)
                .addParams("isBuy", isBuy)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }
/**
 * 6、首页Banner
 接口地址：bwf_TuanChe_BannerServlet
 请求参数：
 cityId：城市Id
 */

public static void getBannerServlet(String cityId, HttpCallBack callBack) {
    OkHttpUtils
            .get()
            .url(UrlUtils.BANNERSERVLET)
            .addParams("cityId", cityId)
            .build()
            .execute(callBack);
}

    /**
     * 3
     、热门车型
     接口地址：bwf_TuanChe_Hotstyle
     请求参数：
     count： “2” 一行显示个数
     offset： “0” 页数
     cityId：城市Id
     HotstyleRoot
     */


    public static void getBannerHotstyle(String count,String offset,String cityId, HttpCallBackArray callBack) {
        OkHttpUtils
                .post()
                .url(UrlUtils.TUANCHE_HOTSTYLE)
                .addParams("count", count)
                .addParams("offset", offset)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }
}
