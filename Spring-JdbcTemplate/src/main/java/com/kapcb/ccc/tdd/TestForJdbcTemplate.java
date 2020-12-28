package com.kapcb.ccc.tdd;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.utils.JdbcRowMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * <a>Title: Test </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/28 - 22:13
 */
public class TestForJdbcTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public static void main(String[] args) {
//        Map<String, String> resultMap = new HashMap<>(16);
//        resultMap.put("id", "123456");
//        resultMap.put("username", "kapcb");
//        resultMap.put("loginname", "ccc");
//        resultMap.put("address", "12345");
//        resultMap.put("sex", "1");
//        resultMap.put("remark", "dad");
//        resultMap.put("password", "123456");
//        resultMap.put("deptId", "1");
//        resultMap.put("hiredate", "123");
//        resultMap.put("mgr", "1234");
//        resultMap.put("available", "1");
//        resultMap.put("orderNum", "1");
//        resultMap.put("type", "11111");
//        resultMap.put("imagePath", "22222");
//        resultMap.put("salt", "3333");
//        JdbcRowMapper instance = JdbcRowMapper.getInstance();
//
//        instance.getResultMap(User.class, resultMap);
//
//
//    }
}
