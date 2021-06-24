package com.ujiuye.pojo;

import java.io.Serializable;
import java.util.List;

public class Type implements Serializable {
    private Integer typeid;

    private String typename;

    private Integer typePid;

    private String typedes;

    private List<Type> typeList;

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    private static final long serialVersionUID = 1L;

    public Type(Integer typeid, String typename, Integer typePid, String typedes) {
        this.typeid = typeid;
        this.typename = typename;
        this.typePid = typePid;
        this.typedes = typedes;
    }

    public Type() {
        super();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Integer getTypePid() {
        return typePid;
    }

    public void setTypePid(Integer typePid) {
        this.typePid = typePid;
    }

    public String getTypedes() {
        return typedes;
    }

    public void setTypedes(String typedes) {
        this.typedes = typedes == null ? null : typedes.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typeid=").append(typeid);
        sb.append(", typename=").append(typename);
        sb.append(", typePid=").append(typePid);
        sb.append(", typedes=").append(typedes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}