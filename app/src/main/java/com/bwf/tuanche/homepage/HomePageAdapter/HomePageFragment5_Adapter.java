package com.bwf.tuanche.homepage.HomePageAdapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.entity.HotstyleRoot;
import com.bwf.tuanche.tuancheDetial.TuanDetialActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wanli on 2016/8/18.
 * Description:
 */
public class HomePageFragment5_Adapter extends RecyclerView.Adapter<HomePageFragment5_Adapter.ViewHolder> {
   private List<HotstyleRoot> hotstyleRoots;

    private Context context;


//    public void setResult(Context context, List<HotstyleRoot> result) {
//        this.context = context;
//        this.result = result;
//    }

    public HomePageFragment5_Adapter(Context context,List<HotstyleRoot> hotstyleRoots) {
        this.context = context;
        this.hotstyleRoots = hotstyleRoots;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = View.inflate(context, R.layout.hotcarhomepage_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.homepage2_itemimg = (SimpleDraweeView) view.findViewById(R.id.homepage2_itemimg);
        viewHolder.homepage2_itemtvbrand = (TextView) view.findViewById(R.id.homepage2_itemtvbrand);
        viewHolder.homepage2_itemtvperson = (TextView) view.findViewById(R.id.homepage2_itemtvperson);
        viewHolder.homepage2_itemtvmoney = (TextView) view.findViewById(R.id.homepage2_itemtvmoney);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        HotstyleRoot hotstyleRoot =hotstyleRoots.get(position);
        holder.homepage2_itemimg.setImageURI(Uri.parse(hotstyleRoot.logo));
        holder.homepage2_itemtvbrand.setText(hotstyleRoot.styleName);
        holder.homepage2_itemtvperson.setText(hotstyleRoot.content);
        holder.homepage2_itemtvmoney.setText("指导价:"+hotstyleRoot.factoryPrice);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("id", hotstyleRoots.get(position).brandId);
                bundle.putString("name", hotstyleRoots.get(position).styleName);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                IntentUtils.openActivity(context, TuanDetialActivity.class, bundle);
                ToastUtil.showToast("点击了子布局");
            }
        });

    }
    @Override
    public int getItemCount() {
        return hotstyleRoots==null?0:hotstyleRoots.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView homepage2_itemimg;//品牌
        TextView homepage2_itemtvbrand;//名字
        TextView homepage2_itemtvperson;//报名
        TextView homepage2_itemtvmoney;//指导价

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
