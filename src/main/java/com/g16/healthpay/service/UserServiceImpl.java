package com.g16.healthpay.service;

import com.g16.healthpay.mapper.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

}
