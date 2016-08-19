package com.bwf.tuanche.car_select.Fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.bean.HotBrandResultBean;
import com.bwf.framwork.bean.ListBrandBean;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.car_select.adapter.MyHotBrandAdapter;
import com.bwf.tuanche.car_select.adapter.MyListBrandAdapter;

import java.util.ArrayList;
import java.util.List;


public class SelectByBrand_Fragment extends BaseFragment implements MyHotBrandAdapter.CallBack {
    //热门
    private RecyclerView hot_recyclerView;
    private MyHotBrandAdapter hot_adapter;
    private HotBrandResultBean hotBrandResultBean;

    //列表
    private ListView lv_select_brand_list;
    private MyListBrandAdapter list_adapter;

    //列表数据
    private List<ListBrandBean> listBrandBeanList;
    private ListBrandBean separatorBean;


    public void setHotDatas(HotBrandResultBean hotBrandResultBean){
        if (hotBrandResultBean != null && !hotBrandResultBean.list.isEmpty()){
            //热门
            this.hotBrandResultBean = hotBrandResultBean;
            hot_adapter = new MyHotBrandAdapter(this.getActivity());
            hot_adapter.setDatas(hotBrandResultBean.list,this);
            hot_recyclerView.setAdapter(hot_adapter);
//            ListViewUtils.measureListViewHeight(hot_recyclerView);
        }
    }

    public void setListDatas(List<ListBrandBean> listBrandBeanList){
        if (hotBrandResultBean != null && !hotBrandResultBean.list.isEmpty()){
            //列表
            this.listBrandBeanList = listBrandBeanList;
            initData();
//            ListViewUtils.measureListViewHeight(hot_recyclerView);
        }
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_select_by_brand;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        //热门
        hot_recyclerView = findViewByIdNoCast(R.id.rv_select_brand_hot);
        GridLayoutManager layoutManager = new GridLayoutManager(this.getActivity(), 4);
        hot_recyclerView.setLayoutManager(layoutManager);
        //列表
        lv_select_brand_list = findViewByIdNoCast(R.id.lv_select_brand_list);

    }

    @Override
    protected void initData() {
        if (listBrandBeanList != null && !listBrandBeanList.isEmpty()){
            String type = listBrandBeanList.get(0).penname;
            separatorBean = new ListBrandBean(type);
            listBrandBeanList.add(0,separatorBean);
            for (int i=1;i< listBrandBeanList.size();i++){
                if (!type.equals(listBrandBeanList.get(i).penname)){
                    type = listBrandBeanList.get(i).penname;
                    separatorBean = new ListBrandBean(listBrandBeanList.get(i).penname);
                    listBrandBeanList.add(i,separatorBean);
                    i++;
                }
            }
            //列表
            list_adapter = new MyListBrandAdapter(this.getActivity(),listBrandBeanList);
            lv_select_brand_list.setAdapter(list_adapter);
            ListViewUtils.measureListViewHeight(lv_select_brand_list);
//        Log.e("tuanche",listBrandBeanList.size()+"");
        }
    }

    //
    @Override
    public void onClick(View view) {

    }

    //热门-item点击实现
    @Override
    public void OnItemClick(int position) {

    }
}
