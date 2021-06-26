package com.ujiuye.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-25 20:46
 */
@Configuration
public class MD5 {

    //加密
    public static String md5(String upass){
        //加密后字符串
        return DigestUtils.md5DigestAsHex(upass.getBytes());
    }

    //验证密码是否正确
    public static boolean verify(String upass, String md5){
        //根据传入的密钥进行验证
        String md5Text = md5(upass);
        if(md5Text.equalsIgnoreCase(md5)){
            return true;
        }
        return false;
    }
}
