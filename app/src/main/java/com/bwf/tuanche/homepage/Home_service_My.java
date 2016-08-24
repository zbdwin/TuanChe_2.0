package com.bwf.tuanche.homepage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_service_My extends BaseFragment {

    private TextView tv_browser_record;//浏览记录

    @Override
    protected int getResource() {
        return R.layout.fragment_home_service__my;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tv_browser_record = findViewByIdNoCast(R.id.tv_browser_record);
    }

    @Override
    protected void initData() {
        setOnClick(R.id.tv_browser_record);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.tv_browser_record:
                IntentUtils.openActivity(this.getActivity(),RecordActivity.class);
            break;
        }
    }
}
