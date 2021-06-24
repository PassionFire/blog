package com.ujiuye.pojo;

import java.io.Serializable;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-22 20:38
 */
public class UserVo implements Serializable {

    private User user;//一个用户
    private Role role;//一个用户对应一种角色

    public UserVo() {
    }

    public UserVo(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
