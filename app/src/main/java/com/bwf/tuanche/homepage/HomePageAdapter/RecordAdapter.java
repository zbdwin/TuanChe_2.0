package com.bwf.tuanche.homepage.HomePageAdapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.entity.HotstyleRoot;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2016/8/24.
 */
public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {

    private Context context;
    private List<HotstyleRoot> dataList;

    public RecordAdapter(Context context){
        this.context = context;
    }

    public void setDatas(List<HotstyleRoot> dataList){
        this.dataList = dataList;
    }

    @Override
    public RecordAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//converView 逻辑这里帮你做了
        View view =  View.inflate(context,R.layout.item_pop_hot_and_price_layout,null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.img_pop_hot_and_price = (SimpleDraweeView) view.findViewById(R.id.img_pop_hot_and_price);
        viewHolder.tv_pop_hot_and_price_name = (TextView) view.findViewById(R.id.tv_pop_hot_and_price_name);
        viewHolder.tv_pop_hot_and_price_price = (TextView) view.findViewById(R.id.tv_pop_hot_and_price_price);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (dataList != null && !dataList.isEmpty()){
            ImageLoader.getInstance().disPlayImage(holder.img_pop_hot_and_price,dataList.get(position).logo);
            holder.tv_pop_hot_and_price_name.setText(dataList.get(position).styleName);
            holder.tv_pop_hot_and_price_price.setText(dataList.get(position).factoryPrice);
        }
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0:dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView img_pop_hot_and_price;
        TextView tv_pop_hot_and_price_name;
        TextView tv_pop_hot_and_price_price;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
