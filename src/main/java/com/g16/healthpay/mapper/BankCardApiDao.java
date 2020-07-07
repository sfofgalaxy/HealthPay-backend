package com.g16.healthpay.mapper;

import com.g16.healthpay.model.BankCardApi;

public interface BankCardApiDao {
    int insert(BankCardApi record);

    int insertSelective(BankCardApi record);

    BankCardApi checkPassword(String cardNumber,String password);
}