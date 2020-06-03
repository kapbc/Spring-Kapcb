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
 * <a>Title:RandomKeyTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/3 22:58
 */
public class RandomKeyTest {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-context.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        try {
            User user = new User(null, "aaa", "男", "123456@qq.com", "ddsds");
            mapper.insertRandomIdUser(user);
            Integer id = user.getId();
            System.out.println("获取的非自增主键为：" + id);
        } finally {
            sqlSession.close();
        }
    }
}
