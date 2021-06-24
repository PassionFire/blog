package com.ujiuye.pojo;

import java.io.Serializable;

public class Role implements Serializable {
    private Integer roleid;

    private String rolename;

    private String roledes;

    private static final long serialVersionUID = 1L;

    public Role(Integer roleid, String rolename, String roledes) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.roledes = roledes;
    }

    public Role() {
        super();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRoledes() {
        return roledes;
    }

    public void setRoledes(String roledes) {
        this.roledes = roledes == null ? null : roledes.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleid=").append(roleid);
        sb.append(", rolename=").append(rolename);
        sb.append(", roledes=").append(roledes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}