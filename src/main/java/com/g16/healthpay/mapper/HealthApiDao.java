package com.g16.healthpay.mapper;

import com.g16.healthpay.model.HealthApi;

public interface HealthApiDao {
    int insert(HealthApi record);

    int insertSelective(HealthApi record);
}