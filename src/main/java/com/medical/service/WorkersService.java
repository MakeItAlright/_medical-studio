package com.medical.service;

import com.medical.po.Users;
import com.medical.po.Workers;

import java.util.List;

public interface WorkersService{

    int updateWorkersByUsername(Workers workers);  //更新员工信息通过账号

    Workers findWorkerByUsername(String username);  //查找员工用户通过账号

    List<Users> listCustomer();
}
