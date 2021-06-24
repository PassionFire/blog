package com.ujiuye.controller;

import com.ujiuye.pojo.Role;
import com.ujiuye.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-22 11:33
 */
@RestController //相当于同时写了Controller和ResponseBody
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping()
    public List<Role> list(){
        try {
            return roleService.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
