package com.bwf.framwork.http;


import com.zhy.http.okhttp.OkHttpUtils;

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

}
