package com.medical.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.medical.po.Workers;

@Mapper
public interface WorkersMapper {
    int insert(@Param("workers") Workers workers);

    int deleteWorkersByUsername(@Param("username")String username);

    int updateWorkersByUsername(@Param("workers")Workers workers);

    Workers findUserByUsername(@Param("username")String username);
}
