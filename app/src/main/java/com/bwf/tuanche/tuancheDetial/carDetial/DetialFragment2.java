package com.bwf.tuanche.tuancheDetial.carDetial;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Html;;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.bean.CarDetialResultBean1;
import com.bwf.framwork.bean.StyleList;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
import com.bwf.tuanche.tuancheDetial.TuanDetialActivity;
import com.bwf.tuanche.tuancheDetial.mypop.MyPopwindow1;

import java.util.List;

/**
 *团购报名
 */
public class DetialFragment2 extends BaseFragment {
    private TextView tuantime,tv_tuanlocation,tv_tuanprice,tv_carnametopop;
    private EditText et_phone,et_name;
    private Button bt_tuangoubaoming;
    private List<StyleList> styleLists;
    private MyCallBack callBack;
    private CarDetialResultBean1 result;

    public void setStyleLists(List<StyleList> styleLists) {
        this.styleLists = styleLists;
    }

    public void setResult(CarDetialResultBean1 result) {
        this.result = result;
        initData();
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_detial_fragment2;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        tuantime=findViewByIdNoCast(R.id.tuantime);
        tv_tuanlocation=findViewByIdNoCast(R.id.tv_tuanlocation);
        tv_tuanprice=findViewByIdNoCast(R.id.tv_tuanprice);
        tv_carnametopop=findViewByIdNoCast(R.id.tv_carnametopop);
        et_phone=findViewByIdNoCast(R.id.et_phone);
        et_name=findViewByIdNoCast(R.id.et_name);
        bt_tuangoubaoming=findViewByIdNoCast(R.id.bt_tuangoubaoming);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context!=null&&context instanceof TuanDetialActivity){
            callBack= (MyCallBack) context;
        }
    }

    @Override
    protected void initData() {
        setOnClick(R.id.tv_tuanprice, R.id.tv_carnametopop);
        if (result!=null){
            String string = "团购时间："+result.groupbuyDate+"("+result.groupbuyWeek+")"+ "<font color='#ACB0B5'><small>具体时间以团长通知为准</small></font>";
            tuantime.setText(Html.fromHtml(string));
            tv_tuanlocation.setText("团购地点："+result.regular4sShop);
            tv_tuanprice.setText("团购价格："+"现场公布");
            tv_carnametopop.setText(result.brandName);
        }

    }
private int position;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_tuanprice:
                position=0;
                MyPopwindow1 popwindow1=new MyPopwindow1(getContext(),position);
                popwindow1.showPopWindow(tv_tuanprice,getContext());
            break;
            case R.id.tv_carnametopop:
                position=1;
                if (callBack!=null){
                    callBack.showpop(position);
                }

            break;
        }

    }

    public interface MyCallBack{
        void showpop(int position);
    }
}
