package com.bwf.tuanche.homepage.HomepageFagment_Details;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 *
 * 首页
 */
public class HomePageFragment extends BaseFragment {
    private SimpleDraweeView Cheap_car_home;
    private SimpleDraweeView sticker_car_home;
    private SimpleDraweeView icon_dijiagouche;
    private SimpleDraweeView insurance_car_home;
    //保险比较
    private String sticker_car_home1 = "http://pic.tuanche.com/icon/index/and/app4.0/icon_baoxian.png";
    //汽车贴膜
    private String icon_dijiagouche1 = "http://pic.tuanche.com/icon/index/and/app4.0/icon_tiemo.png";
    //最近车价格

    private String insurance_car_home1 = "http://pic.tuanche.com/icon/index/and/app4.0/icon_chexing.png";
    //低价购车

    private String Cheap_car_homeurl = "http://pic.tuanche.com/icon/index/and/app4.0/icon_gouche.png";

    @Override

    protected int getResource() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        Cheap_car_home = findViewByIdNoCast(R.id.Cheap_car_homeimg);
        sticker_car_home = findViewByIdNoCast(R.id.Cheap_car_homeimg2);
        icon_dijiagouche = findViewByIdNoCast(R.id.Cheap_car_homeimg3);
        insurance_car_home = findViewByIdNoCast(R.id.Cheap_car_homeimg4);

        Uri uri = Uri.parse(Cheap_car_homeurl);
        Cheap_car_home.setImageURI(uri);
        sticker_car_home.setImageURI(Uri.parse(icon_dijiagouche1));
        icon_dijiagouche.setImageURI(Uri.parse(insurance_car_home1));
        insurance_car_home.setImageURI(Uri.parse(sticker_car_home1));

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }
}
