package com.g16.healthpay.service;

import com.g16.healthpay.mapper.NfcCardDao;
import com.g16.healthpay.model.NfcCard;
import com.g16.healthpay.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NFCCardServiceImpl implements NFCCardService{

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    NfcCardDao nfcCardDao;



    public boolean saveTag(String token,String tag){
        String phone = redisUtils.getPhone(token);
        System.out.println(phone);
        NfcCard nfcCard = new NfcCard();
        nfcCard.setPhone(phone);
        nfcCard.setTag(tag);
        int result = nfcCardDao.insert(nfcCard);
        if(result!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
