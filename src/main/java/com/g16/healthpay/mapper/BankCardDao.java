package com.g16.healthpay.mapper;

import com.g16.healthpay.model.BankCard;

public interface BankCardDao {
    int insert(BankCard record);

    int insertSelective(BankCard record);
}