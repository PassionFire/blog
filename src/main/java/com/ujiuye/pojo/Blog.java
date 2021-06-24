package com.ujiuye.pojo;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    private Integer bid;

    private String title;

    private Integer typeFk;

    private Integer uFk;

    private Date date;

    private String content;

    private static final long serialVersionUID = 1L;

    public Blog(Integer bid, String title, Integer typeFk, Integer uFk, Date date) {
        this.bid = bid;
        this.title = title;
        this.typeFk = typeFk;
        this.uFk = uFk;
        this.date = date;
    }

    public Blog(Integer bid, String title, Integer typeFk, Integer uFk, Date date, String content) {
        this.bid = bid;
        this.title = title;
        this.typeFk = typeFk;
        this.uFk = uFk;
        this.date = date;
        this.content = content;
    }

    public Blog() {
        super();
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getTypeFk() {
        return typeFk;
    }

    public void setTypeFk(Integer typeFk) {
        this.typeFk = typeFk;
    }

    public Integer getuFk() {
        return uFk;
    }

    public void setuFk(Integer uFk) {
        this.uFk = uFk;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bid=").append(bid);
        sb.append(", title=").append(title);
        sb.append(", typeFk=").append(typeFk);
        sb.append(", uFk=").append(uFk);
        sb.append(", date=").append(date);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}