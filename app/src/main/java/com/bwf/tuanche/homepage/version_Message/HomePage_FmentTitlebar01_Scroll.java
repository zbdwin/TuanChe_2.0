package com.bwf.tuanche.homepage.version_Message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

import com.bwf.tuanche.R;

/**
 * Created by wanli on 2016/8/23.
 * Description:
 */
public class HomePage_FmentTitlebar01_Scroll extends ListView{
    //这个是全局自定义的title
    private View header;
    public HomePage_FmentTitlebar01_Scroll(Context context) {
        this(context,null);
    }

    public HomePage_FmentTitlebar01_Scroll(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HomePage_FmentTitlebar01_Scroll(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inview(context);
    }
    /*
    添加顶部的布局文件
     */
    private void  inview(Context context){
        LayoutInflater inflater =LayoutInflater.from(context);
        header =inflater.inflate(R.layout.header_updata,null);
        //添加到头部
       this.addHeaderView(header);

    }
}
