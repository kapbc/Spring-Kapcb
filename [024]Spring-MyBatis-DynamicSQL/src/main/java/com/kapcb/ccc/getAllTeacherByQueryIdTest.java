package com.kapcb.ccc;

import com.kapcb.ccc.domain.Teacher;
import com.kapcb.ccc.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title:getAllTeacherByQueryIdTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/6 18:59
 */
public class getAllTeacherByQueryIdTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatisContext.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        try {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(2);
            list.add(3);
            List<Teacher> allTeacherByQueryId = mapper.getAllTeacherByQueryId(list);
            allTeacherByQueryId.stream().forEach(System.out::println);
        } finally {
            sqlSession.close();
        }
    }
}
