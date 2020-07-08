package com.g16.healthpay.service;

import com.g16.healthpay.dto.BankCardMessage;
import com.g16.healthpay.model.BankCard;

import java.util.List;

public interface BankCardService {
    public boolean bindCard(String phone,String cardNumber,String password);

    public boolean deleteCard(String cardNumber);

    public List<BankCard> getBankCard(String token);
}
