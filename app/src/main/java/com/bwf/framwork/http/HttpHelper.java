package com.bwf.framwork.http;


import com.bwf.framwork.http.request.HotCarTypeRequest;
import com.bwf.framwork.utils.UrlUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {

    //根据经纬度定位城市
    public static void getCityLocation(String longitude,String latitude,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(UrlUtils.LOCATE_CITY_BY_LONGITUDE_AND_LATITUDE)
                .addParams("longitude", longitude)
                .addParams("latitude", latitude)
                .build()
                .execute(callBack);
    }

    //获取城市列表
    public static void getCityList(String pageSize,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(UrlUtils.LOCATE_CITY_CITY_LIST)
                .addParams("pageSize", pageSize)
                .build()
                .execute(callBack);
    }

    //品牌选车--热门
    public static void getHotBrandDatas(String url,String isbBuy,String cityId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("isBuy", isbBuy)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }


    //品牌选车--列表
    public static void getListBrandDatas(String url,String cityId,HttpArrayCallBack callBack){

        OkHttpUtils
                .post()
                .url(url)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

    /**
     * 购车评价
     *
     */
    public static void getDetailBuyCarPingjia(String count,String offset,String cityId,String brandId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(UrlUtils.BUY_CAR_PINGJIA)
                .addParams("count",count)
                .addParams("offset",offset)
                .addParams("cityId",cityId)
                .addParams("brandId",brandId)
                .build()
                .execute(callBack);
    }
    /**
     * 购车详情
     *
     */
    public static void getDetailBuyCarDetial(String styleId,String cityId,String brandId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(UrlUtils.BUY_CAR_DETIAL)
                .addParams("styleId",styleId)
                .addParams("cityId",cityId)
                .addParams("brandId",brandId)
                .build()
                .execute(callBack);
    }
    /**
     * 根据车品牌获取车列表
     *
     */
    public static void getDetailByPingpai(String type,String cityId,String brandId,HttpArrayCallBack callBack){
        OkHttpUtils
                .post()
                .url(UrlUtils.LIST_HOT_AND_PRICE_DATA_BY_BRAND)
                .addParams("type",type)
                .addParams("cityId",cityId)
                .addParams("brandId",brandId)
                .build()
                .execute(callBack);
    }


     /* 1
     * 首页topBrand
     * 接口地址：bwf_TuanChe_HomeServlet
     * 请求参数：
     * cityId： 城市Id
     */


    //条件选车--级别/国别/排量
    public static void getFactorDatas(String url,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .build()
                .execute(callBack);
    }

    //热门车型
    public static void getHotTypeDatas(String url, String cityId, HotCarTypeRequest request, HttpArrayCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("count", request.count+"")
                .addParams("offset", request.offset+"")
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }

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

    /**
     *
     * 18、婚姻座驾
     接口地址：bwf_TuanChe_AdplistServlet
     *
     *
     */
    public static void getAdplistServlet( HttpCallBack callBack) {
        OkHttpUtils
                .get()
                .url(UrlUtils.ADALISTSERVLET)
                .build()
                .execute(callBack);
    }


    /**
     *  /**
     * 1
     6、汽车—热门搜索
     接口地址：bwf_TuanChe_SearchhotServlet

     */

    public static void getSearchhotServlet( String cityId,StringCallback callBack) {
        OkHttpUtils
                .get()
                .addParams("cityId",cityId)
                .url(UrlUtils.SEARCHHOTSERVLET)
                .build()
                .execute(callBack);
    }
/*

19、版本更新
接口地址：bwf_TuanChe_VersionUpadteServlet
 */
public static void getVersionUpadteServlet( HttpCallBack callBack) {
    OkHttpUtils
            .post()
            .url(UrlUtils.VERSIONUPADTESERVLET)
            .build()
            .execute(callBack);
}
}
