package com.medical.domain;

public enum  LoginType {
    //普通用户
    USER("User"),

    //管理员(员工)
    ADMIN("Admin"),

    //超级管理员
    WORKER("Worker");

    //登录类型
    private String type;

    // 枚举对象构造函数
    LoginType(String type) {
      this.type = type;
    }

    @Override
    public String toString() {
      return type;
    }
}
