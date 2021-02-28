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
 * <a>Title:getTeacherByOneTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/5 21:17
 */
public class getTeacherByOneTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("spring/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        try {
            Teacher teacher = new Teacher();
//            teacher.setName("admin");
//            teacher.setAddress("区");
            List<Teacher> teacherByOne = mapper.getTeacherByOne(teacher);
            for (Teacher teacher1 : teacherByOne) {
                System.out.println(teacher1);
            }
        } finally {
            sqlSession.close();
        }
    }
}
