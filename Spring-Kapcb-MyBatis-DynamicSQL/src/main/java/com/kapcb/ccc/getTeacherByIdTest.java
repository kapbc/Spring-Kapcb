package com.kapcb.ccc;

import com.kapcb.ccc.domain.Teacher;
import com.kapcb.ccc.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * <a>Title:getTeacherByIdTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/5 20:05
 */
public class getTeacherByIdTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatisContext.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        try {
            Teacher teacher = mapper.getTeacherById(1);
            System.out.println(teacher);
        } finally {
            sqlSession.close();
        }
    }


}

