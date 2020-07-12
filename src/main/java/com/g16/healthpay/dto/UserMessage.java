package com.g16.healthpay.dto;

import com.g16.healthpay.model.User;
import lombok.Data;

@Data
public class UserMessage {
    User user;
    String message;
    boolean state;
}
