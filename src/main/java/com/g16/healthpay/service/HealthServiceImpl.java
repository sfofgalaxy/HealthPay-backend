package com.g16.healthpay.service;

import com.g16.healthpay.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.g16.healthpay.api.HealthApi;

import java.util.List;

@Service
public class HealthServiceImpl implements HealthService{

    @Autowired
    HealthApi healthApi;
    @Autowired
    UserService userService;

    @Override
    public List<Integer> checkHealthService(String token){
        String id = userService.getId(token);
        if(id!=null){
            return healthApi.checkHealth(id);
        }else {
            return null;
        }
    }
}
