package com.ujiuye.controller;

import com.github.pagehelper.PageInfo;
import com.ujiuye.pojo.User;
import com.ujiuye.pojo.UserSearch;
import com.ujiuye.pojo.UserVo;
import com.ujiuye.service.UserService;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @Resource
    private HttpServletRequest request;

    //登录
    @RequestMapping("/login/{uname}/{upass}")
    public Boolean login(@PathVariable("uname") String uname,@PathVariable("upass") String upass){
        //根据名字查询用户
        List<User> userList = userService.findUserByName(uname);
        //md5密码加密
        String md5Pass = DigestUtils.md5DigestAsHex(upass.getBytes());
        HttpSession session = request.getSession();
        //判断用户是否为空
        if (userList!=null && userList.size()>0){
            for (User user : userList) {
                //判断数据库密码是否加密过
                //加密过
                if (user.getPassword().equals(md5Pass)){
                    //登录成功,把数据放入session中
                    session.setAttribute("user",user);
                    return true;
                }
                //没加密过
                else {
                    if (user.getPassword().equals(upass)){
                        //登录成功,把数据放入session中
                        session.setAttribute("user",user);
                        //数据库更新用户密码
                        user.setPassword(md5Pass);
                        userService.update(user);
                        return true;
                    }else {
//                        request.setAttribute("msg","密码错误");
                        return false;
                    }
                }
            }
        }
//        request.setAttribute("msg","用户不存在");
       return false;
    }

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
