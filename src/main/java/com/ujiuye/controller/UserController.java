package com.ujiuye.controller;

import com.github.pagehelper.PageInfo;
import com.ujiuye.pojo.User;
import com.ujiuye.pojo.UserSearch;
import com.ujiuye.pojo.UserVo;
import com.ujiuye.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-22 11:33
 */
@RestController //相当于同时写了Controller和ResponseBody
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //分页+模糊查
    @PostMapping("/{pageNum}/{pageSize}")
    public PageInfo<UserVo> list(@PathVariable("pageSize") int pageSize, @PathVariable("pageNum") int pageNum,@RequestBody UserSearch userSearch){
        try {
            return userService.list(pageNum, pageSize,userSearch.getName(),userSearch.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据id查单个
    @GetMapping("/{id}")
    public User getByBid(@PathVariable("id") int id){
        try {
            return userService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //增加
    @PostMapping()
    public Boolean save(@RequestBody User user){
        try {
            userService.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //修改
    @PutMapping()
    public Boolean update(@RequestBody User user){
        try {
            userService.update(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //删除
    @DeleteMapping("/{id}")
    public Boolean remove(@PathVariable("id") Integer id){
        try {
            userService.remove(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
