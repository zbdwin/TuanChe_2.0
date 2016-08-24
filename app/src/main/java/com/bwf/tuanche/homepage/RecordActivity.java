package com.bwf.tuanche.homepage;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.db.model.RecordModel;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.HomePageAdapter.RecordAdapter;
import com.bwf.tuanche.homepage.entity.HotstyleRoot;

import java.util.List;

/**
 * Created by admin on 2016/8/24.
 */
public class RecordActivity extends BaseActivity {

    private TextView tv_record;

    private RecyclerView rv_record;
    private RecordAdapter adapter;
    private RecordModel recordModel;

    @Override
    public int getContentViewId() {
        return R.layout.activity_record;
    }

    @Override
    public void beforeInitView() {
        adapter = new RecordAdapter(this);
        recordModel = new RecordModel();
    }

    @Override
    public void initView() {
        tv_record = findViewByIdNoCast(R.id.tv_record);
        rv_record = findViewByIdNoCast(R.id.rv_record);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_record.setLayoutManager(layoutManager);
        setOnClick(R.id.tv_record);
    }

    @Override
    public void initData() {
        List<HotstyleRoot> hotstyleRootList = recordModel.getALLCarRecord();
        if (hotstyleRootList != null && !hotstyleRootList.isEmpty())
            adapter.setDatas(hotstyleRootList);
        rv_record.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch(R.id.tv_record){
            case R.id.tv_record:
                IntentUtils.openActivity(this,MainActivity.class);
            break;
        }
    }
}
