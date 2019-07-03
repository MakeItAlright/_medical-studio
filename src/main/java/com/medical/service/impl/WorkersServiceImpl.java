package com.medical.service.impl;

import com.medical.po.Users;
import com.medical.service.WorkersService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.medical.po.Workers;
import com.medical.dao.WorkersMapper;

import java.util.List;

@Service
public class WorkersServiceImpl implements WorkersService {

    @Resource
    private WorkersMapper workersMapper;

    @Override
    public int updateWorkersByUsername(Workers workers) {
      return workersMapper.updateWorkersByUsername(workers);
    }

    @Override
    public Workers findWorkerByUsername(String username) {
      return workersMapper.findWorkerByUsername(username);
    }

    @Override
    public List<Users> listCustomer() {
      return workersMapper.listCustomer();
    }
}
