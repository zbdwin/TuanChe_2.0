package com.bwf.tuanche.tuancheDetial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.bean.CarDetialResultBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.tuancheDetial.detialAdapter.DetialBuyCarPingjiaAdapter;
import com.bwf.tuanche.tuancheDetial.myview.MyListView;

public class DetialMorePingjiaActivity extends BaseActivity {
    private DetialBuyCarPingjiaAdapter adapter;
    private MyListView lv_buy_car_pingjia;
    private ImageView iv_back1;
    private TextView tv_allpingjia,tv_price,tv_tuanzhang,tv_4sserver;
    private RatingBar ratingBar;
    private ScrollView scrollview2;
    private String brandId;

    @Override
    public int getContentViewId() {
        return R.layout.activity_detial_more_pingjia;
    }

    @Override
    public void beforeInitView() {
        brandId=getIntent().getStringExtra("brandId");

    }

    @Override
    public void initView() {
        lv_buy_car_pingjia=findViewByIdNoCast(R.id.lv_buy_car_pingjia);
        iv_back1=findViewByIdNoCast(R.id.iv_back1);
        tv_allpingjia=findViewByIdNoCast(R.id.tv_allpingjia);
        tv_price=findViewByIdNoCast(R.id.tv_price);
        tv_tuanzhang=findViewByIdNoCast(R.id.tv_tuanzhang);
        tv_4sserver=findViewByIdNoCast(R.id.tv_4sserver);
        ratingBar=findViewByIdNoCast(R.id.ratingbar1);
        scrollview2=findViewByIdNoCast(R.id.scrollview2);

    }

    @Override
    public void initData() {
        setOnClick(iv_back1);
        adapter = new DetialBuyCarPingjiaAdapter(this);
        lv_buy_car_pingjia.setAdapter(adapter);
        ListViewUtils.measureListViewHeight(lv_buy_car_pingjia);
        getData();
        scrollview2.smoothScrollTo(0,20);

    }
    public void getData(){
        showProgressbar();
        HttpHelper.getDetailBuyCarPingjia("10","1", "156", brandId, new HttpCallBack<CarDetialResultBean>() {
            @Override
            public void onSuccess(CarDetialResultBean result) {
                if (result!=null){
                    String price="价格 <font color='#ff7f00'>"+result.priceScore+"分"+"</font>";
                    tv_price.setText(Html.fromHtml(price));
                    String price1="团长服务 <font color='#ff7f00'>"+result.salerScore+"分"+"</font>";
                    tv_tuanzhang.setText(Html.fromHtml(price1));
                    String price2="4S店服务 <font color='#ff7f00'>"+result.shopScore+"分"+"</font>";
                    tv_4sserver.setText(Html.fromHtml(price2));
                    tv_allpingjia.setText(result.commentTotal+"分");
                    ratingBar.setRating(Float.parseFloat(result.commentTotal));
                    if (result.commentList!=null){
                        adapter.settList(result.commentList);
                        scrollview2.scrollTo(0,0);
                        adapter.notifyDataSetChanged();
                    }
                  dissmissProgressbar();

                }
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back1:
                finish();
            break;
        }

    }
}
