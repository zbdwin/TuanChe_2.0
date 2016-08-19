package com.bwf.tuanche.homepage.entity.Banner;

import java.io.Serializable;

/**
 * Description：
 */
public class BannerBean implements Serializable{
    public String id;

    public String adName;

    public String channelType;

    public String beginVersion;

    public String position;

    public String priority;

    public String adImgUrl;

    public String description;

    public String shareTitle;

    public String shareImgUrl;

    public String shareUrl;

    public String city;

    public String begStringime;

    public String endTime;

    public String adType;

    public String pageType;

    public String adParam;

    public String adInfoUrl;

    public String adStatus;

    public String isDelete;

    public String createTime;

    public String createUserId;

    public String updateTime;

    public String updateUserId;

    @Override
    public String toString() {
        return "BannerBean{" +
                "id='" + id + '\'' +
                ", adName='" + adName + '\'' +
                ", channelType='" + channelType + '\'' +
                ", beginVersion='" + beginVersion + '\'' +
                ", position='" + position + '\'' +
                ", priority='" + priority + '\'' +
                ", adImgUrl='" + adImgUrl + '\'' +
                ", description='" + description + '\'' +
                ", shareTitle='" + shareTitle + '\'' +
                ", shareImgUrl='" + shareImgUrl + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", city='" + city + '\'' +
                ", begStringime='" + begStringime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", adType='" + adType + '\'' +
                ", pageType='" + pageType + '\'' +
                ", adParam='" + adParam + '\'' +
                ", adInfoUrl='" + adInfoUrl + '\'' +
                ", adStatus='" + adStatus + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ", createTime='" + createTime + '\'' +
                ", createUserId='" + createUserId + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateUserId='" + updateUserId + '\'' +
                ", picShowType='" + picShowType + '\'' +
                '}';
    }

    public String picShowType;
}
