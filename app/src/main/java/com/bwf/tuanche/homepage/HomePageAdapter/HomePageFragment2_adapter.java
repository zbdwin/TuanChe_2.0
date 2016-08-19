package com.bwf.tuanche.homepage.HomePageAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.image.ImageLoader;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.BlankPage;
import com.bwf.tuanche.R;
import com.bwf.tuanche.car_select.CarSelectActivity;
import com.bwf.tuanche.homepage.entity.TuanChe_TopBr;
import com.bwf.tuanche.tuancheDetial.TuanDetialActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanli on 2016/8/17.
 * Description:
 * <p>
 * 热门品牌适配器
 */
public class HomePageFragment2_adapter extends RecyclerView.Adapter<HomePageFragment2_adapter.ViewHolder> {
    private Context context;
//    private List<TuanChe_TopBr> list;

    private List<TuanChe_TopBr> newlist;


    public void setList(Context context, List<TuanChe_TopBr> newlist) {
        this.newlist = newlist;
        this.context = context;
    }

    public HomePageFragment2_adapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.homepage2_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.homepage2_itemimg = (SimpleDraweeView) view.findViewById(R.id.homepage2_itemimg);
        viewHolder.homepage2_itemtvbrand = (TextView) view.findViewById(R.id.homepage2_itemtvbrand);
        viewHolder.homepage2_itemtvperson = (TextView) view.findViewById(R.id.homepage2_itemtvperson);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        newlist =new ArrayList<TuanChe_TopBr>();
//        final TuanChe_TopBr  list1=list.get(position);
//        newlist.add((TuanChe_TopBr) list);
//        newlist.add(8,tuanChe_topBr);
        TuanChe_TopBr tuanChe_topBr1 = newlist.get(position);
        if (position != 8) {
            holder.homepage2_itemimg.setImageURI(Uri.parse(tuanChe_topBr1.logo));
//        imageLoader =new ImageLoader(this);
            holder.homepage2_itemtvbrand.setText(tuanChe_topBr1.name);
            holder.homepage2_itemtvperson.setText("有" + tuanChe_topBr1.baseNum + "人报名");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("id", newlist.get(position).id);
                    bundle.putString("name", newlist.get(position).name);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    IntentUtils.openActivity(context, TuanDetialActivity.class, bundle);
                    ToastUtil.showToast("点击了子布局");
                }
            });


        }
        if (position == 8) {
            holder.homepage2_itemimg.setImageResource(R.mipmap.user_icon_more);
            holder.homepage2_itemtvbrand.setText("更多");
            holder.homepage2_itemtvbrand.setTextColor(Color.parseColor("#000000"));
            holder.homepage2_itemtvperson.setText("");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    IntentUtils.openActivity(context, CarSelectActivity.class);
                    ToastUtil.showToast("进入子布局");
                }
            });


        }

    }

    @Override
    public int getItemCount() {
        return newlist == null ? 0 : newlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView homepage2_itemtvbrand;
        TextView homepage2_itemtvperson;
        SimpleDraweeView homepage2_itemimg;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
