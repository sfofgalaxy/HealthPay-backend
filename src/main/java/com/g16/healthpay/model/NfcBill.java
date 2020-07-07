package com.g16.healthpay.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * NFC_bill
 * @author 
 */
@Data
public class NfcBill implements Serializable {
    private String phone;

    private Date time;

    private Integer amount;

    private String tag;

    private static final long serialVersionUID = 1L;
}