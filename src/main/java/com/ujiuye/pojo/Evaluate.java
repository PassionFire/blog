package com.ujiuye.pojo;

import java.io.Serializable;
import java.util.Date;

public class Evaluate implements Serializable {
    private Integer id;

    private String content;

    private Integer bFk;

    private Integer uFk;

    private Date addtime;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private static final long serialVersionUID = 1L;

    public Evaluate(Integer id, String content, Integer bFk, Integer uFk, Date addtime) {
        this.id = id;
        this.content = content;
        this.bFk = bFk;
        this.uFk = uFk;
        this.addtime = addtime;
    }

    public Evaluate() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getbFk() {
        return bFk;
    }

    public void setbFk(Integer bFk) {
        this.bFk = bFk;
    }

    public Integer getuFk() {
        return uFk;
    }

    public void setuFk(Integer uFk) {
        this.uFk = uFk;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", content=").append(content);
        sb.append(", bFk=").append(bFk);
        sb.append(", uFk=").append(uFk);
        sb.append(", addtime=").append(addtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}