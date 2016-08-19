package com.bwf.tuanche.car_select.Fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.bean.FactorResultBean;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.car_select.SelectResultActivity;
import com.bwf.tuanche.car_select.adapter.My_Bos_GridViewAdapter;
import com.bwf.tuanche.car_select.adapter.My_Level_GridViewAdapter;
import com.bwf.tuanche.car_select.adapter.My_Series_GridViewAdapter;
import com.bwf.tuanche.car_select.view.MyGridView;


public class SelectByFactor_Fragment extends BaseFragment implements View.OnClickListener{

    private Button btn_select_factor_reset,btn_select_factor_check;

    private MyGridView gv_level;
    private MyGridView gv_country;
    private MyGridView gv_displacement;

    private My_Bos_GridViewAdapter bos_adapter;
    private My_Level_GridViewAdapter level_adapter;
    private My_Series_GridViewAdapter series_adapter;

    private FactorResultBean factorResultBean;

    public void setDatas(FactorResultBean factorResultBean){
        this.factorResultBean = factorResultBean;
    }

    @Override
    protected int getResource() {
        return R.layout.fragment_select_by_factor;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        gv_level = findViewByIdNoCast(R.id.gv_level);
        gv_country = findViewByIdNoCast(R.id.gv_country);
        gv_displacement = findViewByIdNoCast(R.id.gv_displacement);
        btn_select_factor_reset = findViewByIdNoCast(R.id.btn_select_factor_reset);
        btn_select_factor_check = findViewByIdNoCast(R.id.btn_select_factor_check);
    }

    @Override
    protected void initData() {
        setOnClick(R.id.btn_select_factor_reset,R.id.btn_select_factor_check);
        if (factorResultBean != null && !factorResultBean.bos.isEmpty()){
            //级别
            bos_adapter = new My_Bos_GridViewAdapter(this.getActivity());
            bos_adapter.setDatas(factorResultBean.bos);
            gv_level.setAdapter(bos_adapter);
            //国别
            series_adapter = new My_Series_GridViewAdapter(this.getActivity());
            series_adapter.setDatas(factorResultBean.series);
            gv_country.setAdapter(series_adapter);
            //排量
            level_adapter = new My_Level_GridViewAdapter(this.getActivity());
            level_adapter.setDatas(factorResultBean.levle);
            gv_displacement.setAdapter(level_adapter);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_select_factor_reset:

            break;
            case R.id.btn_select_factor_check:
                IntentUtils.openActivity(this.getActivity(), SelectResultActivity.class);
            break;
        }
    }
}
