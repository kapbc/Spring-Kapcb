package com.kapcb.ccc;

import com.kapcb.ccc.domain.Key;
import com.kapcb.ccc.domain.Lock;
import com.kapcb.ccc.mapper.KeyMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <a>Title:getLockByIdTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/5 18:56
 */
public class getLockByIdTest {
    public static void main(String[] args) throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatisContext.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        KeyMapper mapper = sqlSession.getMapper(KeyMapper.class);

        try {
            Lock lock = mapper.getLockById(3);
            List<Key> keys = lock.getKeys();
            System.out.println(lock);
            for (Key key : keys) {
                System.out.println(key);
            }
        } finally {
            sqlSession.close();
        }
    }
}
