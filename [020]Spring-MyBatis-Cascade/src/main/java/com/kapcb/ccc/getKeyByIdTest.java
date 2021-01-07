package com.kapcb.ccc;

import com.kapcb.ccc.domain.Key;
import com.kapcb.ccc.mapper.KeyMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * <a>Title:getKeyByIdTets</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/5 16:50
 */
public class getKeyByIdTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatisContext.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        KeyMapper mapper = sqlSession.getMapper(KeyMapper.class);
        try {
            Key key = mapper.getKeyById(1);
            System.out.println(key);
        } finally {
            sqlSession.close();
        }
    }
}
