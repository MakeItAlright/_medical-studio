package com.medical.service;

import com.medical.po.Roles;

public interface RolesService{

    int insertRole(Roles roles);

    int deleteRole(String roleName);

    int updateRole(Roles roles);

    Roles findByRoleName(String name);
}
