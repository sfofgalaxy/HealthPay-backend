package com.g16.healthpay.mapper;

import com.g16.healthpay.model.NfcBill;

import java.util.List;

public interface NfcBillDao {
    int insert(NfcBill record);
    int insertSelective(NfcBill record);
    List<NfcBill> selectNfcBillByPhone(String phone);
}