package com.bwf.tuanche.homepage;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_service extends BaseFragment implements View.OnClickListener {
    private TextView servicephone;//拨打电话
    private TextView servicemessage;//留言


    @Override
    protected int getResource() {
        return R.layout.fragment_home_service;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        servicephone = findViewByIdNoCast(R.id.servicephone);
        servicemessage = findViewByIdNoCast(R.id.servicemessage);
        servicephone.setOnClickListener(this);
        servicemessage.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.servicephone:
                Uri uri = Uri.parse("tel:4006969123");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                break;
            case R.id.servicemessage:
                IntentUtils.openActivity(this.getActivity(), Home_service_message.class);
                break;
        }
    }
}
