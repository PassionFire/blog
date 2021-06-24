package com.ujiuye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.mapper.RoleMapper;
import com.ujiuye.mapper.UserMapper;
import com.ujiuye.pojo.Role;
import com.ujiuye.pojo.User;
import com.ujiuye.pojo.UserExample;
import com.ujiuye.pojo.UserVo;
import com.ujiuye.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-22 20:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;

    @Override
    public PageInfo<UserVo> list(int pageNum, int pageSize,String name,String email) {

        //创建用户example查询条件
        UserExample userExample = new UserExample();
        //判断用户名是否为空
        if (name!=null && name.length()>0){
            userExample.or().andNameLike("%"+name+"%");
        }
        //判断邮箱是否为空
        if (email!=null && email.length()>0){
            userExample.or().andEmailLike("%"+email+"%");
        }
        //设置分页
        PageHelper.startPage(pageNum,pageSize);
        //查询用户
        List<User> userList = userMapper.selectByExample(userExample);
        //创建User分页信息
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        //创建UserVo分页信息
        PageInfo<UserVo> userVoPageInfo = new PageInfo<>();
        //将User分页信息复制给UserVo分页信息
        BeanUtils.copyProperties(userPageInfo,userVoPageInfo);

        //创建存放UserVo的集合
        List<UserVo> userVoList = new ArrayList<>();
        //判断userList是否为空
        if (userList.size() > 0){
            for (User user : userList) {
                //根据作者的type获取对应的角色
                Role role = roleMapper.selectByPrimaryKey(user.getType());
                //将user、role赋给userVo
                UserVo userVo = new UserVo(user, role);
                //将userVo加入到集合中
                userVoList.add(userVo);
            }
        }

        //集合的数据不对，改成userVo
        userVoPageInfo.setList(userVoList);
        return userVoPageInfo;
    }

    @Override
    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int save(User user) {
        user.setAddtime(new Date());
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int remove(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
