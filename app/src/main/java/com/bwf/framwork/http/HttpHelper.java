package com.bwf.framwork.http;


import com.bwf.framwork.utils.UrlUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {


    public static void getDetail(String url,String pageNo,String pageSize,HttpCallBack callBack){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("pageNo", pageNo)
                .addParams("pageSize", pageSize)
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


}
