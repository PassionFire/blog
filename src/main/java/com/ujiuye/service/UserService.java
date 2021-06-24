package com.ujiuye.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.pojo.User;
import com.ujiuye.pojo.UserVo;


/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-22 11:24
 */
public interface UserService {

    //分页查询所有
    PageInfo<UserVo> list(int pageNum, int pageSize,String name,String email);

    //查单个
    User getById(Integer id);

    //增加
    int save(User user);

    //修改
    int update(User user);

    //删除
    int remove(Integer id);
}
