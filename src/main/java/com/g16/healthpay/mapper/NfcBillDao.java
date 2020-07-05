package com.g16.healthpay.mapper;

import com.g16.healthpay.model.NfcBill;

public interface NfcBillDao {
    int insert(NfcBill record);

    int insertSelective(NfcBill record);
}