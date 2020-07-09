package com.g16.healthpay.mapper;

import com.g16.healthpay.model.HealthApi;

import java.util.List;

public interface HealthApiDao {
    int deleteByPrimaryKey(String id);

    int insert(HealthApi record);

    int insertSelective(HealthApi record);

    HealthApi selectByPrimaryKey(String id);

    List<Integer> selectByID(String id);

    int updateByPrimaryKeySelective(HealthApi record);

    int updateByPrimaryKey(HealthApi record);
}