package com.kapcb.ccc;

import com.kapcb.ccc.domain.Teacher;
import com.kapcb.ccc.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <a>Title:getTeacherByQueryTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/5 20:19
 */
public class getTeacherByQueryTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("spring/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        try {
            Teacher teacher = new Teacher();
            teacher.setName("%a%");
            teacher.setAddress("区");
            List<Teacher> teacherByQuery = mapper.getTeacherByQuery(teacher);
            for (Teacher teacher1 : teacherByQuery) {
                System.out.println(teacher1);
            }
        } finally {
            sqlSession.close();
        }
    }
}
