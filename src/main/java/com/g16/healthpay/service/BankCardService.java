package com.g16.healthpay.service;

import com.g16.healthpay.dto.GeneralMessage;
import com.g16.healthpay.model.BankCard;

import java.util.List;

public interface BankCardService {
    boolean bindCard(String token,String cardNumber,String password);

    boolean deleteCard(String cardNumber);

    List<BankCard> getBankCard(String token);

    GeneralMessage pay(String token, String cardNumber, Double amount);
}
