package com.bwf.tuanche.homepage.entity;

/**
 * Created by wanli on 2016/8/17.
 * Description:
 * 低价购车
 */
public class Cheap_car_home {
    public int weight;

    public String name;

    public String pic;

    public boolean show;

    public int type;

    public int modules;

    public int is_ng;

    public int is_login;

    @Override
    public String toString() {
        return "Cheap_car_home{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", show=" + show +
                ", type=" + type +
                ", modules=" + modules +
                ", is_ng=" + is_ng +
                ", is_login=" + is_login +
                '}';
    }
}
