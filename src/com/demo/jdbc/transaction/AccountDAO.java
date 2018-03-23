package com.demo.jdbc.transaction;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDAO {
    
    private JdbcTemplate jdbcTemplate;
    
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    public void update() throws Exception{

        //第四步:通过模板进行操作
        String str = "update t_account set money=money-1000 where username=?;";
        jdbcTemplate.update(str,"rose");
        System.out.println("操作成功。。。");
        
    }
    
    /**
     *  转账方 
     * */
    public void money_less(){
        String str = "update t_account set money=money-? where username=?;";
        jdbcTemplate.update(str,1000,"rose");
        System.out.println("转出成功。。。");
    }
    /**
     *  接收方 
     * */
    public void money_more(){
        String str = "update t_account set money=money+? where username=?;";
        jdbcTemplate.update(str,1000,"jack");
        System.out.println("接收成功。。。");
    }

}