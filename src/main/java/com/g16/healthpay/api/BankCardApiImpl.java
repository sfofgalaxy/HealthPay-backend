package com.g16.healthpay.api;

import com.g16.healthpay.dto.GeneralMessage;
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

    @Override
    public GeneralMessage deduction(String carNumber, Double amount) {
        GeneralMessage message = new GeneralMessage();
        com.g16.healthpay.model.BankCardApi bankCardApi =  bankCardApiDao.selectByPrimaryKey(carNumber);
        if(bankCardApi==null){
            message.setMessage("扣款失败，请重试");
            message.setState(false);
        }else {
            Double banlance = bankCardApi.getBalance();
            if(banlance<amount){
                message.setState(false);
                message.setMessage("余额不足");
            }else {
                bankCardApi.setBalance(banlance-amount);
                if(bankCardApiDao.updateByPrimaryKey(bankCardApi)>0){
                    message.setState(true);
                    message.setMessage("付款成功");
                }else{
                    message.setMessage("扣款失败，请重试");
                    message.setState(false);
                }
            }
        }
        return message;
    }
}
