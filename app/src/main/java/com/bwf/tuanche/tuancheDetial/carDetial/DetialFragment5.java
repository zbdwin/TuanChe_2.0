package com.bwf.tuanche.tuancheDetial.carDetial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.bean.CarDetialResultBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.tuancheDetial.DetialMorePingjiaActivity;
import com.bwf.tuanche.tuancheDetial.TuanDetialActivity;
import com.bwf.tuanche.tuancheDetial.detialAdapter.DetialBuyCarPingjiaAdapter;
import com.bwf.tuanche.tuancheDetial.myview.MyListView;

/**
 *购车评价
 */
public class DetialFragment5 extends BaseFragment {
    private MyListView lv_buy_car_pingjia;
    private TextView tv_all_pingjia,tv_zhongfeng;
   private CarDetialResultBean result;
    private RatingBar ratingBar;
    private MyText text;

    public void setResult(CarDetialResultBean result) {
        this.result = result;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_detial_fragment5;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        lv_buy_car_pingjia=findViewByIdNoCast(R.id.lv_buy_car_pingjia);
        tv_all_pingjia=findViewByIdNoCast(R.id.tv_all_pingjia);
        ratingBar=findViewByIdNoCast(R.id.ratingbar);
        tv_zhongfeng=findViewByIdNoCast(R.id.tv_zhongfeng);

    }

    @Override
    protected void initData() {
        setOnClick(R.id.tv_all_pingjia);
        if (result!=null){
            tv_all_pingjia.setText("查看全部"+result.count+"条评价");
            tv_zhongfeng.setText(result.commentTotal+"分");
            float f=Float.parseFloat(result.commentTotal);
            ratingBar.setRating(f);
            DetialBuyCarPingjiaAdapter adapter = new DetialBuyCarPingjiaAdapter(getContext());
            if (result.commentList!=null){
                adapter.settList(result.commentList);
                lv_buy_car_pingjia.setAdapter(adapter);
                ListViewUtils.measureListViewHeight(lv_buy_car_pingjia);
                if (text!=null){
                    text.ontest();
                }
                adapter.notifyDataSetChanged();
            }


        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_all_pingjia:
                IntentUtils.openActivity(DetialFragment5.this.getContext(), DetialMorePingjiaActivity.class);
            break;
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context!=null && context instanceof TuanDetialActivity){
            text= (MyText) context;
        }
    }

    public interface MyText{
        void ontest();
    }
}
