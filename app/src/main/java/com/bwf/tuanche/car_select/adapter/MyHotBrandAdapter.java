package com.bwf.tuanche.car_select.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.bean.HotBrandBean;
import com.bwf.framwork.image.ImageLoader;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2016/8/17.
 */
public class MyHotBrandAdapter extends RecyclerView.Adapter<MyHotBrandAdapter.ViewHolder> {

    private Context context;

    private CallBack callBack;

    private List<HotBrandBean> hotBrandBeanList;

    public MyHotBrandAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<HotBrandBean> hotBrandBeanList,CallBack callBack){
        this.hotBrandBeanList = hotBrandBeanList;
        this.callBack = callBack;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//converView 逻辑这里帮你做了

        View view = View.inflate(context,R.layout.select_brand_hot_item_layout,null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.tv_select_brand_hot = (TextView) view.findViewById(R.id.tv_select_brand_hot);
        viewHolder.img_select_hot = (SimpleDraweeView) view.findViewById(R.id.img_select_hot);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {//
        holder.tv_select_brand_hot.setText(hotBrandBeanList.get(position).name);
        ImageLoader.getInstance().disPlayImage(holder.img_select_hot,hotBrandBeanList.get(position).logo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null){
                    callBack.OnItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {//getCount
        return hotBrandBeanList == null ? 0:hotBrandBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_select_brand_hot;
        SimpleDraweeView img_select_hot;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface CallBack{
        void OnItemClick(int position);
    }
}
