package com.medical.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.medical.po.Health_insurance;

@Mapper
public interface Health_insuranceMapper { //可能导致bug，insert 的param和update相同
    int insert(@Param("health_insurance") Health_insurance health_insurance);

    int deleteByCard_no(@Param("card_no") int card_no);

    int updateByPrimaryKeySelective(@Param("health_insurance") Health_insurance health_insurance);

    Health_insurance findByStudentNo(@Param("student_no") String student_no);
}
