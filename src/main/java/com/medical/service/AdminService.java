package com.medical.service;

import com.medical.po.Users;
import com.medical.po.Workers;

import java.util.List;

public interface AdminService {

  int insertWorker(Workers workers);    //创建一个员工用户

  int deleteWorkersByUsername(String username);  //删除员工用户

  int updateWorkersByUsername(Workers workers);  //更新员工、学生信息通过账号

  int alterAdminInfo(Users users);    //管理员信息修改

  Users findAdminByUsername(String username);   //查找admin用户通过账号

  List<Workers> listWorkers();  //列出所有员工
}
