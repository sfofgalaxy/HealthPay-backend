package com.g16.healthpay.dto;


import com.g16.healthpay.model.BankCard;
import lombok.Data;

import java.util.List;


@Data
public class BankCardMessage {
    List<BankCard> bankCards;
    boolean state;
}
