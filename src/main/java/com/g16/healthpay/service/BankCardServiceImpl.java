package com.g16.healthpay.service;




import com.g16.healthpay.mapper.BankCardApiDao;
import com.g16.healthpay.mapper.BankCardDao;
import com.g16.healthpay.model.BankCardApi;
import com.g16.healthpay.utils.EncrypteUtils;
import com.g16.healthpay.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


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
    public boolean bindCard(String cardNumber,String password){
        BankCardApi result;
        result = bankCardApiDao.checkPassword(cardNumber,password);
        if(result == null){
            System.out.println("Fucked up!");
        }
        System.out.println(result);
        System.out.println(cardNumber);
        System.out.println(password);
        return true;
    }
}
