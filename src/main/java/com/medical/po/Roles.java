package com.medical.po;

public class Roles {    //角色表

    /**
     * 管理员页面显示这张表的信息，
     * 根据不同角色展现不同的页面
     */
    private Integer role_no;
    private String role_name;
    private String role_desc;

    public Integer getRole_no() {
        return role_no;
    }

    public void setRole_no(Integer role_no) {
        this.role_no = role_no;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }
}
