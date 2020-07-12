package com.g16.healthpay.service;

import com.g16.healthpay.mapper.NfcCardDao;
import com.g16.healthpay.model.BankCard;
import com.g16.healthpay.model.NfcCard;
import com.g16.healthpay.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NFCCardServiceImpl implements NFCCardService{

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    NfcCardDao nfcCardDao;


    @Override
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

    @Override
    public List<NfcCard> getNFCCard(String token){

        String phone = redisUtils.getPhone(token);
        List<NfcCard> result = new ArrayList<>();
        if(phone!=null) {
            result = nfcCardDao.selectByPhone(phone);
            return result;
        } else {
            return null;
        }

    }
}
