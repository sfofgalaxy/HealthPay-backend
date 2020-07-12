package com.g16.healthpay.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * feedback
 * @author 
 */
@Data
public class Feedback implements Serializable {
    private String phone;

    private String content;

    private Date time;

    private static final long serialVersionUID = 1L;
}