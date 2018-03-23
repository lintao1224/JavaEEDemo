package com.demo.bean;
public class User {
    private Integer id;
    private String uname;
    private String upass;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }
    public String getUpass() {
        return upass;
    }
    public void setUpass(String upass) {
        this.upass = upass == null ? null : upass.trim();
    }
}