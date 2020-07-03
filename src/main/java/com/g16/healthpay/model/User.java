package com.g16.healthpay.model;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private String phone;

    private static final long serialVersionUID = 1L;
}