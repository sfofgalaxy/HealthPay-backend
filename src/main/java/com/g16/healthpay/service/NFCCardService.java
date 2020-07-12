package com.g16.healthpay.service;

import com.g16.healthpay.model.BankCard;
import com.g16.healthpay.model.NfcCard;

import java.util.List;

public interface NFCCardService {

    public boolean saveTag(String token,String tag);

    List<NfcCard> getNFCCard(String token);

}
