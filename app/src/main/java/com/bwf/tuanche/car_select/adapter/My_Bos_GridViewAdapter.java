package com.bwf.tuanche.car_select.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.bean.BosBean;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class My_Bos_GridViewAdapter extends BaseAdapter {

    private Context context;

    private List<BosBean> levleBeanList;

    public My_Bos_GridViewAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<BosBean> levleBeanList){
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
            convertView = View.inflate(context, R.layout.select_factor_level_item_layout,null);
            viewHolder.tv_select_factor_level = (TextView) convertView.findViewById(R.id.tv_select_factor_level);
            viewHolder.img_select_factor_level = (SimpleDraweeView) convertView.findViewById(R.id.img_select_factor_level);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (levleBeanList != null && !levleBeanList.isEmpty()){
            viewHolder.tv_select_factor_level.setText(levleBeanList.get(i).name);
            final ViewHolder finalViewHolder = viewHolder;
            setChanges(viewHolder,i);
            viewHolder.img_select_factor_level.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    levleBeanList.get(i).isSelected =  !levleBeanList.get(i).isSelected;
                    setChanges(finalViewHolder,i);
                }
            });
        }
        return convertView;
    }

    public void setChanges(ViewHolder viewHolder,int i){
        if (levleBeanList.get(i).isSelected == false){
            viewHolder.tv_select_factor_level.setTextColor(Color.BLACK);
            ImageLoader.getInstance().disPlayImage(viewHolder.img_select_factor_level,levleBeanList.get(i).defIcon);
        }else{
            viewHolder.tv_select_factor_level.setTextColor(Color.RED);
            ImageLoader.getInstance().disPlayImage(viewHolder.img_select_factor_level,levleBeanList.get(i).icon);
        }
    }

    private class ViewHolder{
        TextView tv_select_factor_level;
        SimpleDraweeView img_select_factor_level;
    }
}
