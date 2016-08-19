package com.bwf.tuanche.car_select;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.bean.FactorResultBean;
import com.bwf.framwork.bean.HotBrandResultBean;
import com.bwf.framwork.bean.ListBrandBean;
import com.bwf.framwork.bean.StyleList;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.car_select.fragment.SelectByBrand_Fragment;
import com.bwf.tuanche.car_select.fragment.SelectByFactor_Fragment;

import java.util.List;

public class CarSelectActivity extends BaseActivity {

    private View title_bar_select;
    private ImageView img_select_back;
    private Button btn_select_by_brand,btn_select_by_factor;

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private SelectByBrand_Fragment selectByBrand_Fragment;
    private SelectByFactor_Fragment selectByFactor_Fragment;


    @Override
    public int getContentViewId() {
        return R.layout.activity_car_select;
    }

    @Override
    public void beforeInitView() {
    }

    @Override
    public void initView() {
        title_bar_select = findViewById(R.id.title_bar_select);
        img_select_back = findViewByIdNoCast(R.id.img_select_back);
        btn_select_by_brand = findViewByIdNoCast(R.id.btn_select_by_brand);
        btn_select_by_factor = findViewByIdNoCast(R.id.btn_select_by_factor);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        selectByBrand_Fragment = new SelectByBrand_Fragment();
        selectByFactor_Fragment = new SelectByFactor_Fragment();
        fragmentTransaction.add(R.id.fragment_content, selectByBrand_Fragment);
        fragmentTransaction.commit();
        getDatas();
    }

    @Override
    public void initData() {
        setOnClick(R.id.img_select_back,R.id.btn_select_by_brand,R.id.btn_select_by_factor,R.id.img_select_back);
    }

    @Override
    public void onClick(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch(view.getId()){
            case R.id.img_select_back://返回
                IntentUtils.openActivity(this, MainActivity.class);
            break;
            case R.id.btn_select_by_brand://品牌选车(品牌选车选中，条件选车隐藏)
                fragmentTransaction.replace(R.id.fragment_content,selectByBrand_Fragment);
                btn_select_by_brand.setTextColor(Color.WHITE);
                btn_select_by_brand.setBackgroundResource(R.mipmap.round_red_left);
                btn_select_by_factor.setTextColor(Color.RED);
                btn_select_by_factor.setBackgroundResource(R.mipmap.round_white_right);
                break;
            case R.id.btn_select_by_factor://条件选车(条件选车选中，品牌选车隐藏)
                fragmentTransaction.replace(R.id.fragment_content,selectByFactor_Fragment);
                btn_select_by_brand.setTextColor(Color.RED);
                btn_select_by_brand.setBackgroundResource(R.mipmap.round_white_left);
                btn_select_by_factor.setTextColor(Color.WHITE);
                btn_select_by_factor.setBackgroundResource(R.mipmap.round_red_right);
                break;
        }
        fragmentTransaction.commit();
    }

    public void getDatas(){
        HttpHelper httpHelper = new HttpHelper();
        //获取热门数据
        httpHelper.getHotBrandDatas(UrlUtils.SELECT_HOT_CAR_BRAND,"2","156", new HttpCallBack<HotBrandResultBean>() {

            @Override
            public void onSuccess(HotBrandResultBean hotBrandResultBean) {
//                  Log.e("tuanche",hotBrandResultBean.toString());
                selectByBrand_Fragment.setHotDatas(hotBrandResultBean,title_bar_select);
            }

            @Override
            public void onFail(String errMsg) {
//                Log.e("tuanche",errMsg);
            }
        });
        //获取条件选择数据
        httpHelper.getFactorDatas(UrlUtils.SELECT_CAR_FACTOR, new HttpCallBack<FactorResultBean>() {

            @Override
            public void onSuccess(FactorResultBean factorResultBean) {
//                Log.e("tuanche",factorResultBean.toString());
                 selectByFactor_Fragment.setDatas(factorResultBean);
            }

            @Override
            public void onFail(String errMsg) {
//                Log.e("tuanche",errMsg);
            }
        });
        //获取选车--列表数据
        httpHelper.getListBrandDatas(UrlUtils.SELECT_LIST_CAR_BRAND,"156", new HttpArrayCallBack<ListBrandBean>() {

            @Override
            public void onSuccess(List<ListBrandBean> result) {
//                Log.e("tuanche",result.toString());
                selectByBrand_Fragment.setListDatas(result);
            }

            @Override
            public void onFail(String errMsg) {
                Log.e("tuanche",errMsg);
            }
        });
    }
}

