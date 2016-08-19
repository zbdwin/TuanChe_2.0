package com.bwf.framwork.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.StringUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Lizhangfeng on 2016/8/16 0016.
 * Description: http回调
 */
public abstract class HttpCallBackArray<T> extends StringCallback {

    private Class<T> tClass;

    public HttpCallBackArray() {
        tClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        onFail("网络异常");
    }

    @Override
    public void onResponse(String response, int id) {

        if (StringUtils.isNotEmpty(response)) {

            LogUtils.e("服务器返回结果: " + response);

            try {

                BaseBean baseBean = JSON.parseObject(response, BaseBean.class);
                if ("10000".equals(baseBean.code)) {
                    if (StringUtils.isNotEmpty(baseBean.result))
                        onSuccess(JSON.parseArray(baseBean.result, tClass));
                    else
                        onFail("result is empty");

                } else {
                    onFail(baseBean.msg);
                }
            } catch (JSONException e) {
                onFail("解析异常");
            }


        } else
            onFail("服务器返回内容为空");

    }

    public abstract void onSuccess(List<T> result);

    public abstract void onFail(String errMsg);

}
