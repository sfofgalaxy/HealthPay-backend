package com.g16.healthpay.api;

public interface BankCardApi {
    boolean bindCard(String cardNumber,String password);
    boolean unbindCard(String cardNumber);
}
