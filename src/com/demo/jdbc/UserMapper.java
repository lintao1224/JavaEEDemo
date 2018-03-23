package com.demo.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.bean.TUser;

public class UserMapper implements RowMapper<TUser>{

    @Override
    public TUser mapRow(ResultSet resultSet, int rows) throws SQLException {
    	TUser user = new TUser();
        user.setUname(resultSet.getString(1));
        user.setUpass(resultSet.getString(2));

        return user;
    }

}