package com.ujiuye.service.impl;

import com.ujiuye.mapper.RoleMapper;
import com.ujiuye.pojo.Role;
import com.ujiuye.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-23 20:43
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> list() {
        List<Role> roles = roleMapper.selectByExample(null);
        return roles;
    }
}
