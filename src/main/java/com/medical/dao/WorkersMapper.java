package com.medical.dao;

import com.medical.po.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.medical.po.Workers;

import java.util.List;

@Mapper
public interface WorkersMapper {

    int updateWorkersByUsername(@Param("workers")Workers workers);

    Workers findWorkerByUsername(@Param("username")String username);

    List<Users> listCustomer();
}
