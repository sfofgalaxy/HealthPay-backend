package com.g16.healthpay.mapper;

import com.g16.healthpay.model.BankBill;

public interface BankBillDao {
    int insert(BankBill record);

    int insertSelective(BankBill record);


}