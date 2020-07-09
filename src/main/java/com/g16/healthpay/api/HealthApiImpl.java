package com.g16.healthpay.api;

import com.g16.healthpay.mapper.HealthApiDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HealthApiImpl implements HealthApi{

    @Resource
    HealthApiDao healthApiDao;

    @Override
    public List<Integer> checkHealth(String id){

        return healthApiDao.selectByID(id);
    }


}
