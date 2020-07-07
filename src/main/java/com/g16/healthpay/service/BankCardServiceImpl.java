package com.g16.healthpay.service;



import java.util.List;
import com.g16.healthpay.mapper.BankCardApiDao;
import com.g16.healthpay.mapper.BankCardDao;
import com.g16.healthpay.model.BankCard;
import com.g16.healthpay.model.BankCardApi;
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
    BankCardApiDao bankCardApiDao;
    @Autowired
    EncrypteUtils encrypteUtils;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public boolean bindCard(String phone,String cardNumber,String password){
        BankCardApi result1;
        int result2;
        result1 = bankCardApiDao.checkPassword(cardNumber,password);
        if(result1!=null){
            BankCard bankCard = new BankCard();
            bankCard.setCardNumber(cardNumber);
            bankCard.setPhone(phone);
            result2 = bankCardDao.insert(bankCard);
            if(result2 !=0){
                return true;
            }
        }
        return false;
    }
}
