package com.medical.dao;

import com.medical.po.Users;
import com.medical.po.Workers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {

  int insertWorker(@Param("workers") Workers workers);

  int deleteWorkersByUsername(@Param("username")String username);

  int updateWorkersByUsername(@Param("workers") Workers workers);

  int alterAdminInfo(@Param("users") Users users);

  Users findAdminByUsername(@Param("admin") String admin);

  List<Workers> listWorkers();
}
