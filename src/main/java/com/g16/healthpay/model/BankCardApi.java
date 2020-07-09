package com.g16.healthpay.model;

import java.io.Serializable;
import lombok.Data;

/**
 * bank_card_api
 * @author 
 */
@Data
public class BankCardApi implements Serializable {
    private String cardNumber;

    private String bankName;

    private Integer balance;

    private String password;

    private static final long serialVersionUID = 1L;

}