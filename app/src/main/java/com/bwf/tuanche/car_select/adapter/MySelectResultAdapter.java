package com.bwf.tuanche.car_select.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.bean.BosBean;
import com.bwf.framwork.bean.HotstyleRoot;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2016/8/18.
 */
public class MySelectResultAdapter extends BaseAdapter{

    private Context context;

    private List<HotstyleRoot> hotstyleRootList;

    public MySelectResultAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HotstyleRoot> hotstyleRootList){
        this.hotstyleRootList = hotstyleRootList;
    }

    @Override
    public int getCount() {
        return hotstyleRootList == null ? 0:hotstyleRootList.size();
    }

    @Override
    public Object getItem(int i) {
        return hotstyleRootList == null ? null:hotstyleRootList.get(i);
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
            convertView = View.inflate(context, R.layout.item_select_result_layout,null);
            viewHolder.tv_select_result_carname = (TextView) convertView.findViewById(R.id.tv_select_result_carname);
            viewHolder.tv_select_result_price = (TextView) convertView.findViewById(R.id.tv_select_result_price);
            viewHolder.tv_select_result_number = (TextView) convertView.findViewById(R.id.tv_select_result_number);
            viewHolder.img_select_result = (SimpleDraweeView) convertView.findViewById(R.id.img_select_result);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (hotstyleRootList != null && !hotstyleRootList.isEmpty()){
            viewHolder.tv_select_result_carname.setText(hotstyleRootList.get(i).brandName);
            viewHolder.tv_select_result_price.setText(hotstyleRootList.get(i).factoryPrice);
            viewHolder.tv_select_result_number.setText(hotstyleRootList.get(i).manNum+"符合您的条件");
            ImageLoader.getInstance().disPlayImage(viewHolder.img_select_result,hotstyleRootList.get(i).logo);
        }
        return convertView;
    }

    private class ViewHolder{
        TextView tv_select_result_carname;
        TextView tv_select_result_price;
        TextView tv_select_result_number;
        SimpleDraweeView img_select_result;
    }

}
