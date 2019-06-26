package com.medical.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.medical.po.Roles;

@Mapper
public interface RolesMapper {
    int insertRole(@Param("roles") Roles roles);

    int deleteRole(@Param("roleName") String roleName);

    int updateRole(@Param("roles") Roles roles);

    Roles findByRoleName(@Param("name") String name);
}
