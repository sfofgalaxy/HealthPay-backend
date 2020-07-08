package com.g16.healthpay.service;

import com.g16.healthpay.model.BankBill;
import com.g16.healthpay.model.NfcBill;

import java.util.List;

public interface BillService {
    List<BankBill> getBankBill(String token);
    List<NfcBill> getNfcBill(String token);
}
