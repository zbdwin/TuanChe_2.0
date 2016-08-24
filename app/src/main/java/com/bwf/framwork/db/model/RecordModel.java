package com.bwf.framwork.db.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.bwf.framwork.base.BaseModel;
import com.bwf.tuanche.homepage.entity.HotstyleRoot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/8/24.
 */
public class RecordModel extends BaseModel {

    public static final String TABLE_NAME = "recordinfo";//表名

    private static Map<String, String> paramsMap = new HashMap<>();

    static {
        paramsMap.put(_ID, "integer primary key autoincrement");//
        paramsMap.put("carid", "TEXT NOT NULL");//id
        paramsMap.put("img", "TEXT NOT NULL");//图片
        paramsMap.put("name", "TEXT NOT NULL");//车名
        paramsMap.put("price", "TEXT NOT NULL");//价格
    }

    /**
     * 插入一个记录
     * @param carRecord
     */
    public void insertCarRecord(HotstyleRoot carRecord) {
        if (carRecord == null)
            return;
        ContentValues values = new ContentValues();
        values.put("carid", carRecord.id);
        values.put("img", carRecord.logo);
        values.put("name", carRecord.styleName);
        values.put("price", carRecord.factoryPrice);
        insert(TABLE_NAME, values);
    }

    /**
     * 删除所有记录
     *
     */
    public void deletAllCarRecord() {
        clear(TABLE_NAME);
    }

    /**
     * 查询记录对象
     *
     * @param id
     * @return
     */
    public HotstyleRoot getCarRecordById(String id) {
        HotstyleRoot carRecord = new HotstyleRoot();
        String sql = "select * from recordinfo where carid=" + id;
        Cursor cursor = select(sql);

        if (cursor != null) {
            if (cursor.moveToNext()) {//找到id为xxx的车的数据了
                carRecord.id = cursor.getString(cursor.getColumnIndex("carid"));
                carRecord.styleName = cursor.getString(cursor.getColumnIndex("name"));
                carRecord.factoryPrice = cursor.getString(cursor.getColumnIndex("price"));
                carRecord.logo = cursor.getString(cursor.getColumnIndex("img"));
            }
        }
        return carRecord;
    }

    /**
     * 查询所有记录
     * @return
     */
    public List<HotstyleRoot> getALLCarRecord() {
        List<HotstyleRoot> hotstyleRootList = new ArrayList<>();
        HotstyleRoot carRecord = null;
        String sql = "select * from recordinfo";
        Cursor cursor = select(sql);

        if (cursor != null) {
            while (cursor.moveToNext()) {//找到id为xxx的车的数据了
                carRecord = new HotstyleRoot();
                carRecord.id = cursor.getString(cursor.getColumnIndex("carid"));
                carRecord.styleName = cursor.getString(cursor.getColumnIndex("name"));
                carRecord.factoryPrice = cursor.getString(cursor.getColumnIndex("price"));
                carRecord.logo = cursor.getString(cursor.getColumnIndex("img"));
                hotstyleRootList.add(carRecord);
            }
        }
        return hotstyleRootList;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected Map<String, String> getParamsMap() {
        return paramsMap;
    }
}
