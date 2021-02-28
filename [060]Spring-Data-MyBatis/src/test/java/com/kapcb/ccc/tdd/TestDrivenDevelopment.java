package com.kapcb.ccc.tdd;

import com.kapcb.ccc.domain.Key;
import com.kapcb.ccc.domain.Lock;
import com.kapcb.ccc.mapper.KeyMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/28 10:21
 */
@ExtendWith(SpringExtension.class)
public class TestDrivenDevelopment {

    @Test
    public void testGetKeyById() {
        SqlSession sqlSession = null;
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession(true);
            KeyMapper mapper = sqlSession.getMapper(KeyMapper.class);
            Key key = mapper.getKeyById(1);
            System.out.println(key);
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetLockById() {
        SqlSession sqlSession = null;
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession(true);
            KeyMapper mapper = sqlSession.getMapper(KeyMapper.class);
            Lock lock = mapper.getLockById(3);
            List<Key> keys = lock.getKeys();
            System.out.println(lock);
            for (Key key : keys) {
                System.out.println(key);
            }
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } finally {
            sqlSession.close();
        }
    }
}
