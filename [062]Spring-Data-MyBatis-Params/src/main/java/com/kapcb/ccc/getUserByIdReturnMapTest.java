package com.kapcb.ccc;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

/**
 * <a>Title:getUserByIdReturnMapTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/5 13:03
 */
public class getUserByIdReturnMapTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("spring/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        try {
            Map<Integer, User> userMap = mapper.getUserByIdReturnMap();
            Set<Map.Entry<Integer, User>> entries = userMap.entrySet();
            for (Map.Entry<Integer, User> entry : entries) {
                User value = entry.getValue();
                Integer key = entry.getKey();
                System.out.println(key);
                System.out.println(value);
            }
        } finally {
            sqlSession.close();
        }
    }
}
