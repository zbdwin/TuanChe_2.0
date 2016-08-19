package com.bwf.tuanche.car_select.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.bean.BosBean;
import com.bwf.framwork.bean.LevleBean;
import com.bwf.framwork.bean.SeriesBean;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class My_Series_GridViewAdapter extends BaseAdapter {

    private Context context;

    private List<SeriesBean> levleBeanList;

    public My_Series_GridViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<SeriesBean> levleBeanList){
        this.levleBeanList = levleBeanList;
    }

    @Override
    public int getCount() {
        return levleBeanList == null ? 0:levleBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return levleBeanList == null ? null:levleBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.select_factor_country_item_layout,null);
            viewHolder.tv_select_factor_country = (TextView) convertView.findViewById(R.id.tv_select_factor_country);
            viewHolder.img_select_factor_country = (SimpleDraweeView) convertView.findViewById(R.id.img_select_factor_country);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (levleBeanList != null && !levleBeanList.isEmpty()){
            viewHolder.tv_select_factor_country.setText(levleBeanList.get(i).name);
            ImageLoader.getInstance().disPlayImage(viewHolder.img_select_factor_country,levleBeanList.get(i).icon);
            //item选中监听
            final ViewHolder finalViewHolder = viewHolder;
            viewHolder.tv_select_factor_country.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    levleBeanList.get(i).isSelected =  !levleBeanList.get(i).isSelected;
                    if (levleBeanList.get(i).isSelected == false){
                        finalViewHolder.tv_select_factor_country.setTextColor(Color.BLACK);
                        finalViewHolder.tv_select_factor_country.setBackgroundResource(R.drawable.select_factor_black_shape);
                    }else{
                        finalViewHolder.tv_select_factor_country.setTextColor(Color.RED);
                        finalViewHolder.tv_select_factor_country.setBackgroundResource(R.drawable.select_factor_red_shape);

                    }
                }
            });
        }
        return convertView;
    }

    private class ViewHolder{
        TextView tv_select_factor_country;
        SimpleDraweeView img_select_factor_country;
    }
}
