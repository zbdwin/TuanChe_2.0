package com.bwf.tuanche.car_select;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.bean.HotstyleRoot;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.http.request.HotCarTypeRequest;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.car_select.adapter.MySelectResultAdapter;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SelectResultActivity extends BaseActivity {

    private ImageView img_select_factor_back;
    private AnimationDrawable animationDrawable;

    private PullToRefreshGridView mPullRefreshListView;
    private MySelectResultAdapter adapter;

    private List<HotstyleRoot> hotstyleRootList;

    private HotCarTypeRequest request;

    @Override
    public int getContentViewId() {
        return R.layout.activity_select_result;
    }

    @Override
    public void beforeInitView() {
        hotstyleRootList = new ArrayList<>();
        request = new HotCarTypeRequest();
        adapter = new MySelectResultAdapter(SelectResultActivity.this);
    }

    @Override
    public void initView() {
        img_select_factor_back = findViewByIdNoCast(R.id.img_select_factor_back);
        // 得到控件
        mPullRefreshListView =  findViewByIdNoCast(R.id.pull_refresh_list);
        mPullRefreshListView.getRefreshableView().setNumColumns(2);
        mPullRefreshListView.getRefreshableView().setHorizontalSpacing(30);
        mPullRefreshListView.getRefreshableView().setVerticalSpacing(30);
        mPullRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        ILoadingLayout startLabels = mPullRefreshListView
                .getLoadingLayoutProxy(true, false);//下拉刷新文字设置
        startLabels.setPullLabel("下拉刷新...");// 刚下拉时，显示的提示
        startLabels.setRefreshingLabel("松开即可刷新...");// 刷新时
        startLabels.setReleaseLabel("加载中...");// 下来达到一定距离时，显示的提示

        ILoadingLayout endLabels = mPullRefreshListView.getLoadingLayoutProxy(
                false, true);//上拉加载更多文字设置
        endLabels.setPullLabel("加载更多...");// 刚下拉时，显示的提示
        endLabels.setRefreshingLabel("正在加载...");// 刷新时
        getDatas();

        mPullRefreshListView
                .setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                        //这里写下拉刷新的任务
                        request.offset = 0;
                        getDatas();
                        mPullRefreshListView.onRefreshComplete();
                    }

                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                        //这里写上拉加载更多的任务
                        request.offset++;
                        getDatas();
                        mPullRefreshListView.onRefreshComplete();
                    }
                });
        setOnClick(R.id.img_select_factor_back);
    }

    @Override
    public void initData() {

    }

    public void getDatas(){
        if (request.offset == 0)
            hotstyleRootList.clear();

        HttpHelper.getHotTypeDatas(UrlUtils.HOT_CAR_TYPE, "156",request,new HttpArrayCallBack<HotstyleRoot>() {
            @Override
            public void onSuccess(List<HotstyleRoot> result) {
                if (result != null && !result.isEmpty()){
                    hotstyleRootList.addAll(result);
                    // 设置适配器
                    adapter.setDatas(hotstyleRootList);
                    adapter.notifyDataSetChanged();
                    mPullRefreshListView.setAdapter(adapter);
                }
            }

            @Override
            public void onFail(String errMsg) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.img_select_factor_back:
                IntentUtils.openActivity(this,CarSelectActivity.class);
            break;
        }
    }
}
