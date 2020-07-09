package com.g16.healthpay.service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.g16.healthpay.api.HealthApi;
import com.g16.healthpay.mapper.UserDao;
import com.g16.healthpay.model.User;
import com.g16.healthpay.utils.CaptchaUtils;
import com.g16.healthpay.utils.EncrypteUtils;
import com.g16.healthpay.utils.RedisUtils;
import com.g16.healthpay.utils.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Resource
    HealthApi healthApi;
    @Autowired
    EncrypteUtils encrypteUtils;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    CaptchaUtils captchaUtils;
    @Autowired
    SmsUtils smsUtils;
    // 短信模板id
    @Value("${spring.sms.template-code}")
    String templateCode;

    @Override
    public String verify(String phone,String captcha){
        if(redisUtils.getCaptcha(phone).equals(captcha)){
            User record = new User();
            record.setPhone(phone);
            userDao.insert(record);
            String token = encrypteUtils.getMD5Code(phone,captcha);
            redisUtils.setToken(token,phone);
            return token;
        }
        else{
            return null;
        }

    }


    @Override
    public boolean sendCaptcha(String phone) throws ClientException {
        // 验证码（指定长度的随机数）
        String captcha = captchaUtils.generateVerifyCode(6);
        String templateParam = "{\"code\":\""+captcha+"\"}";
        SendSmsResponse response = smsUtils.sendSms(phone,templateParam,templateCode);
        if(response.getCode().equals("OK")) {
            redisUtils.setCaptcha(phone,captcha);
            return true;
        }
        return false;
    }

    @Override
    public boolean logout(String token) {
        return redisUtils.del(token);
    }

    @Override
    public boolean bindId(String token, String id, String name) {
        String phone = redisUtils.getPhone(token);
        List<Integer> res = healthApi.checkHealth(id);
        //通过健康查看该人是否存在
        if(res!=null&&res.size()!=0){
            User record = new User();
            record.setPhone(phone);
            record.setId(id);
            record.setName(name);
            if(userDao.updateByPrimaryKey(record)>0){
                return true;
            }
        }
        return false;
    }


}
