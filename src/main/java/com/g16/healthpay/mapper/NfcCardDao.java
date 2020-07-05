package com.g16.healthpay.mapper;

import com.g16.healthpay.model.NfcCard;

public interface NfcCardDao {
    int insert(NfcCard record);

    int insertSelective(NfcCard record);
}