package com.g16.healthpay.service;


import com.g16.healthpay.api.BankCardApi;
import com.g16.healthpay.dto.GeneralMessage;
import com.g16.healthpay.mapper.BankCardApiDao;
import com.g16.healthpay.mapper.BankCardDao;
import com.g16.healthpay.model.BankCard;
import com.g16.healthpay.utils.EncrypteUtils;
import com.g16.healthpay.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class BankCardServiceImpl implements BankCardService{
    @Resource
    BankCardDao bankCardDao;
    @Resource
    BankCardApiDao bankCardApiDao;
    @Resource
    BankCardApi bankCardApi;
    @Autowired
    EncrypteUtils encrypteUtils;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public boolean bindCard(String token,String cardNumber,String password){
        int result;
        String phone = redisUtils.getPhone(token);
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
        List<BankCard> result = new ArrayList<>();
        if(phone!=null) {
            result = bankCardDao.selectByPhone(phone);
            for(BankCard bankCard:result){
                String cardNumber = bankCard.getCardNumber();
                com.g16.healthpay.model.BankCardApi cardApi= bankCardApiDao.selectByPrimaryKey(cardNumber);
                bankCard.setBankName(cardApi.getBankName());
                System.out.println(bankCard);
            }
            return result;
        } else {
            return null;
        }
    }

    @Override
    public GeneralMessage pay(String token, String cardNumber, Double amount) {
        GeneralMessage message;
        String phone = redisUtils.getPhone(token);
        if(phone!=null){
            List<BankCard> bankCardList = bankCardDao.selectByPhone(phone);
            for(BankCard bankCard: bankCardList){
                if(bankCard.getCardNumber().equals(cardNumber)){
                    return bankCardApi.deduction(cardNumber,amount);
                }
            }
            //如果循环结束并未查到该卡，证明该卡与手机未绑定
            message = new GeneralMessage();
            message.setState(false);
            message.setMessage("该用户未绑定该银行卡");
        }else {
            message = new GeneralMessage();
            message.setMessage("登录过期");
            message.setState(false);
        }
        return message;
    }
}
