package com.bwf.tuanche.tuancheDetial.mypop;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * 分享
 * Created by admin on 17/08/2016.
 */
public class MyPopwindow extends PopupWindow implements View.OnClickListener{
    private TextView tv_qq_frend,tv_qq_qone;
    private Activity activity;
    private UMShareAPI shareAPI;

    public MyPopwindow(Context context,Activity activity) {
        super(context);
        this.activity=activity;
        shareAPI=UMShareAPI.get(context);
        initView(context);
    }
    public void initView( Context context){
        View view=View.inflate(context, R.layout.detial_popwindow,null);
        this.setContentView(view);
        this.setHeight(DisplayUtil.getDensity_Height(context));
        this.setWidth(DisplayUtil.getDensity_Width(context));
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setOutsideTouchable(true);
        tv_qq_frend= (TextView) view.findViewById(R.id.tv_qq_frend);
        tv_qq_qone= (TextView) view.findViewById(R.id.tv_qq_qone);
       tv_qq_frend.setOnClickListener(this);
        tv_qq_qone.setOnClickListener(this);

    }
    public void showPopWindow(View view) {
        if (!isShowing()) {
            this.showAsDropDown(view);//显示在view的下方
            // this.showAtLocation(view, Gravity.TOP, 0, 0);//可以显示在指定view的指定位置
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_qq_frend:
               //QQ空间分享
                ShareUtil.shareToQQ(activity, SHARE_MEDIA.QZONE, "团车", "团车分享", "http://www.baidu.com", "http://p1.qhimg.com/t0151320b1d0fc50be8.png", new UMShareListener() {
                    @Override
                    public void onResult(SHARE_MEDIA share_media) {
                        Toast.makeText(activity, "分享成功了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                        Toast.makeText(activity, "分享失败了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media) {
                        Toast.makeText(activity, "取消分享", Toast.LENGTH_SHORT).show();
                    }
                });
            break;
            case R.id.tv_qq_qone:
                shareAPI.doOauthVerify(activity, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        Toast.makeText(activity, "登录成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        Toast.makeText(activity, "登录失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {
                        Toast.makeText(activity, "登录取消", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }

}
