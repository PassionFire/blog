package com.ujiuye.controller;

import com.github.pagehelper.PageInfo;
import com.ujiuye.pojo.Blog;
import com.ujiuye.pojo.BlogVo;
import com.ujiuye.pojo.Search;
import com.ujiuye.service.BlogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-22 11:33
 */
@RestController //相当于同时写了Controller和ResponseBody
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    //分页+模糊查
    @PostMapping("/{pageNum}/{pageSize}")
    public PageInfo<BlogVo> list(@PathVariable("pageSize") int pageSize, @PathVariable("pageNum") int pageNum,@RequestBody Search search){
        try {
            return blogService.list(pageNum, pageSize, search.getTitle(),search.getAuthor());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据id查单个
    @GetMapping("/{bid}")
    public BlogVo getByBid(@PathVariable("bid") int bid){
        try {
            return blogService.getByBid(bid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //增加
    @PostMapping()
    public Boolean save(@RequestBody Blog blog){
        try {
            blogService.save(blog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //修改
    @PutMapping()
    public Boolean update(@RequestBody Blog blog){
        try {
            blogService.update(blog);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //删除
    @DeleteMapping("/{bid}")
    public Boolean remove(@PathVariable("bid") Integer bid){
        try {
            blogService.remove(bid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
