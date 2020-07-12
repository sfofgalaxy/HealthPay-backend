package com.g16.healthpay.service;

import com.aliyuncs.exceptions.ClientException;
import com.g16.healthpay.model.User;

public interface UserService {
    String verify(String phone, String captcha);
    boolean sendCaptcha(String phone) throws ClientException;
    boolean logout(String token);
    boolean bindId(String token,String id, String name);
    String getId(String token);
    User getUserByToken(String token);
}
