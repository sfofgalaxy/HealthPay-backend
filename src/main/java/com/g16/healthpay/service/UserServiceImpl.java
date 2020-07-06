package com.g16.healthpay.service;

import com.g16.healthpay.mapper.UserDao;
import com.g16.healthpay.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Autowired
    RedisUtils redisUtils;
    @Override
    public boolean verify(String phone,String captcha){

        if(redisUtils.get(phone).equals(captcha)){
            return true;
        }
        else{
            return false;
        }

    }


}
