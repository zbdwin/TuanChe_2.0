package com.bwf.framwork.bean;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by admin on 17/08/2016.
 */
public class CarDetialResultBean1{
    public String commentTotal;
    public String regular4sShop;
    public String isFree;
    public String isLowest;
    public String isPriorityBy4S;
    public String isAllFree;
    public Comment comment;
    public String groupbuyDate;
    public String groupbuyWeek;
    public String salerId;
    public String id;
    public String logo;
    public String styleName;
    public String factoryPrice;
    public String content;
    public String isBuy;
    public String manNum;
    public String state;
    public String isCompensate;
    public String addUp;
    public String brandLogo;
    public String flowUrl;
    public String questionUrl;
    public BuyWays buyWays;
    public String manNumDesc;
    public String brandName;
    public String brandPic;
    public SsgTz ssgTz;
    public String passNum;
    public String brandGroupStyleNum;
    public String brandGroupStyleManNum;
    public String shareBrandTitle;
    public String shareStyleTitle;
    public String shareDesc;
    public String shareBrandUrl;
    public String shareStyleUrl;
    public String tcbzDesc;
    public String brandId;
    public String styleId;
    public String saveUpString;
    public String saveUpMoney;
    public String special;

    @Override
    public String toString() {
        return "CarDetialResultBean1{" +
                "commentTotal='" + commentTotal + '\'' +
                ", regular4sShop='" + regular4sShop + '\'' +
                ", isFree='" + isFree + '\'' +
                ", isLowest='" + isLowest + '\'' +
                ", isPriorityBy4S='" + isPriorityBy4S + '\'' +
                ", isAllFree='" + isAllFree + '\'' +
                ", comment=" + comment +
                ", groupbuyDate='" + groupbuyDate + '\'' +
                ", groupbuyWeek='" + groupbuyWeek + '\'' +
                ", salerId='" + salerId + '\'' +
                ", id='" + id + '\'' +
                ", logo='" + logo + '\'' +
                ", styleName='" + styleName + '\'' +
                ", factoryPrice='" + factoryPrice + '\'' +
                ", content='" + content + '\'' +
                ", isBuy='" + isBuy + '\'' +
                ", manNum='" + manNum + '\'' +
                ", state='" + state + '\'' +
                ", isCompensate='" + isCompensate + '\'' +
                ", addUp='" + addUp + '\'' +
                ", brandLogo='" + brandLogo + '\'' +
                ", flowUrl='" + flowUrl + '\'' +
                ", questionUrl='" + questionUrl + '\'' +
                ", buyWays=" + buyWays +
                ", manNumDesc='" + manNumDesc + '\'' +
                ", brandName='" + brandName + '\'' +
                ", brandPic='" + brandPic + '\'' +
                ", ssgTz=" + ssgTz +
                ", passNum='" + passNum + '\'' +
                ", brandGroupStyleNum='" + brandGroupStyleNum + '\'' +
                ", brandGroupStyleManNum='" + brandGroupStyleManNum + '\'' +
                ", shareBrandTitle='" + shareBrandTitle + '\'' +
                ", shareStyleTitle='" + shareStyleTitle + '\'' +
                ", shareDesc='" + shareDesc + '\'' +
                ", shareBrandUrl='" + shareBrandUrl + '\'' +
                ", shareStyleUrl='" + shareStyleUrl + '\'' +
                ", tcbzDesc='" + tcbzDesc + '\'' +
                ", brandId='" + brandId + '\'' +
                ", styleId='" + styleId + '\'' +
                ", saveUpString='" + saveUpString + '\'' +
                ", saveUpMoney='" + saveUpMoney + '\'' +
                ", special='" + special + '\'' +
                '}';
    }

    public class SsgTz{

    }
    public class BuyWays{
        public List<BuyWayList> buyWayList ;

        public String showWhere;

        public String isMust;

        @Override
        public String toString() {
            return "BuyWays{" +
                    "buyWayList=" + buyWayList +
                    ", showWhere=" + showWhere +
                    ", isMust=" + isMust +
                    '}';
        }
        public class BuyWayList{
            public String name;

            public String value;

            @Override
            public String toString() {
                return "BuyWayList{" +
                        "name='" + name + '\'' +
                        ", value='" + value + '\'' +
                        '}';
            }
        }
    }
    public class Comment {
    public String count;

    public String commentTotal;

    public List<CarDetialResultBean1.Comment.CommentList> commentList ;

    @Override
    public String toString() {
        return "Comment{" +
                "count=" + count +
                ", commentTotal=" + commentTotal +
                ", commentList=" + commentList +
                '}';
    }
    public class CommentList {
        public String userName;
        public String commentDate;
        public String score;
        public String content;
        public String memberPic;
        public List<CarDetialResultBean1.Comment.CommentList.CommentPicList> commentPicList ;
        public String fine;

        @Override
        public String toString() {
            return "CommentList{" +
                    "userName='" + userName + '\'' +
                    ", commentDate='" + commentDate + '\'' +
                    ", score='" + score + '\'' +
                    ", content='" + content + '\'' +
                    ", memberPic='" + memberPic + '\'' +
                    ", commentPicList=" + commentPicList +
                    ", fine='" + fine + '\'' +
                    '}';
        }
        public class CommentPicList{
        }
    }
}


}
