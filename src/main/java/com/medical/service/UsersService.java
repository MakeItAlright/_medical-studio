package com.medical.service;

import com.medical.po.Users;

public interface UsersService{

    int insert(Users users);  //通过这个接口注册的用户角色默认为学生

    int deleteUserByUsername(String username);  //删除用户通过账号

    int updateUsersByUsername(Users users);  //更新(学生)用户信息通过账号

    Users findUserByUsername(String username);  //查找用户通过账号
}
