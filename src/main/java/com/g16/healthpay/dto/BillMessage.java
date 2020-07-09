package com.g16.healthpay.dto;

import com.g16.healthpay.model.BankBill;
import com.g16.healthpay.model.NfcBill;
import lombok.Data;

import java.util.List;

@Data
public class BillMessage {
    List<NfcBill> nfcBillList;
    List<BankBill> bankBillList;
    String message;
    boolean state;
}
