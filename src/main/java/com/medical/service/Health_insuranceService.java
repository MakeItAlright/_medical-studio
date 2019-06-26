package com.medical.service;

import com.medical.po.Health_insurance;

public interface Health_insuranceService{

    int insert(Health_insurance health_insurance);

    int deleteByCard_no(int card_no);

    int updateByPrimaryKeySelective(Health_insurance health_insurance);

    Health_insurance findByStudentNo(String name);
}
