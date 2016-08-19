package com.bwf.tuanche.tuancheDetial.detialAdapter;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.bean.StyleList;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by admin on 18/08/2016.
 */
public class DetialCarList extends BaseListAdpter<StyleList.ResultBeanList, DetialCarList.MyViewHolder> {
    public DetialCarList(Context context) {
        super(context);
    }

    @Override
    public int getResourceId() {
        return R.layout.list_car;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent) {
        MyViewHolder viewHolder = new MyViewHolder();
        viewHolder.simpledraw = findViewByIdNoCast(R.id.simpledraw);
        viewHolder.tv_carname1 = findViewByIdNoCast(R.id.tv_carname1);
        viewHolder.tv_zhidaoprice = findViewByIdNoCast(R.id.tv_zhidaoprice);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, StyleList.ResultBeanList resultBeanList, int position) {
        if (resultBeanList != null) {
            holder.simpledraw.setImageURI(Uri.parse(resultBeanList.logo));
            holder.tv_carname1.setText(resultBeanList.styleName);
            holder.tv_zhidaoprice.setText(resultBeanList.pricePrefix + resultBeanList.price+"万");
        }

    }

    public class MyViewHolder extends BaseListAdpter.ViewHolder {
        private SimpleDraweeView simpledraw;
        private TextView tv_carname1, tv_zhidaoprice;

    }
}
