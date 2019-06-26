package com.medical.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.medical.po.Workers;
import com.medical.dao.WorkersMapper;

@Service
public class WorkersServiceImpl implements WorkersService{

    @Resource
    private WorkersMapper workersMapper;

    public int insert(Workers workers){
        return workersMapper.insert(workers);
    }

    public int deleteWorkersByUsername(String username) {
      return workersMapper.deleteWorkersByUsername(username);
    }

    public int updateWorkersByUsername(Workers workers) {
      return workersMapper.updateWorkersByUsername(workers);
    }

    public Workers findUserByUsername(String username) {
      return workersMapper.findUserByUsername(username);
    }
}
