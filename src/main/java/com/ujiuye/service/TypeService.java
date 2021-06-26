package com.ujiuye.service;

import com.ujiuye.pojo.Type;

import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-23 14:33
 */
public interface TypeService {

    List<Type> listByPid(int type_pid);

    List<Type> list();

    int save(Type type);

    int remove(Integer typeid);

    //删除小类，将小类设为空
    int updateSmallType(Integer typeid);

    int update(Type type);
}
