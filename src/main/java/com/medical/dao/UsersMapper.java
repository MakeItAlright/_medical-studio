package com.medical.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.medical.po.Users;

@Mapper
public interface UsersMapper {
    int insert(@Param("users") Users users);

    int deleteUserByUsername(@Param("username") String username);

    int updateUsersByUsername(@Param("users") Users users);

    Users findUserByUsername(@Param("username") String username);

    Users findStudentByUsername(@Param("student") String student);

    Users findAdminByUsername(@Param("admin") String admin);

}
