package com.bwf.tuanche.homepage;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.car_select.CarSelectActivity;
import com.bwf.tuanche.homepage.HomepageFagment_Details.HomePageFragment;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 * A simple {@link Fragment} subclass.
 * 详情页面
 */
public class HomePage_FmentTitlebar01 extends BaseFragment {
    private SimpleDraweeView simpleDraweeView;
    //下拉刷新
    private ImageView title_updata_img;
    private TextView title_updata_text;

    @Override
    protected int getResource() {
        return R.layout.fragment_home_page__fment_titlebar01;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        simpleDraweeView = findViewByIdNoCast(R.id.fragmentHomedetails_img01);
    }

    @Override
    protected void initData() {
        Uri uri = Uri.parse(UrlUtils.SIMPLEDRAWEEVIEW);
        simpleDraweeView.setImageURI(uri);
        simpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtils.openActivity(getContext(), CarSelectActivity.class);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
