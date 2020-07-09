package com.g16.healthpay.api;

import com.g16.healthpay.mapper.HealthApiDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HealthApiImpl implements HealthApi{

    @Resource
    HealthApiDao healthApiDao;

    @Override
    public int checkHealth(String id){

        return healthApiDao.selectByID(id);
    }


}
