package com.g16.healthpay.model;

import java.io.Serializable;
import lombok.Data;

/**
 * health_api
 * @author 
 */
@Data
public class HealthApi implements Serializable {
    private String id;

    private Byte healthState;

    private static final long serialVersionUID = 1L;
}