package com.medical.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.medical.po.Roles;
import com.medical.dao.RolesMapper;

@Service
public class RolesServiceImpl implements RolesService{

    @Resource
    private RolesMapper rolesMapper;

    public int insertRole(Roles roles) {
      return rolesMapper.insertRole(roles);
    }

    public int deleteRole(String roleName) {  //最好对前端传回的值进行trim()再调用
      return rolesMapper.deleteRole(roleName);
    }

    public int updateRole(Roles roles) {
      return rolesMapper.updateRole(roles);
    }

    public Roles findByRoleName(String name) {
      return rolesMapper.findByRoleName(name);
    }
}
