package com.g16.healthpay.mapper;

import com.g16.healthpay.model.BankCard;

public interface BankCardDao {
    int deleteByPrimaryKey(String cardNumber);

    int insert(BankCard record);

    int insertSelective(BankCard record);

    BankCard selectByPrimaryKey(String cardNumber);

    int updateByPrimaryKeySelective(BankCard record);

    int updateByPrimaryKey(BankCard record);
}