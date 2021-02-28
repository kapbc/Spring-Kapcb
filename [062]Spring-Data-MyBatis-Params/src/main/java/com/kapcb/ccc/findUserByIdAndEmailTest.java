package com.kapcb.ccc;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title:findUserByIdAndEmailTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * map类型传值测试
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/3 23:57
 */
public class findUserByIdAndEmailTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-context.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", 1);
            map.put("email", "eircccallroot@163.com");
            User user = mapper.findUserByIdAndEmail(map);
            System.out.println(user);
        } finally {
            sqlSession.close();
        }

    }

}
