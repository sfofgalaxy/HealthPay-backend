package com.g16.healthpay.dto;

import lombok.Data;

@Data
public class LoginMessage {
    private boolean state;
    private String message;//message存token

}
