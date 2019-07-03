package com.medical.service.impl;

import com.medical.service.Health_insuranceService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.medical.po.Health_insurance;
import com.medical.dao.Health_insuranceMapper;

@Service
//@Transactional 对该标识类中的所有方法进行事务管理
public class Health_insuranceServiceImpl implements Health_insuranceService {

    @Resource
    private Health_insuranceMapper health_insuranceMapper;

    public int insert(Health_insurance health_insurance){
        return health_insuranceMapper.insert(health_insurance);
    }

    public int deleteByCard_no(int card_no) {
        return health_insuranceMapper.deleteByCard_no(card_no);
    }

    public int updateByPrimaryKeySelective(Health_insurance health_insurance){
        return health_insuranceMapper.updateByPrimaryKeySelective(health_insurance);
    }

    public Health_insurance findInsuranceByStudentUsername(String username) {
        return health_insuranceMapper.findInsuranceByStudentUsername(username);
    }
}
