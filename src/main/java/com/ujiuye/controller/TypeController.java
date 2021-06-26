package com.ujiuye.controller;

import com.ujiuye.pojo.Type;
import com.ujiuye.service.TypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-22 11:33
 */
@RestController //相当于同时写了Controller和ResponseBody
@RequestMapping("/type")
public class TypeController {

    @Resource
    private TypeService typeService;

    //根据type_pid查询类别集合
    @GetMapping("/{type_pid}")
    public List<Type> getByBid(@PathVariable("type_pid") int type_pid){
        try {
            return typeService.listByPid(type_pid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping()
    public List<Type> list(){
        try {
            return typeService.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //增加
    @PostMapping()
    public Boolean save(@RequestBody Type type){
        try {
            typeService.save(type);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //修改
    @PutMapping()
    public Boolean update(@RequestBody Type type){
        try {
            typeService.update(type);
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
            typeService.remove(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //删除小类,将小类设为null
    @DeleteMapping("/smallType/{id}")
    public Boolean updateSmallType(@PathVariable("id") Integer id){
        try {
            typeService.updateSmallType(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
