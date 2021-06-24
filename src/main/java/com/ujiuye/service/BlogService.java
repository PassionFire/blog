package com.ujiuye.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.pojo.Blog;
import com.ujiuye.pojo.BlogVo;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-22 11:24
 */
public interface BlogService {

    //title 标题, author 作者
    PageInfo<BlogVo> list(int pageNum,int pageSize,String title, String author);

    //查单个
    BlogVo getByBid(Integer bid);

    //增加
    int save(Blog blog);

    //修改
    int update(Blog blog);

    //删除
    int remove(Integer bid);
}
