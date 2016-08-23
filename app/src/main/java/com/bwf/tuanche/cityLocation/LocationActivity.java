package com.bwf.tuanche.cityLocation;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.bean.CityBean;
import com.bwf.framwork.bean.CityListBean;
import com.bwf.framwork.bean.ListBrandBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.car_select.view.SideBar;
import com.bwf.tuanche.cityLocation.adapter.LocationAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationActivity extends BaseActivity {

    private TextView hintTv;
    private SideBar indexBar;

    private String latitude;
    private String longitude;
    private ImageView img_location_back;
    private CityBean cityBean;
    private TextView tv_location_now_city;
    private ListView lv_location;
    private List<CityBean> surrounding_city;
    private List<CityBean> hotCitys;
    private List<CityBean> openCitys;
    private List<CityBean> totalDatas;
    private CityBean separatorBean;

    private LocationAdapter adapter;

    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    @Override
    public int getContentViewId() {

        return R.layout.activity_location;
    }

    @Override
    public void beforeInitView() {
        totalDatas = new ArrayList<>();
        adapter = new LocationAdapter(this);

        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
        mLocationClient.registerLocationListener( myListener );    //注册监听函数
        initLocation();
    }

    @Override
    public void initView() {
        tv_location_now_city = findViewByIdNoCast(R.id.tv_location_now_city);
        img_location_back = findViewByIdNoCast(R.id.img_location_back);

        hintTv = findViewByIdNoCast(R.id.location_centerHintTv);
        lv_location = findViewByIdNoCast(R.id.lv_location);
        indexBar = findViewByIdNoCast(R.id.location_sideBar);

        //监听SideBar的手指按下和抬起事件
        indexBar.setOnSelectListener(new SideBar.OnSelectListener() {

            @Override
            public void onSelect(String s) {
                //手指按下时显示中央的字母
                hintTv.setVisibility(View.VISIBLE);
                hintTv.setText(s);
                //如果SideBar按下的是#号，则ListView定位到位置0
                if ("#".equals(s) || s == null) {
                    lv_location.setSelection(0);
                    return;
                }
                //获取手指按下的字母所在的块索引
                int section = s.toCharArray()[0];
                //根据块索引获取该字母首次在ListView中出现的位置
                int pos = adapter.getPositionForSection(section - 65);
                Log.e("select",pos+"");
                //定位ListView到按下字母首次出现的位置
//                mScrollView.scrollTo(0,20+pos*100);//自己猜的距离，醉了
                lv_location.setSelection(pos-4);//对应字母显示在中间
            }

            @Override
            public void onMoveUp(String s) {
                hintTv.setVisibility(View.GONE);
                hintTv.setText(s);
            }
        });


        setOnClick(R.id.img_location_back);
    }

    @Override
    public void initData() {
        getCityListDatas();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.img_location_back:
                IntentUtils.openActivity(LocationActivity.this, MainActivity.class);
            break;
        }
    }

    //获取城市定位
    public void getLocationDatas(){
        if (TextUtils.isEmpty(latitude) || TextUtils.isEmpty(longitude))
            return;
        HttpHelper.getCityLocation(longitude,latitude, new HttpCallBack<CityBean>() {
            @Override
            public void onSuccess(CityBean result) {
                tv_location_now_city.setText("当前城市-"+result.name);
                adapter.setLocationCity(result);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(String errMsg) {
                dissmissProgressbar();
            }
        });
    }
    //获取城市列表
    public void getCityListDatas(){
        showProgressbar();
        HttpHelper.getCityList("4", new HttpCallBack<CityListBean>() {
            @Override
            public void onSuccess(CityListBean result) {
                dissmissProgressbar();
                if (result != null ){
                    if (!result.hotCitys.isEmpty())
                        hotCitys = result.hotCitys;
                    if (!result.openCitys.isEmpty()){
                        openCitys = result.openCitys;
                        Collections.sort(result.openCitys);
                        adjustDatas();
                        lv_location.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFail(String errMsg) {
                dissmissProgressbar();
                Log.e("location",errMsg);
            }
        });
    }



    //初始化定位参数
    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
//        int span=1000;
//        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
        mLocationClient.start();

    }

    public class MyLocationListener implements BDLocationListener {

            @Override
            public void onReceiveLocation(BDLocation location) {

                if (location != null){
                    latitude = location.getLatitude()+"";
                    longitude = location.getLongitude()+"";
                    getLocationDatas();
                }
            }
        }

    public void adjustDatas(){
        //定位城市
        separatorBean = new CityBean("定位城市",null);
        totalDatas.add(separatorBean);
        CityBean temp = new CityBean();//空对象,实体对象通过回调传递
        totalDatas.add(cityBean);

        //周边城市
        surrounding_city = new ArrayList<>();
        separatorBean = new CityBean("周边城市",null);
        CityBean temp1 = new CityBean();
        totalDatas.add(separatorBean);
        totalDatas.add(temp1);
        CityBean cityBean1 = new CityBean(null,"天津");
        CityBean cityBean2 = new CityBean(null,"石家庄");
        CityBean cityBean3 = new CityBean(null,"济南");
        CityBean cityBean4 = new CityBean(null,"太原");
        surrounding_city.add(cityBean1);
        surrounding_city.add(cityBean2);
        surrounding_city.add(cityBean3);
        surrounding_city.add(cityBean4);

        //热门城市
        separatorBean = new CityBean("热门城市",null);
        CityBean temp2 = new CityBean();
        CityBean temp3 = new CityBean();
        totalDatas.add(separatorBean);
        totalDatas.add(temp2);
        totalDatas.add(temp3);
        //热门城市列表
        String type = (char)(openCitys.get(0).py.charAt(0)-32)+"";
        separatorBean = new CityBean(type,"");
        openCitys.add(0,separatorBean);
        for (int i=1;i< openCitys.size();i++){
            String posType = (char)(openCitys.get(i).py.charAt(0)-32)+"";
            if (!type.equals(posType)){
                type = posType;
                separatorBean = new CityBean(type,"");
                openCitys.add(i,separatorBean);
                i++;
            }
        }
        totalDatas.addAll(openCitys);
        adapter.setDatas(surrounding_city,hotCitys,openCitys,totalDatas);
    }
}
