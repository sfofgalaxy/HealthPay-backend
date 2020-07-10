package com.g16.healthpay.api;

import com.g16.healthpay.dto.GeneralMessage;

public interface BankCardApi {
    boolean bindCard(String cardNumber,String password);
    boolean unbindCard(String cardNumber);
    GeneralMessage deduction(String carNumber,Double amount);
}
