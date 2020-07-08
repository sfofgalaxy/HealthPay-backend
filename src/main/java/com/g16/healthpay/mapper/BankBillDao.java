package com.g16.healthpay.mapper;

import com.g16.healthpay.model.BankBill;

import java.util.List;

public interface BankBillDao {
    int insert(BankBill record);

    int insertSelective(BankBill record);

    List<BankBill> selectBankBillByPhone (String phone);
}