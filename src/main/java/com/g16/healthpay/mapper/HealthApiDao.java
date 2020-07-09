package com.g16.healthpay.mapper;

import com.g16.healthpay.model.HealthApi;

public interface HealthApiDao {
    int deleteByPrimaryKey(String id);

    int insert(HealthApi record);

    int insertSelective(HealthApi record);

    HealthApi selectByPrimaryKey(String id);

    int selectByID(String id);

    int updateByPrimaryKeySelective(HealthApi record);

    int updateByPrimaryKey(HealthApi record);
}