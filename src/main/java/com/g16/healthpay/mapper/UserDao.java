package com.g16.healthpay.mapper;

import com.g16.healthpay.model.User;

public interface UserDao {
    int insert(User record);

    int insertSelective(User record);
}