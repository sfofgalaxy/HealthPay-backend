package com.g16.healthpay.service;

import com.aliyuncs.exceptions.ClientException;

public interface UserService {
    String verify(String phone, String captcha);
    boolean sendCaptcha(String phone) throws ClientException;
}
