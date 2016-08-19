package com.bwf.tuanche.homepage.HomepageFagment_Details;


import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpCallBackArray;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.car_select.view.RecycleViewDivider;
import com.bwf.tuanche.homepage.HomePageAdapter.HomePageFragment5_Adapter;
import com.bwf.tuanche.homepage.entity.HotstyleRoot;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * 热门车型号
 */
public class HomePageFragment5 extends BaseFragment {
    private HomePageFragment5_Adapter homePageFragment5_adapter;
    private RecyclerView recyclerView;

    @Override
    protected int getResource() {
        return R.layout.fragment_home_page_fragment5;
    }

    @Override
    protected void beforeInitView() {
    }

    @Override
    protected void initView(View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.hotcarhomepage);
        recyclerView.addItemDecoration(new RecycleViewDivider(this.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new RecycleViewDivider(this.getContext(), LinearLayoutManager.HORIZONTAL));
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    protected void initData() {
        HttpHelper.getBannerHotstyle("10", "20", "156", new HttpCallBackArray<HotstyleRoot>() {
            @Override
            public void onSuccess(List<HotstyleRoot> result) {
                if (result != null) {
                    homePageFragment5_adapter = new HomePageFragment5_Adapter(getContext(), result);
                    recyclerView.setAdapter(homePageFragment5_adapter);
//                    LogUtils.e(result.toString() + "TTT");
                }
            }

            @Override
            public void onFail(String errMsg) {

            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}
