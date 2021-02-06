package com.kapcb.ccc.mapper.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * <a>Title: IUserMapperImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/6 17:19
 */
@Repository(value = "userMapper")
public class IUserMapperImpl implements IUserMapper {


    @Autowired
    @Qualifier(value = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<User> getUserInfoList() {
        StringBuilder sqlStr = new StringBuilder();
        sqlStr.append("select * from tb_user");
        return jdbcTemplate.query(sqlStr.toString(), new RowMapper() {
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
                if (!Objects.equals(null, id)) {
                    user.setUserId(Long.valueOf(id));
                }
                user.setUsername(username);
                user.setPassword(password);
                user.setPhone(phone);
                user.setEmail(email);
                if (!Objects.equals(null, created)) {
                    user.setCreated(created.toLocalDateTime());
                }
                if (Objects.equals(null, updated)) {
                    user.setUpdated(updated.toLocalDateTime());
                }
                return user;
            }
        });
    }

    @Override
    public boolean insertUser(User user) {
        StringBuilder sqlStr = new StringBuilder();
        sqlStr.append("insert into tb_user(id,username,password,phone,email,created,updated) values(");
        sqlStr.append("?,?,?,?,?,?,?").append(")");
        System.out.println("insert user's sql string is : " + sqlStr.toString());
        Object[] args = new Object[]{user.getUserId(), user.getUsername(), user.getPassword(), user.getPhone(), user.getEmail(), user.getCreated(), user.getUpdated()};
        int update = jdbcTemplate.update(sqlStr.toString(), args);
        System.out.println("update = " + update);
        return update == 1;
    }
}
