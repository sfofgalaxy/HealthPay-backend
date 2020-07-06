package com.g16.healthpay.service;

import com.g16.healthpay.mapper.UserDao;
import com.g16.healthpay.utils.EncrypteUtils;
import com.g16.healthpay.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Autowired
    EncrypteUtils encrypteUtils;
    @Autowired
    RedisUtils redisUtils;

    @Override
    public String verify(String phone,String captcha){

        if(redisUtils.getCaptcha(phone).equals(captcha)){
            String token = encrypteUtils.getMD5Code(phone,captcha);
            redisUtils.setToken(token,phone);
            return token;
        }
        else{
            return null;
        }

    }


    @Override
    public String sendCaptcha(String phone) {
        String captcha = encrypteUtils.getMD5Code(phone).substring(0,6);

        redisUtils.setCaptcha(phone,captcha);
        return captcha;
    }


}
