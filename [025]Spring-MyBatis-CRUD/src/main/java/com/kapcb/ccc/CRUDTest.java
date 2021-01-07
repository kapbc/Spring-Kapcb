package com.kapcb.ccc;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * <a>Title:CRUDTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/2 23:13
 */
public class CRUDTest {
    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //openSession(true)可以设置是否为自动i提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user1 = mapper.findUserById(1);
        System.out.println(user1);

        try {
            User user = new User();
            user.setId(null);
            user.setUsername("ccc");
            user.setGender("男");
            user.setEmail("eircccallroot@yeah.net");
            int i = mapper.addUser(user);
            System.out.println("影响了" + i);
        } finally {
            //手动提交
            //sqlSession.commit();
            sqlSession.close();
        }
    }
}
