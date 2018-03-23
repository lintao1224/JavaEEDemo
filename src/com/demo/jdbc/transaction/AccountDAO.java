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

        //���Ĳ�:ͨ��ģ����в���
        String str = "update t_account set money=money-1000 where username=?;";
        jdbcTemplate.update(str,"rose");
        System.out.println("�����ɹ�������");
        
    }
    
    /**
     *  ת�˷� 
     * */
    public void money_less(){
        String str = "update t_account set money=money-? where username=?;";
        jdbcTemplate.update(str,1000,"rose");
        System.out.println("ת���ɹ�������");
    }
    /**
     *  ���շ� 
     * */
    public void money_more(){
        String str = "update t_account set money=money+? where username=?;";
        jdbcTemplate.update(str,1000,"jack");
        System.out.println("���ճɹ�������");
    }

}