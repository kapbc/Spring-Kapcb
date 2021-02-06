package com.kapcb.ccc.mapper.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * <a>Title: IUserMapperImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/6 17:19
 */
public class IUserMapperImpl implements IUserMapper {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<User> getUserInfoList() {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from tb_user");
        jdbcTemplate.query(sb.toString(), new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                Timestamp created = resultSet.getTimestamp("created");
                Timestamp updated = resultSet.getTimestamp("updated");


                return null;
            }
        })
    }
}
