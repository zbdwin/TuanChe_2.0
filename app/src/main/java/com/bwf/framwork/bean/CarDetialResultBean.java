package com.bwf.framwork.bean;

import com.bwf.framwork.base.BaseBean;

import java.util.List;

/**
 * Created by admin on 17/08/2016.
 */
public class CarDetialResultBean extends BaseBean{
    public List<CarDetialResultBean.CommentList> commentList;

    public String commentTotal;

    public String offset;

    public String count;

    public String salerScore;

    public String priceScore;

    public String shopScore;

    @Override
    public String toString() {
        return "Root{" +
                "commentList=" + commentList +
                ", commentTotal='" + commentTotal + '\'' +
                ", offset='" + offset + '\'' +
                ", count='" + count + '\'' +
                ", salerScore='" + salerScore + '\'' +
                ", priceScore='" + priceScore + '\'' +
                ", shopScore='" + shopScore + '\'' +
                '}';
    }
    public class CommentList {
        public List<CarDetialResultBean.CommentList.CommentPicList> commentPicList;

        public String memberPic;

        public int score;

        public String commentDate;

        public String userName;

        public String content;

        public boolean fine;

        @Override
        public String toString() {
            return "CommentList{" +
                    "commentPicList=" + commentPicList +
                    ", memberPic='" + memberPic + '\'' +
                    ", score=" + score +
                    ", commentDate='" + commentDate + '\'' +
                    ", userName='" + userName + '\'' +
                    ", content='" + content + '\'' +
                    ", fine=" + fine +
                    '}';
        }
        public class CommentPicList{
        }
    }
}

