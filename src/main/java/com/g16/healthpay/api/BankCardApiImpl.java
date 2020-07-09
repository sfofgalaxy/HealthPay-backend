package com.g16.healthpay.api;

import com.g16.healthpay.mapper.BankCardApiDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BankCardApiImpl implements BankCardApi {
    @Resource
    BankCardApiDao bankCardApiDao;

    @Override
    public boolean bindCard(String cardNumber, String password) {
        return bankCardApiDao.checkPassword(cardNumber, password) != null;
    }

    @Override
    public boolean unbindCard(String cardNumber) {
        return bankCardApiDao.selectByPrimaryKey(cardNumber) != null;
    }
}
