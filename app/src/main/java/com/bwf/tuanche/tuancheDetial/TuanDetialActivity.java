package com.bwf.tuanche.tuancheDetial;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.bean.CarDetialResultBean1;
import com.bwf.framwork.bean.StyleList;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.tuancheDetial.carDetial.DetialFragment1;
import com.bwf.tuanche.tuancheDetial.carDetial.DetialFragment2;
import com.bwf.tuanche.tuancheDetial.carDetial.DetialFragment3;
import com.bwf.tuanche.tuancheDetial.carDetial.DetialFragment4;
import com.bwf.tuanche.tuancheDetial.carDetial.DetialFragment5;
import com.bwf.tuanche.tuancheDetial.carDetial.DetialFragment6;
import com.bwf.tuanche.tuancheDetial.mypop.MyPopwindow;
import com.bwf.tuanche.tuancheDetial.mypop.MyPopwindow1;
import java.util.List;

public class TuanDetialActivity extends BaseActivity implements DetialFragment2.MyCallBack,MyPopwindow1.MyItemListviewCallBack ,DetialFragment5.MyText{
    private ImageView iv_back, iv_share;//返回和分享
    private TextView tv_carname, tv_location;//汽车名和地名
    private ScrollView scrollview;
    private DetialFragment1 fragment1;
    private List<StyleList> styleLists;
    private DetialFragment2 fragment2;//团购报名
    private DetialFragment3 fragment3;//团车保证
    private DetialFragment4 fragment4;//团车流程
    private DetialFragment5 fragment5;//购车评价
    private DetialFragment6 fragment6;//常见问题
    private String brandId,name;

    @Override
    public int getContentViewId() {
        return R.layout.activity_tuan_detial;
    }

    @Override
    public void beforeInitView() {
        brandId=getIntent().getStringExtra("id");
        name=getIntent().getStringExtra("name");
    }
    @Override
    public void initView() {
        iv_back = findViewByIdNoCast(R.id.iv_back);
        iv_share = findViewByIdNoCast(R.id.iv_share);
        tv_carname = findViewByIdNoCast(R.id.tv_carname);
        tv_location = findViewByIdNoCast(R.id.tv_location);
        scrollview = findViewByIdNoCast(R.id.scrollview1);
        fragment1 = (DetialFragment1) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        fragment2 = (DetialFragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        fragment3 = (DetialFragment3) getSupportFragmentManager().findFragmentById(R.id.fragment3);
        fragment4 = (DetialFragment4) getSupportFragmentManager().findFragmentById(R.id.fragment4);
        fragment5 = (DetialFragment5) getSupportFragmentManager().findFragmentById(R.id.fragment5);
        fragment6 = (DetialFragment6) getSupportFragmentManager().findFragmentById(R.id.fragment6);
    }

    @Override
    public void initData() {
        setOnClick(R.id.iv_share, R.id.iv_back, R.id.tv_location);
        tv_carname.setText(name+"-");
        getData();
        getData2();
    }
private MyPopwindow popwindow;
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_share:
                 popwindow = new MyPopwindow(this, this);
                popwindow.showPopWindow(iv_share);
                break;
            case R.id.iv_back:
                IntentUtils.openActivity(TuanDetialActivity.this, MainActivity.class);
                break;
            case R.id.tv_location:

                break;
        }

    }

    public void getData() {
      showProgressbar();
        HttpHelper.getDetailBuyCarDetial("25", "156", brandId, new HttpCallBack<CarDetialResultBean1>() {
            @Override
            public void onSuccess(CarDetialResultBean1 result) {
                dissmissProgressbar();
                if (result != null) {
                    fragment1.setResult(result);
                    fragment2.setResult(result);
                    if (result.comment!=null){
                        fragment5.setResult(result.comment,brandId);
                    }

                }

            }

            @Override
            public void onFail(String errMsg) {
                dissmissProgressbar();

            }
        });
    }

    public void getData2() {
        showProgressbar();
        HttpHelper.getDetailByPingpai("1", "156", brandId, new HttpArrayCallBack<StyleList>() {
            @Override
            public void onSuccess(List<StyleList> result) {
                dissmissProgressbar();
                if (result != null) {
                    styleLists=result;
                    fragment2.setStyleLists(result);
                }

            }

            @Override
            public void onFail(String errMsg) {
                dissmissProgressbar();

            }
        });
    }



    @Override
    public void showpop(int position) {
        if (styleLists.size()!=0){
            MyPopwindow1 popwindow2 = new MyPopwindow1(this, position, styleLists);
            popwindow2.setCallBack(this);
            popwindow2.showAsDropDown(iv_share);
        }else{
            ToastUtil.showToast("没有数据");
        }
    }

    @Override
    public void onsuccess(String logo, String brandId, String name) {
       this.brandId=brandId;
        getData();
     //   getData2();
    }

    @Override
    public void ontest() {
        scrollview.smoothScrollTo(0,20);
    }
}
