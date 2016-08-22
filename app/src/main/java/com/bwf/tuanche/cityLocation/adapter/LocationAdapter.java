package com.bwf.tuanche.cityLocation.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.bean.CityBean;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;


import java.util.List;

/**
 * Created by admin on 2016/8/20.
 */
public class LocationAdapter extends BaseAdapter {
    //上下文
    private Activity activity;
    //数据源
    private CityBean nowCity;
    private List<CityBean> surrounding_city;
    private List<CityBean> hotCitys;
    private List<CityBean> openCitys;
    private List<CityBean> totalDatas;
    //城市定位-顶部内容
    private TextView tv_location_title;
    private int tv_id[] = {R.id.tv_location_head_content_1,R.id.tv_location_head_content_2,R.id.tv_location_head_content_3,R.id.tv_location_head_content_4};
    private TextView textViews[] = new TextView[4];//tv_location_head_content_1,tv_location_head_content_2,tv_location_head_content_3,tv_location_head_content_4;


    private int type_title = 0;//contentBean
    private int type_content = 1;//separatorBean

    public LocationAdapter(Activity activity){
        this.activity = activity;
    }
    public void setDatas(List<CityBean> surrounding_city,List<CityBean> hotCitys,List<CityBean> openCitys,List<CityBean> totalDatas){
        this.surrounding_city = surrounding_city;
        this.hotCitys = hotCitys;
        this.openCitys = openCitys;
        this.totalDatas = totalDatas;
    }

    public void setLocationCity(CityBean nowCity){
        this.nowCity = nowCity;
    }

    @Override
    public int getCount() {
        return totalDatas == null ? 0:totalDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return totalDatas == null ? null:totalDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position > 6 && totalDatas.get(position).separator == null)
            return type_content;//内容
        else
            return type_title;//标头
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = null;
        if (position <= 6){
            if (position == 0 || position == 2 || position == 4 ){
                view = View.inflate(activity, R.layout.item_location_head_title_layout,null);
                tv_location_title = (TextView) view.findViewById(R.id.tv_hot_city_title);
                if (position == 0 && totalDatas.get(0) != null)
                tv_location_title.setText(totalDatas.get(0).separator);
                if (position == 2 && totalDatas.get(2) != null)
                    tv_location_title.setText(totalDatas.get(2).separator);
                if (position == 4 && totalDatas.get(4) != null)
                    tv_location_title.setText(totalDatas.get(4).separator);
            }
            if (position == 1){
                view = View.inflate(activity, R.layout.item_location_item_content_layout,null);
                TextView tv_location_head_content = (TextView) view.findViewById(R.id.tv_location_now_city);
                tv_location_head_content.setTextColor(Color.RED);
                if (nowCity != null)
                    tv_location_head_content.setText(nowCity.name);
            }
            if (position == 3 && !surrounding_city.isEmpty()) {//周边城市
                view = View.inflate(activity, R.layout.item_location_head_content_layout,null);
                textViews[0] = (TextView) view.findViewById(R.id.tv_location_head_content_1);
                textViews[0].setText(surrounding_city.get(0).name);
                textViews[1] = (TextView) view.findViewById(R.id.tv_location_head_content_2);
                textViews[1].setText(surrounding_city.get(1).name);
                textViews[2] = (TextView) view.findViewById(R.id.tv_location_head_content_3);
                textViews[2].setText(surrounding_city.get(2).name);
                textViews[3] = (TextView) view.findViewById(R.id.tv_location_head_content_4);
                textViews[3].setText(surrounding_city.get(3).name);
            }
            if (position == 5 && !hotCitys.isEmpty()) {//热门城市1
                view = View.inflate(activity, R.layout.item_location_head_content_layout,null);
                for (int i = 0;i<4;i++){
                    textViews[i] = (TextView) view.findViewById(tv_id[i]);
                    textViews[i].setText(hotCitys.get(i).name);
                    if (nowCity != null && nowCity.name != null && nowCity.name.equals(hotCitys.get(i).name))
                    textViews[i].setTextColor(Color.RED);
                }
            }
            if (position == 6 && !hotCitys.isEmpty()) {//热门城市2
                view = View.inflate(activity, R.layout.item_location_head_content_layout,null);
                for (int i = 0;i<4;i++){
                    textViews[i] = (TextView) view.findViewById(tv_id[i]);
                    textViews[i].setText(hotCitys.get(i+4).name);
                    if (nowCity != null && nowCity.name != null && nowCity.name.equals(hotCitys.get(i+4).name))
                    textViews[i].setTextColor(Color.RED);
                }
            }
        }

        if (position > 6 && totalDatas != null && !totalDatas.isEmpty()) {
            ItemViewHolder itemViewHolder = null;
            SeparatorViewHolder separatorViewHolder = null;

            if ( convertView == null) {
                if (getItemViewType(position) == type_content) {//内容
                    itemViewHolder = new ItemViewHolder();
                    convertView = View.inflate(activity, R.layout.item_location_item_content_layout, null);
                    itemViewHolder.tv_location_now_city = (TextView) convertView.findViewById(R.id.tv_location_now_city);
                    convertView.setTag(itemViewHolder);
                } else if (getItemViewType(position) == type_title) {//标头
                    separatorViewHolder = new SeparatorViewHolder();
                    convertView = View.inflate(activity, R.layout.item_location_item_title_layout, null);
                    separatorViewHolder.tv_hot_city_title = (TextView) convertView.findViewById(R.id.tv_location_list_title);
                    convertView.setTag(separatorViewHolder);
                }
            } else {
                if (getItemViewType(position) == type_content) {
                    itemViewHolder = (ItemViewHolder) convertView.getTag();
                } else if (getItemViewType(position) == type_title) {
                    separatorViewHolder = (SeparatorViewHolder) convertView.getTag();
                    if (separatorViewHolder == null){//在获取convertView.getTag()时 热门城市列表的第一列(A)还没有recycle,separatorViewHolder为空
                        separatorViewHolder = new SeparatorViewHolder();
                        convertView = View.inflate(activity, R.layout.item_location_item_title_layout, null);
                        separatorViewHolder.tv_hot_city_title = (TextView) convertView.findViewById(R.id.tv_location_list_title);
                        convertView.setTag(separatorViewHolder);
                    }
                }
            }

            if (getItemViewType(position) == type_content) {
                CityBean modeOne = totalDatas.get(position);
                itemViewHolder.tv_location_now_city.setText(modeOne.name);
                itemViewHolder.tv_location_now_city.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Bundle bundle = new Bundle();
                        bundle.putString("nowCity",nowCity.id);
                        IntentUtils.openActivity(activity, MainActivity.class,bundle);
                    }
                });
                if (nowCity != null && nowCity.name != null && nowCity.name.equals(modeOne.name)){
                    itemViewHolder.tv_location_now_city.setTextColor(Color.RED);
                }else {
                    itemViewHolder.tv_location_now_city.setTextColor(Color.BLACK);
                }
            } else if (getItemViewType(position) == type_title) {
                CityBean modeTwo = totalDatas.get(position);
                separatorViewHolder.tv_hot_city_title.setText(modeTwo.separator);
            }
        }


        if (position <= 6)
            return view;
        else
        return convertView;
    }

    private class ItemViewHolder{
        TextView tv_location_now_city;
    }

    private class SeparatorViewHolder{
        TextView tv_hot_city_title;
    }
}
