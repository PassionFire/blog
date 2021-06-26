package com.ujiuye.test;

import com.ujiuye.utils.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-25 20:54
 */
@ContextConfiguration("classpath:spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMd5 {

    @Test
    public void contextLoads() {
        String text = "123456";
        System.out.println(MD5.md5("e10adc3949ba59abbe56e057f20f883e"));
        System.out.println("123456加密后为"+MD5.md5(text));
        System.out.println(MD5.verify(text, "e10adc3949ba59abbe56e057f20f883e"));
        System.out.println("-------------------------");
        System.out.println("123加密后为"+MD5.md5("123"));
        System.out.println(MD5.verify("123","202cb962ac59075b964b07152d234b70"));
    }
}
