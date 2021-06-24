package com.ujiuye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.mapper.BlogMapper;
import com.ujiuye.mapper.EvaluateMapper;
import com.ujiuye.mapper.TypeMapper;
import com.ujiuye.mapper.UserMapper;
import com.ujiuye.pojo.*;
import com.ujiuye.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: zwp
 * @version: 1.0
 * @create 2021-06-22 11:31
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private TypeMapper typeMapper;
    @Resource
    private EvaluateMapper evaluateMapper;

    //分页查询
    @Override
    public PageInfo<BlogVo> list(int pageNum,int pageSize,String title, String author) {

        //创建id数组,用于存放用户输入的作者对应的id
        List<Integer> ids = new ArrayList<>();
        //查询一下user表,看看有没有用户输入的作者
        if (author!=null && author.length()>0){
            //创建user查询条件
            UserExample userExample = new UserExample();
            //条件作者模糊查
            userExample.createCriteria().andNameLike("%"+author+"%");
            //根据作者模糊查
            List<User> userList = userMapper.selectByExample(userExample);
            //判断是否查询到作者
            if (userList!=null && userList.size()>0){
                for (User user : userList) {
                    //将作者对应的id存入ids集合中
                    ids.add(user.getId());
                }
            }
        }

        //创建blog查询条件
        BlogExample blogExample = new BlogExample();
        //判断标题是否为空
        if (title!=null && title.length()>0){
            //标题模糊查
            blogExample.or().andTitleLike("%"+title+"%");
        }
        //判断是否查到作者
        if (ids.size()>0){
            //in ids
            blogExample.or().andBidIn(ids);
        }
        
        //设置分页
        PageHelper.startPage(pageNum,pageSize);
        //查询blog
        List<Blog> blogList = blogMapper.selectByExample(blogExample);
        //创建Blog分页信息
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blogList);
        //创建BlogVo分页信息
        PageInfo<BlogVo> blogVoPageInfo = new PageInfo<>();
        //将Blog分页信息复制给BlogVo分页信息
        BeanUtils.copyProperties(blogPageInfo,blogVoPageInfo);

        //创建存放BlogVo的集合
        List<BlogVo> blogVoList = new ArrayList<>();
        //查询每个博客的类别、作者、评论
        if (blogList!=null && blogList.size()>0){
            for (Blog blog : blogList) {
                //查询这个博客对应的作者
                User user = userMapper.selectByPrimaryKey(blog.getuFk());
                //查询这个博客对应的类别
                Type type = typeMapper.selectByPrimaryKey(blog.getTypeFk());
                //查询这个博客对应的评论
                BlogVo blogVo = new BlogVo(blog,user,type);
                blogVoList.add(blogVo);
            }
        }

        //集合的数据不对，改成BlogVo
        blogVoPageInfo.setList(blogVoList);
        return blogVoPageInfo;
    }

    @Override
    public BlogVo getByBid(Integer bid) {
        Blog blog = blogMapper.selectByPrimaryKey(bid);
        if (blog != null){
            //查询这个博客对应的作者
            User user = userMapper.selectByPrimaryKey(blog.getuFk());
            //查询这个博客对应的类别
            Type type = typeMapper.selectByPrimaryKey(blog.getTypeFk());
            //查询这个博客对应的评论
            EvaluateExample evaluateExample = new EvaluateExample();
            evaluateExample.createCriteria().andBFkEqualTo(blog.getBid());
            List<Evaluate> evaluateList = evaluateMapper.selectByExample(evaluateExample);
            //判断评价列表是否为空
            if (evaluateList!=null && evaluateList.size()>0){
                //遍历
                for (Evaluate evaluate : evaluateList) {
                    User user1 = userMapper.selectByPrimaryKey(evaluate.getuFk());
                    evaluate.setUser(user1);
                }
            }
            BlogVo blogVo = new BlogVo(blog,user,type,evaluateList);
            return blogVo;
        }
        return null;
    }

    @Override
    public int save(Blog blog) {
        blog.setuFk(1);//以后实现了登录从session中获取
        blog.setDate(new Date());
        return blogMapper.insert(blog);
    }

    @Override
    public int update(Blog blog) {
        return blogMapper.updateByPrimaryKeySelective(blog);
    }

    @Override
    public int remove(Integer bid) {
        return blogMapper.deleteByPrimaryKey(bid);
    }
}
