package com.demo.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.bean.TUser;

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(TUser user) {
        String sql = "insert into t_user (uname, upass) values (?, ?)";
        jdbcTemplate.update(sql, user.getUname(), user.getUpass());

    }
    public void deleteUser(String uname ) {
    	      String sql = "delete from t_user where uname= ?";
    	      jdbcTemplate.update(sql, uname);
    	  }
    public void updateUser(TUser user) {
    	       String sql = "update t_user set uname=? where uname= ?";
    	       jdbcTemplate.update(sql,  user.getUname() + "_new", user.getUname());
    	   }

}