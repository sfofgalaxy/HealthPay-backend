package com.g16.healthpay.dto;

import com.g16.healthpay.model.BankCard;
import com.g16.healthpay.model.NfcCard;
import lombok.Data;

import java.util.List;

@Data
public class NFCCardMessage {

    List<NfcCard> nfcCards;
    boolean state;

}
