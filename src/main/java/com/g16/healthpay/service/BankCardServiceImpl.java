package com.g16.healthpay.service;


import com.g16.healthpay.mapper.BankCardDao;
import com.g16.healthpay.model.BankCard;
import com.g16.healthpay.api.BankCardApi;
import com.g16.healthpay.utils.EncrypteUtils;
import com.g16.healthpay.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class BankCardServiceImpl implements BankCardService{
    @Resource
    BankCardDao bankCardDao;
    @Resource
    BankCardApi bankCardApi;
    @Autowired
    EncrypteUtils encrypteUtils;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public boolean bindCard(String phone,String cardNumber,String password){
        int result;
        //调用绑卡API
        if(bankCardApi.bindCard(cardNumber,password)){
            BankCard bankCard = new BankCard();
            bankCard.setCardNumber(cardNumber);
            bankCard.setPhone(phone);
            bankCardDao.selectByPrimaryKey(cardNumber);
            result = bankCardDao.insert(bankCard);
            if(result !=0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteCard(String cardNumber){
        int result;
        //调用解绑API检查该卡号是否存在
        if(bankCardApi.unbindCard(cardNumber)){
            result = bankCardDao.deleteByPrimaryKey(cardNumber);
            if(result!=0){
                return true;
            }
        }
        return false;
    }


    @Override
    public List<BankCard> getBankCard(String token){
        String phone = redisUtils.getPhone(token);
        if(phone!=null) {
            return bankCardDao.selectByPhone(phone);
        } else {
            return null;
        }
    }
}
