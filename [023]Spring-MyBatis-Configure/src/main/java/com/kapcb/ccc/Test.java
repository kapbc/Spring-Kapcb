package com.kapcb.ccc;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * <a>Title:Test</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/3 9:57
 */
public class Test {
    public static void main(String[] args) throws IOException {

        /**
         * 1.根据全局配置文件创建一个 SqlSessionFactory
         * SqlSessionFactory就是SqlSession的工厂，他是负责创建SqlSession对象
         * SqlSession：sql会话，代表和数据库的一次会话
         * Resources:org.apache.ibatis.io.Resources包下的
         */

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        /**
         * 2.获取和数据库的一次会话，相当于getConnection()；方法
         */
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /**
         * 3.使用sqlSession操作数据库，获取到mapper接口的实现
         */
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        /**
         * 4.拿到接口实现之后调用方法即可
         */
        User user = mapper.findUserById(1);
        //获取接口对象类型
        System.out.println(mapper.getClass());
        System.out.println(user);
    }
}
