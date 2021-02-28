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
 * <a>Title:findUserByIdAndGenderTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * 基于注解的多参数传参
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/3 23:50
 */
public class findUserByIdAndGenderTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("spring/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        try {
            User user = mapper.findUserByIdAndGender(1, "男");
            System.out.println(user);
        } finally {
            sqlSession.close();
        }

    }
}
