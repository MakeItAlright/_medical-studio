package com.medical.service;

import com.medical.po.Workers;

public interface WorkersService{

    int insert(Workers workers);

    int deleteWorkersByUsername(String username);  //删除员工用户

    int updateWorkersByUsername(Workers workers);  //更新员工用户信息通过账号

    Workers findUserByUsername(String username);  //查找员工用户通过账号
}
