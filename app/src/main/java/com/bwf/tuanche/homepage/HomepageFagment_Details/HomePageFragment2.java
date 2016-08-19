package com.bwf.tuanche.homepage.HomepageFagment_Details;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.car_select.view.RecycleViewDivider;
import com.bwf.tuanche.homepage.HomePageAdapter.HomePageFragment2_adapter;
import com.bwf.tuanche.homepage.entity.TuanChe_TopBr;
import com.bwf.tuanche.homepage.entity.TuanChe_TopBrresult;
import com.bwf.tuanche.homepage.entity.TuanChe_TopBrresultlist;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * 热门品牌
 */
public class HomePageFragment2 extends BaseFragment {
    private RecyclerView recyclerView;
    private HomePageFragment2_adapter homePageFragment2_adapter;
    private List<TuanChe_TopBr> newlist;

    @Override
    protected int getResource() {
        return R.layout.fragment_home_page_fragment2;
    }

    @Override
    protected void beforeInitView() {
        newlist = new ArrayList<TuanChe_TopBr>();
    }

    @Override
    protected void initView(View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.Homepager_hot);
        recyclerView.addItemDecoration(new RecycleViewDivider(this.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new RecycleViewDivider(this.getContext(), LinearLayoutManager.HORIZONTAL));
        homePageFragment2_adapter = new HomePageFragment2_adapter(getContext());
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    @Override
    protected void initData() {
        HttpHelper.getTuanChe_TopBr("2", "156", new HttpCallBack<TuanChe_TopBrresult>() {
            @Override
            public void onSuccess(TuanChe_TopBrresult result) {
                if (result != null) {
                    homePageFragment2_adapter = new HomePageFragment2_adapter(getContext());
                    newlist = result.list;
                    TuanChe_TopBr tuanChe_topBr = new TuanChe_TopBr();
                    newlist.add(tuanChe_topBr);
                    newlist.size();
                    homePageFragment2_adapter.setList(getContext(), newlist);
                    homePageFragment2_adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(homePageFragment2_adapter);
                }
//                LogUtils.e("ZBD"+result.toString());

            }


            @Override
            public void onFail(String errMsg) {
                LogUtils.e("TTTT" + errMsg);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}
