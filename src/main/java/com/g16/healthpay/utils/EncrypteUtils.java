package com.g16.healthpay.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Random;

@Service
public class EncrypteUtils {
    @Value("${spring.authorize.salt}")
    private String salt;

    public String getMD5Code(String key1, String key2) {
        long t = System.currentTimeMillis();//获得当前时间的毫秒数
        Random rd = new Random(t);//作为种子数传入到Random的构造器中
        String base = rd.nextInt()+key1 + "/" + salt + ":"+key2+rd.nextInt();
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    public String getMD5Code(String key1) {
        long t = System.currentTimeMillis();//获得当前时间的毫秒数
        Random rd = new Random(t);//作为种子数传入到Random的构造器中
        String base = rd.nextInt()+key1 + "/" + salt +rd.nextInt();
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

}
