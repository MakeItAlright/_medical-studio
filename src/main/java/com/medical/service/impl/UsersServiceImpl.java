package com.medical.service.impl;

import com.medical.service.UsersService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.medical.po.Users;
import com.medical.dao.UsersMapper;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    public int insert(Users users){
        return usersMapper.insert(users);
    }

    public int deleteUserByUsername(String username) {
        return usersMapper.deleteUserByUsername(username);
    }

    public int updateUsersByUsername(Users users) {
        return usersMapper.updateUsersByUsername(users);
    }

    public Users findUserByUsername(String username) {
        return usersMapper.findUserByUsername(username);
    }

}
