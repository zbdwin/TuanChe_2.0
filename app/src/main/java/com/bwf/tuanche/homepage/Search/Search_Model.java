package com.bwf.tuanche.homepage.Search;

import android.content.ContentValues;
import android.database.Cursor;
import com.bwf.framwork.Constants;
import com.bwf.framwork.base.BaseModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by wanli on 2016/8/26.
 * Description:
 */
public class Search_Model extends BaseModel {
    public static final String TABLE_NAME = "zhangdapao";//表名
    //数据库表在常量类里面
    //建立一个map集合用来存储键值对
    public static Map<String, String> map = new HashMap<>();


    //静态代码块
    static {
        //自动增长的ID,添加到map集合里面
        map.put(_ID, "integer primary key autoincrement");
//        map.put("id","TEXT NOT NULL");
        map.put("name", "TEXT NOT NULL");
    }

    //添加一条信息到数据当中
    public void infoSelct(String name) {

        if (name != null) {
            ContentValues values = new ContentValues();
//            values.put("id",list.get(0));
            values.put("name", name);
            insert(TABLE_NAME, values);
        }

    }





    //清空表全部浏览信息
    public void Destr0y(){

        clear(TABLE_NAME);
    }


    /**
     * 查看全部信息
     *
     * @return
     */
    public List<String> Querydate() {
        List<String> strings = new ArrayList<>();
        String sql = "select * from "+TABLE_NAME;
        String name = null;
        Cursor cursor = select(sql);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                name   =cursor.getString(cursor.getColumnIndex("name"));
                strings.add(name);
            }
        }
        return strings;
    }


    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected Map<String, String> getParamsMap() {
        return map;
    }
}
