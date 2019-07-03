package com.medical.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.medical.po.Health_insurance;

@Mapper
public interface Health_insuranceMapper {

    int insert(@Param("health_insurance") Health_insurance health_insurance);

    int deleteByCard_no(@Param("card_no") int card_no);

    int updateByPrimaryKeySelective(@Param("health_insurance") Health_insurance health_insurance);

    Health_insurance findInsuranceByStudentUsername(@Param("username") String username);
}
