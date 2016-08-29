package com.bwf.framwork;

import com.bwf.framwork.db.model.RecordModel;
import com.bwf.framwork.db.model.UserModel;
import com.bwf.tuanche.homepage.Search.Search_Model;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description: 常量类
 */
public class Constants {

    public static final String ZBD_Test = "123";

    public static final String DB_NAME = "tuanche_db";//数据库名称
//    public static final String SEARCH_MODEL = "zhangdapao";//搜索页面数据库



    public static final int DB_VERSION = 1;//数据库版本
    public static Boolean  ISFIRST = true;//判断是否更新


    //数据库所有的表
    public static String[] TABLES = new String[]{UserModel.class.getName(), RecordModel.class.getName(),Search_Model.class.getName()};//总归表

}
