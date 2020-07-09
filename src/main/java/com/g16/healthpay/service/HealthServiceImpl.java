package com.g16.healthpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.g16.healthpay.api.HealthApi;

import java.util.List;

@Service
public class HealthServiceImpl implements HealthService{

    @Autowired
    HealthApi healthApi;

    public List<Integer> checkHealthService(String id){
        List<Integer> result = healthApi.checkHealth(id);
        return result;
    }
}
