package com.g16.healthpay.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * bank_bill
 * @author 
 */
@Data
public class BankBill implements Serializable {
    private String phone;

    private Date time;

    private Double amount;

    private String cardNumber;

    private static final long serialVersionUID = 1L;
}