package com.bwf.tuanche.car_select.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwf.framwork.bean.StyleList;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.car_select.adapter.MyPopHotAndPriceAdapter;
import com.bwf.tuanche.homepage.entity.TuanChe_TopBr;
import com.bwf.tuanche.tuancheDetial.TuanDetialActivity;

import java.util.List;

/**
 * Created by admin on 2016/8/19.
 */
public class PopWindow_Hot_Price extends PopupWindow implements View.OnClickListener{

    private Context context;
    private String brandId;

    private TextView tv_pop_brand,tv_pop_hot,tv_pop_price;
    private ListView lv_hot_and_price;
    private MyPopHotAndPriceAdapter adapter;
    private List<StyleList.ResultBeanList> styleList;

    public PopWindow_Hot_Price(Context context,String brandId){
        super(context);
        this.context = context;
        this.brandId = brandId;
        init(context);
    }

    public void init(final Context context){
        View view = View.inflate(context, R.layout.select_pop_hotandprice_layout,null);
        //PopWindow设置
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setAnimationStyle(R.style.PopupWindowAnimation);//设置popWindow动画
        this.setOutsideTouchable(true);

        tv_pop_brand = (TextView) view.findViewById(R.id.tv_pop_brand);
        tv_pop_hot = (TextView) view.findViewById(R.id.tv_pop_hot);
        tv_pop_price = (TextView) view.findViewById(R.id.tv_pop_price);
        lv_hot_and_price = (ListView) view.findViewById(R.id.lv_hot_and_price);
        getDatas("0");
        lv_hot_and_price.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putString("id", styleList.get(i).id);
                bundle.putString("name", styleList.get(i).styleName);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                IntentUtils.openActivity(context, TuanDetialActivity.class, bundle);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        tv_pop_hot.setOnClickListener(this);
        tv_pop_price.setOnClickListener(this);
    }


    //获取根据车品牌获取车列表
    public void getDatas(String type){
        HttpHelper.getDetailByPingpai(type, "156", brandId, new HttpArrayCallBack<StyleList>() {
            @Override
            public void onSuccess(List<StyleList> result) {
                if (result != null && !result.isEmpty()) {
                    styleList = result.get(0).styleList;
                    tv_pop_brand.setText(result.get(0).brandName);
                    adapter = new MyPopHotAndPriceAdapter(context);
                    adapter.setDatas(result.get(0).styleList);
                    adapter.notifyDataSetChanged();
                    lv_hot_and_price.setAdapter(adapter);
                }
            }

            @Override
            public void onFail(String errMsg) {
                Log.e("zbd",errMsg);
            }
        });

    }

    /*显示popwindow
    * */
    public void showPopWindow(View view){
        if (!isShowing()){
            showAsDropDown(view);
//            this.showAtLocation(view, Gravity.TOP,0,0);//可以显示在指定view的指定位置
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.tv_pop_hot://热门
                tv_pop_price.setTextColor(Color.BLACK);
                tv_pop_hot.setTextColor(Color.RED);
                getDatas("0");
                break;
            case R.id.tv_pop_price://价格
                tv_pop_hot.setTextColor(Color.BLACK);
                tv_pop_price.setTextColor(Color.RED);
                getDatas("1");
            break;

        }
    }
}
