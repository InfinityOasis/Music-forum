/**
 * FileName: comment
 * Author:   陈江超
 * Date:     2019/7/24 17:41
 * Description: 评论
 */
package com.github.domain;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈评论〉
 *
 * @author 陈江超
 * @create 2019/7/24
 * @since 1.0.0
 */
public class comment {
    /**
     * textid 被评论文章id
     * userid 评论用户的email
     * time 评论文章发表时间
     * likes 评论被点赞数
     * comment 评论被评论数
     * collection 评论被收藏数
     * text 评论内容
     * title 评论标题（一般没有，只是为了保证封装数据的完整性）
     */
    private int textid;
    private String userid;
    private String time;
    private int likes;
    private int comment;
    private int collection;
    private String text;
    private String title;
    private String type;
    private String textimage;

    public String getTextimage() {
        return textimage;
    }

    public void setTextimage(String textimage) {
        this.textimage = textimage;
    }

    public int getTextid() {
        return textid;
    }

    public void setTextid(int textid) {
        this.textid = textid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "comment{" +
                "textid=" + textid +
                ", userid='" + userid + '\'' +
                ", time='" + time + '\'' +
                ", likes=" + likes +
                ", comment=" + comment +
                ", collection=" + collection +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", textimage='" + textimage + '\'' +
                '}';
    }
}
