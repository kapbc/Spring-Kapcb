package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <a>Title:TeacherMapper</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/5 19:54
 */
public interface TeacherMapper {

    /**
     * 根据id查询老师
     *
     * @param id id
     * @return Teacher
     */
    public Teacher getTeacherById(int id);

    /**
     * 模糊条件查询
     *
     * @param teacher Teacher
     * @return List<Teacher>
     */
    public List<Teacher> getTeacherByQuery(Teacher teacher);

    /**
     * 条件二选一查询
     *
     * @param teacher Teacher
     * @return List<Teacher>
     */
    public List<Teacher> getTeacherByOne(Teacher teacher);


    /**
     * 根据id批量查询
     *
     * @param ids ids
     * @return List<Teacher>
     */
    public List<Teacher> getAllTeacherByQueryId(List<Integer> ids);


}
