package com.bwf.tuanche.tuancheDetial.detialAdapter;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseListAdpter;
import com.bwf.framwork.bean.CarDetialResultBean;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;

/**
 * Created by admin on 17/08/2016.
 */
public class DetialBuyCarPingjiaAdapter extends BaseListAdpter<CarDetialResultBean.CommentList,DetialBuyCarPingjiaAdapter.MyViewHolder> {

    public DetialBuyCarPingjiaAdapter(Context context) {
        super(context);
    }

    @Override
    public int getResourceId() {
        return R.layout.detial_pingjia_adapter;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent) {
        MyViewHolder viewHolder=new MyViewHolder();
        viewHolder.simple_touxiang=findViewByIdNoCast(R.id.simple_touxiang);
        viewHolder.tv_content_pingjia=findViewByIdNoCast(R.id.tv_content_pingjia);
        viewHolder.tv_data=findViewByIdNoCast(R.id.tv_data);
        viewHolder.tv_name_pingjia=findViewByIdNoCast(R.id.tv_name_pingjia);
        viewHolder.ll_xingxing=findViewByIdNoCast(R.id.ll_xingxing);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, CarDetialResultBean.CommentList commentList, int position) {
        if (commentList!=null){
            holder.simple_touxiang.setImageURI(Uri.parse(commentList.memberPic));
            holder.tv_content_pingjia.setText(commentList.content);
            holder.tv_name_pingjia.setText(commentList.userName);
           holder.tv_data.setText(commentList.commentDate);
            int count=commentList.score;
            for(int i=0;i<count;i++){
                addview(holder.ll_xingxing);

            }
        }

    }

    public class MyViewHolder extends BaseListAdpter.ViewHolder{
        private ImageView simple_touxiang;
        private TextView tv_name_pingjia,tv_data,tv_content_pingjia;
        private LinearLayout ll_xingxing;

    }
    public void addview(LinearLayout ll_xingxing){
        ImageView imageView = new ImageView(MyApplication.getAppContext());
        imageView.setPadding(2,2,2,2);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.star_small);
        ll_xingxing.addView(imageView);

    }
}
