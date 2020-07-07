package com.g16.healthpay.mapper;

import com.g16.healthpay.model.BankCardApi;

public interface BankCardApiDao {
    int deleteByPrimaryKey(String cardNumber);

    int insert(BankCardApi record);

    int insertSelective(BankCardApi record);

    BankCardApi selectByPrimaryKey(String cardNumber);

    int updateByPrimaryKeySelective(BankCardApi record);

    int updateByPrimaryKey(BankCardApi record);

    BankCardApi checkPassword(String cardNumber, String password);
}