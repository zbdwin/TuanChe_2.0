package com.bwf.tuanche.car_select;

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
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.car_select.adapter.MySelectResultAdapter;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.LinkedList;
import java.util.List;

public class SelectResultActivity extends BaseActivity {

    private ImageView imageView;

    private PullToRefreshGridView mPullRefreshListView;
    private MySelectResultAdapter adapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_select_result;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        // 得到控件
        mPullRefreshListView =  findViewByIdNoCast(R.id.pull_refresh_list);
        mPullRefreshListView.getRefreshableView().setNumColumns(2);
        mPullRefreshListView.getRefreshableView().setHorizontalSpacing(30);
        mPullRefreshListView.getRefreshableView().setVerticalSpacing(30);
        mPullRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        ILoadingLayout startLabels = mPullRefreshListView
                .getLoadingLayoutProxy();
        startLabels.setPullLabel("下拉刷新...");// 刚下拉时，显示的提示
        startLabels.setRefreshingLabel("加载中...");// 刷新时
        startLabels.setReleaseLabel("松开即可刷新...");// 下来达到一定距离时，显示的提

        getDatas();

        mPullRefreshListView
                .setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                        //这里写下拉刷新的任务
                        Log.e("TAG", "onPullDownToRefresh");
                        getDatas();
                        mPullRefreshListView.onRefreshComplete();
                    }

                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                        //这里写上拉加载更多的任务
                        getDatas();
                        mPullRefreshListView.onRefreshComplete();
                    }
                });
    }

    @Override
    public void initData() {

    }

    public void getDatas(){
        HttpHelper httpHelper = new HttpHelper();

        httpHelper.getHotTypeDatas(UrlUtils.HOT_CAR_TYPE, "156", new HttpArrayCallBack<HotstyleRoot>() {
            @Override
            public void onSuccess(List<HotstyleRoot> result) {
                if (result != null && !result.isEmpty()){
                    // 设置适配器
                    adapter = new MySelectResultAdapter(SelectResultActivity.this);
                    adapter.setDatas(result);
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

    }
}
