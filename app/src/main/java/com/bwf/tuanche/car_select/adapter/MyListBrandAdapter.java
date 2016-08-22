package com.bwf.tuanche.car_select.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.bean.HotBrandBean;
import com.bwf.framwork.bean.ListBrandBean;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class MyListBrandAdapter extends BaseAdapter {

    private Context context;

    //数据
    private List<ListBrandBean> listBrandBeanList;

    private int dataType1 = 0;//listBrandBean
    private int dataType2 = 1;//separatorBean

    public MyListBrandAdapter(Context context,List<ListBrandBean> listBrandBeanList) {
        this.context = context;
        this.listBrandBeanList = listBrandBeanList;
    }

    @Override
    public int getCount() {
        return listBrandBeanList == null ? 0:listBrandBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return listBrandBeanList == null ? null:listBrandBeanList.get(i);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (listBrandBeanList.get(position).separator == null)
            return dataType1;
        else
            return dataType2;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ItemViewHolder itemViewHolder = null;
        SeparatorViewHolder separatorViewHolder = null;
        if(convertView == null){
            if (getItemViewType(position) == 0){
                itemViewHolder = new ItemViewHolder();
                convertView = View.inflate(context, R.layout.select_brand_list_item_layout,null);
                itemViewHolder.tv_select_brand_list = (TextView) convertView.findViewById(R.id.tv_select_brand_list);
                itemViewHolder.img_select_brand_list = (SimpleDraweeView) convertView.findViewById(R.id.img_select_brand_list);
                convertView.setTag(itemViewHolder);
            }else if (getItemViewType(position) == 1){
                separatorViewHolder = new SeparatorViewHolder();
                convertView = View.inflate(context, R.layout.item_separator_layout,null);
                separatorViewHolder.tv_item_separator = (TextView) convertView.findViewById(R.id.tv_item_separator);
                convertView.setTag(separatorViewHolder);
            }
        }else {
            if (getItemViewType(position) == 0) {
                itemViewHolder = (ItemViewHolder) convertView.getTag();
            } else if (getItemViewType(position) == 1) {
                separatorViewHolder = (SeparatorViewHolder) convertView.getTag();
            }
        }

        if (getItemViewType(position) == 0){
            ListBrandBean modeOne = listBrandBeanList.get(position);
            itemViewHolder.tv_select_brand_list.setText(modeOne.name);
            ImageLoader.getInstance().disPlayImage(itemViewHolder.img_select_brand_list,listBrandBeanList.get(position).logo);
        }else if(getItemViewType(position) == 1){
            ListBrandBean modeTwo = listBrandBeanList.get(position);
            separatorViewHolder.tv_item_separator.setText(modeTwo.separator);
        }
        return convertView;
    }

    private class ItemViewHolder{
        TextView tv_select_brand_list;
        SimpleDraweeView img_select_brand_list;
    }

    private class SeparatorViewHolder{
        TextView tv_item_separator;
    }
}
