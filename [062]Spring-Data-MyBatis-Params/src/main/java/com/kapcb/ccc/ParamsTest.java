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
 * <a>Title:ParamsTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * 多参数传参测试
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/3 23:32
 */
public class ParamsTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("spring/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        try {
            User kapcb = mapper.findUserByIdAndUsername(1, "kapcb");
            System.out.println(kapcb);
        } finally {
            sqlSession.close();
        }
    }
}