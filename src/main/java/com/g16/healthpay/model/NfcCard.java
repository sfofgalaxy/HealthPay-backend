package com.g16.healthpay.model;

import java.io.Serializable;
import lombok.Data;

/**
 * NFC_card
 * @author 
 */
@Data
public class NfcCard implements Serializable {
    private String phone;

    private String tag;

    private static final long serialVersionUID = 1L;
}