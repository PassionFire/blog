package com.ujiuye.service.impl;

import com.ujiuye.mapper.TypeMapper;
import com.ujiuye.pojo.Type;
import com.ujiuye.pojo.TypeExample;
import com.ujiuye.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-23 14:33
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeMapper typeMapper;

    @Override
    public List<Type> listByPid(int type_pid) {
        TypeExample typeExample = new TypeExample();
        if (type_pid==0){
            typeExample.createCriteria().andTypePidIsNull();
        }else {
            typeExample.createCriteria().andTypePidEqualTo(type_pid);
        }
        List<Type> types = typeMapper.selectByExample(typeExample);
        return types;
    }

    @Override
    public List<Type> list() {
        //查询父菜单
        List<Type> typeList = listByPid(0);
        if (typeList!=null && typeList.size()>0){
            for (Type type : typeList) {
                //查询大类别下有什么子类
                List<Type> types = listByPid(type.getTypeid());
                //把查询到的子类放入父类别中
                type.setTypeList(types);
            }
        }
        return typeList;
    }


}
