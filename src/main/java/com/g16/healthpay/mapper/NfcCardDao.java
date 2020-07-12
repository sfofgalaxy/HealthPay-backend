package com.g16.healthpay.mapper;

import com.g16.healthpay.model.BankCard;
import com.g16.healthpay.model.NfcCard;

import java.util.List;

public interface NfcCardDao {
    int insert(NfcCard record);

    int insertSelective(NfcCard record);

    List<NfcCard> selectByPhone(String cardNumber);
}