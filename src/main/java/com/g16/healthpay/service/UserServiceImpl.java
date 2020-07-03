package com.g16.healthpay.service;

import com.g16.healthpay.mapper.UserDao;
import com.g16.healthpay.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public User getByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public int register(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean updatePassword(User user) {
        if(userDao.updateByPrimaryKey(user)>0)return true;
        else return false;
    }
}
