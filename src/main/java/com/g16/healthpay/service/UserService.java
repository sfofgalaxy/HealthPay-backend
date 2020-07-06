package com.g16.healthpay.service;

public interface UserService {
    public String verify(String phone,String captcha);
    public String sendCaptcha(String phone);
}
