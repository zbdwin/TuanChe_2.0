package com.bwf.framwork.http;


import com.bwf.framwork.utils.UrlUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {

    //品牌选车--热门
    public void getHotBrandDatas(String url,String isbBuy,String cityId,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("isBuy", isbBuy)
                .addParams("cityId", cityId)
                .build()
                .execute(callBack);
    }


    //品牌选车--列表
    public void getListBrandDatas(String url,String cityId,HttpArrayCallBack callBack){

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
                .url(UrlUtils.BUY_CAR_DETIAL_PINGPAILIEBIAO)
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
    public void getFactorDatas(String url,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .build()
                .execute(callBack);
    }

    //热门车型
    public void getHotTypeDatas(String url,String cityId,HttpArrayCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("count", "10")
                .addParams("offset", "0")
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
}
