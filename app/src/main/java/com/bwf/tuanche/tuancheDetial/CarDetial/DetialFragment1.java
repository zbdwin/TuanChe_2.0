package com.bwf.tuanche.tuancheDetial.carDetial;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.bean.CarDetialResultBean1;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
*分享
 */
public class DetialFragment1 extends BaseFragment {
    private TextView tv_baomingnum,tv_jieshengnum;
    private SimpleDraweeView iv_toppicture;
    private CarDetialResultBean1 result;

    public void setResult(CarDetialResultBean1 result) {
        this.result = result;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_detial_fragment1;
    }

    @Override
    protected void beforeInitView() {
    }

    @Override
    protected void initView(View rootView) {
        tv_baomingnum=findViewByIdNoCast(R.id.tv_baomingnum);
        tv_jieshengnum=findViewByIdNoCast(R.id.tv_jieshengnum);
        iv_toppicture=findViewByIdNoCast(R.id.iv_toppicture);

    }

    @Override
    protected void initData() {
        if (result!=null){
            iv_toppicture.setImageURI(Uri.parse(result.brandPic));
            tv_baomingnum.setText(result.manNum+"人");
            tv_jieshengnum.setText(result.saveUpMoney);

        }
    }


    @Override
    public void onClick(View view) {

    }
}
