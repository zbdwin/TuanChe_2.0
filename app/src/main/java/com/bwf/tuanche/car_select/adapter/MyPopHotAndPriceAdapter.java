package com.bwf.tuanche.car_select.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.bean.HotstyleRoot;
import com.bwf.framwork.bean.StyleList;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by admin on 2016/8/19.
 */
public class MyPopHotAndPriceAdapter extends BaseAdapter {

    private Context context;

    private List<StyleList.ResultBeanList> styleList;

    public MyPopHotAndPriceAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<StyleList.ResultBeanList> styleList){
        this.styleList = styleList;
    }

    @Override
    public int getCount() {
        return styleList == null ? 0:styleList.size();
    }

    @Override
    public Object getItem(int i) {
        return styleList == null ? null:styleList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_pop_hot_and_price_layout,null);
            viewHolder.tv_pop_hot_and_price_name = (TextView) convertView.findViewById(R.id.tv_pop_hot_and_price_name);
            viewHolder.tv_pop_hot_and_price_price = (TextView) convertView.findViewById(R.id.tv_pop_hot_and_price_price);
            viewHolder.img_pop_hot_and_price = (SimpleDraweeView) convertView.findViewById(R.id.img_pop_hot_and_price);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (styleList != null && !styleList.isEmpty()){
            viewHolder.tv_pop_hot_and_price_name.setText(styleList.get(i).styleName);
            viewHolder.tv_pop_hot_and_price_price.setText(styleList.get(i).factoryPrice);
            ImageLoader.getInstance().disPlayImage(viewHolder.img_pop_hot_and_price,styleList.get(i).logo);
        }
        return convertView;
    }

    private class ViewHolder{
        TextView tv_pop_hot_and_price_name;
        TextView tv_pop_hot_and_price_price;
        SimpleDraweeView img_pop_hot_and_price;
    }
}
