package com.medical.service;

import com.medical.po.Users;

public interface UsersService{

    int insert(Users users);  //插入一个用户

    int deleteUserByUsername(String username);  //删除用户

    int updateUsersByUsername(Users users);  //更新用户信息通过账号

    Users findUserByUsername(String username);  //查找用户通过账号

    Users findStudentByUsername(String student);  //查找student用户通过账号

    Users findAdminByUsername(String admin);   //查找admin用户通过账号
}
