package com.g16.healthpay.model;

import java.io.Serializable;
import lombok.Data;

/**
 * bank_card
 * @author 
 */
@Data
public class BankCard implements Serializable {
    private String cardNumber;

    private String phone;

    private static final long serialVersionUID = 1L;
}