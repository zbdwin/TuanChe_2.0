package com.bwf.tuanche.car_select.fragment;

import android.content.Context;
import android.graphics.PixelFormat;
import android.location.Location;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.bean.HotBrandResultBean;
import com.bwf.framwork.bean.ListBrandBean;
import com.bwf.framwork.bean.StyleList;
import com.bwf.framwork.http.HttpArrayCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.car_select.adapter.MyHotBrandAdapter;
import com.bwf.tuanche.car_select.adapter.MyListBrandAdapter;
import com.bwf.tuanche.car_select.view.PopWindow_Hot_Price;
import com.bwf.tuanche.car_select.view.SideBar;

import java.util.List;


public class SelectByBrand_Fragment extends BaseFragment implements MyHotBrandAdapter.CallBack {

    private ScrollView mScrollView;
    private View title_bar_select;
    private WindowManager wm;
    private int width;

    //热门
    private RecyclerView hot_recyclerView;
    private MyHotBrandAdapter hot_adapter;
    private HotBrandResultBean hotBrandResultBean;

    //列表
    private TextView hintTv;
    private SideBar indexBar;
    private ListView lv_select_brand_list;
    private MyListBrandAdapter list_adapter;

    //列表数据
    private List<ListBrandBean> listBrandBeanList;
    private ListBrandBean separatorBean;
    //热门、价格弹窗
    private PopWindow_Hot_Price popWindow_hot_price;

    public void setHotDatas(HotBrandResultBean hotBrandResultBean,View title_bar_select){
        if (hotBrandResultBean != null && !hotBrandResultBean.list.isEmpty()){
            //热门
            this.hotBrandResultBean = hotBrandResultBean;
            this.title_bar_select = title_bar_select;
            hot_adapter = new MyHotBrandAdapter(this.getActivity());
            hot_adapter.setDatas(hotBrandResultBean.list,this);
            hot_recyclerView.setAdapter(hot_adapter);
        }
    }

    public void setListDatas(List<ListBrandBean> listBrandBeanList){
        if (hotBrandResultBean != null && !hotBrandResultBean.list.isEmpty()){
            //列表
            this.listBrandBeanList = listBrandBeanList;
            initData();
        }
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_select_by_brand;
    }

    @Override
    protected void beforeInitView() {
        list_adapter = new MyListBrandAdapter(this.getActivity());
        wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
    }

    @Override
    protected void initView(View rootView) {

        mScrollView = findViewByIdNoCast(R.id.select_scrollView);
        //热门
        hot_recyclerView = findViewByIdNoCast(R.id.rv_select_brand_hot);
        GridLayoutManager layoutManager = new GridLayoutManager(this.getActivity(), 4);
        hot_recyclerView.setLayoutManager(layoutManager);

        //列表
        hintTv = findViewByIdNoCast(R.id.centerHintTv);
        lv_select_brand_list = findViewByIdNoCast(R.id.lv_select_brand_list);
        indexBar = findViewByIdNoCast(R.id.sideBar);
        //监听SideBar的手指按下和抬起事件
        indexBar.setOnSelectListener(new SideBar.OnSelectListener() {

            @Override
            public void onSelect(String s) {
                //手指按下时显示中央的字母
                hintTv.setVisibility(View.VISIBLE);
                hintTv.setText(s);
                //如果SideBar按下的是#号，则ListView定位到位置0
                if ("#".equals(s) || s == null) {
                    lv_select_brand_list.setSelection(0);
                    return;
                }
                //获取手指按下的字母所在的块索引
                int section = s.toCharArray()[0];
                //根据块索引获取该字母首次在ListView中出现的位置
                int pos = list_adapter.getPositionForSection(section - 65);
                Log.e("select",pos+"");
                //定位ListView到按下字母首次出现的位置
                  mScrollView.scrollTo(0,-width/5+pos*width/5);//自己猜的距离，醉了
//                lv_select_brand_list.setSelection(pos);
            }

            @Override
            public void onMoveUp(String s) {
                hintTv.setVisibility(View.GONE);
                hintTv.setText(s);
            }
        });
        //侧面popwindow弹出
        lv_select_brand_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (listBrandBeanList.get(position).id != null){
                    String brandId = listBrandBeanList.get(position).id;
                    popWindow_hot_price = new PopWindow_Hot_Price(SelectByBrand_Fragment.this.getContext(),brandId);
                    popWindow_hot_price.showPopWindow(title_bar_select);
                }
            }
        });
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
            list_adapter.setDatas(listBrandBeanList);
            lv_select_brand_list.setAdapter(list_adapter);
            ListViewUtils.measureListViewHeight(lv_select_brand_list);
        }
    }

    @Override
    public void onClick(View view) {

    }

    //热门-item点击实现
    @Override
    public void OnItemClick(int position) {
        String brandId = hotBrandResultBean.list.get(position).id;
        popWindow_hot_price = new PopWindow_Hot_Price(SelectByBrand_Fragment.this.getContext(),brandId);
        popWindow_hot_price.showPopWindow(title_bar_select);
    }
}
