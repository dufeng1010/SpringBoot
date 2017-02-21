package com.dufeng.goal.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.dufeng.goal.domain.User;

@Service
public class IndexService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Cacheable("users")
    public List<User> getUsers() {
        return jdbcTemplate.query("select date, new_usercount, total_usercount from userstatinfo", new RowMapper(){

            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setDate(rs.getString("date"));
                user.setNewUserCount(rs.getLong("new_usercount"));
                user.setUserCount(rs.getLong("total_usercount"));
                return user;
            }
        });      
    }
}
