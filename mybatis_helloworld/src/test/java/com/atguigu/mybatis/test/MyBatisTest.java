package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @date 2023/5/15
 */
public class MyBatisTest {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //获取sqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //获取 sqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //获取 SQL 的回话对象 sqlSession，是 MyBatis 提供的操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取 UserMapper 的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用 mapper 接口中的方法，实现添加用户信息的功能
        int result = mapper.insertUser();
        System.out.println("结果：" + result);
        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }
}
