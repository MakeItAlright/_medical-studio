package com.medical.service;

import com.medical.po.Health_insurance;

public interface Health_insuranceService{

    int insert(Health_insurance health_insurance);

    int deleteByCard_no(int card_no);   //删除学生的医保信息通过医保卡号

    int updateByPrimaryKeySelective(Health_insurance health_insurance);   //修改学生用户的保险信息

    Health_insurance findInsuranceByStudentUsername(String username);    //查询医保信息通过学生账号
}
