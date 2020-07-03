package com.g16.healthpay.service;

import com.g16.healthpay.model.User;

public interface UserService {
    User getByUsername(String username);
    int register(User user);
    boolean updatePassword(User user);
}
