package com.bwf.tuanche.car_select.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.bean.LevleBean;
import com.bwf.tuanche.R;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class My_Level_GridViewAdapter extends BaseAdapter {

    private Context context;

    private List<LevleBean> levleBeanList;

    public My_Level_GridViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<LevleBean> levleBeanList){
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
            convertView = View.inflate(context, R.layout.select_factor_displacement_item_layout,null);
            viewHolder.tv_select_factor_displacement = (TextView) convertView.findViewById(R.id.tv_select_factor_displacement);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (levleBeanList != null && !levleBeanList.isEmpty()){
            viewHolder.tv_select_factor_displacement.setText(levleBeanList.get(i).name);
            final ViewHolder finalViewHolder = viewHolder;
            final ViewHolder finalViewHolder1 = viewHolder;
            viewHolder.tv_select_factor_displacement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    levleBeanList.get(i).isSelected =  !levleBeanList.get(i).isSelected;
                    if (levleBeanList.get(i).isSelected == false){
                        finalViewHolder1.tv_select_factor_displacement.setTextColor(Color.BLACK);
                        finalViewHolder.tv_select_factor_displacement.setBackgroundResource(R.drawable.select_factor_black_shape);
                    }else{
                        finalViewHolder1.tv_select_factor_displacement.setTextColor(Color.RED);
                        finalViewHolder.tv_select_factor_displacement.setBackgroundResource(R.drawable.select_factor_red_shape);

                    }
                }
            });

        }
        return convertView;
    }

    private class ViewHolder{
        TextView tv_select_factor_displacement;
    }


}
