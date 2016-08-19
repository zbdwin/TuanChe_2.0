package com.bwf.tuanche.tuancheDetial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.bean.CarDetialResultBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.tuancheDetial.detialAdapter.DetialBuyCarPingjiaAdapter;

public class DetialMorePingjiaActivity extends BaseActivity {
    private DetialBuyCarPingjiaAdapter adapter;
    private ListView lv_buy_car_pingjia;
    private ImageView iv_back1;

    @Override
    public int getContentViewId() {
        return R.layout.activity_detial_more_pingjia;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        lv_buy_car_pingjia=findViewByIdNoCast(R.id.lv_buy_car_pingjia);
        iv_back1=findViewByIdNoCast(R.id.iv_back1);
    }

    @Override
    public void initData() {
        setOnClick(iv_back1);
        adapter = new DetialBuyCarPingjiaAdapter(this);
        lv_buy_car_pingjia.setAdapter(adapter);
        getData();

    }
    public void getData(){
        HttpHelper.getDetailBuyCarPingjia("10","1", "156", "31", new HttpCallBack<CarDetialResultBean>() {
            @Override
            public void onSuccess(CarDetialResultBean result) {
                if (result!=null){
                    if (result.commentList!=null){
                        adapter.settList(result.commentList);
                        ListViewUtils.measureListViewHeight(lv_buy_car_pingjia);
                        adapter.notifyDataSetChanged();
                    }


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
                IntentUtils.openActivity(DetialMorePingjiaActivity.this,TuanDetialActivity.class);
            break;
        }

    }
}
