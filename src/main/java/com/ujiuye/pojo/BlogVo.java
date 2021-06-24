package com.ujiuye.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-22 16:40
 */
public class BlogVo implements Serializable {

    private Blog blog;//一个博客
    private User user;//一个博客对应一个作者
    private Type type;//一个博客对应一个类别
    private List<Evaluate> evaluateList;//一个博客对应多条评论

    public BlogVo() {
    }

    public BlogVo(Blog blog, User user, Type type) {
        this.blog = blog;
        this.user = user;
        this.type = type;
    }

    public BlogVo(Blog blog, User user, Type type, List<Evaluate> evaluateList) {
        this.blog = blog;
        this.user = user;
        this.type = type;
        this.evaluateList = evaluateList;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Evaluate> getEvaluateList() {
        return evaluateList;
    }

    public void setEvaluateList(List<Evaluate> evaluateList) {
        this.evaluateList = evaluateList;
    }
}
