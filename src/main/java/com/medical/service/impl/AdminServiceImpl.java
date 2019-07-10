package com.medical.service.impl;

import com.medical.dao.AdminMapper;
import com.medical.po.Users;
import com.medical.po.Workers;
import com.medical.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

  @Resource
  private AdminMapper adminMapper;

  @Override
  public int insertWorker(Workers workers) {
    return adminMapper.insertWorker(workers);
  }

  @Override
  public int deleteWorkersByUsername(String username) {
    return adminMapper.deleteWorkersByUsername(username);
  }

  @Override
  public int updateWorkersByUsername(Workers workers) {
    return adminMapper.updateWorkersByUsername(workers);
  }

  @Override
  public int alterAdminInfo(Users users) {
    return adminMapper.alterAdminInfo(users);
  }

  @Override
  public Users findAdminByUsername(String username) {
    return adminMapper.findAdminByUsername(username);
  }

  @Override
  public List<Workers> listWorkers() {
    return adminMapper.listWorkers();
  }

}
