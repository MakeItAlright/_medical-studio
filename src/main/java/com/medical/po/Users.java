package com.medical.po;

public class Users {    //用户表
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String userrole;
    private String email;
    private String telephone;
    private String mobilephone;
    private boolean is_worker;
    private String work_no;
    private String u_status;    //正常和锁定
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public boolean isIs_worker() {
        return is_worker;
    }

    public void setIs_worker(boolean is_worker) {
        this.is_worker = is_worker;
    }

    public String getWork_no() {
        return work_no;
    }

    public void setWork_no(String work_no) {
        this.work_no = work_no;
    }

    public String getU_status() {
        return u_status;
    }

    public void setU_status(String u_status) {
        this.u_status = u_status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

  @Override
  public String toString() {
    return "Users{" +
      "id=" + id +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", name='" + name + '\'' +
      ", userrole='" + userrole + '\'' +
      ", email='" + email + '\'' +
      ", telephone='" + telephone + '\'' +
      ", mobilephone='" + mobilephone + '\'' +
      ", is_worker=" + is_worker +
      ", work_no='" + work_no + '\'' +
      ", u_status='" + u_status + '\'' +
      ", remark='" + remark + '\'' +
      '}';
  }
}
