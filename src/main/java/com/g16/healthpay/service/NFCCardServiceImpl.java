package com.g16.healthpay.service;

import com.g16.healthpay.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class NFCCardServiceImpl implements NFCCardService{

    @Autowired
    RedisUtils redisUtils;



    public boolean saveTag(String token,String tag){
        return true;
    }
}
