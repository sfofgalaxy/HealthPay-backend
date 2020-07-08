package com.g16.healthpay.service;

import com.g16.healthpay.mapper.BankBillDao;
import com.g16.healthpay.mapper.NfcBillDao;
import com.g16.healthpay.model.BankBill;
import com.g16.healthpay.model.NfcBill;
import com.g16.healthpay.utils.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BillServiceImpl implements BillService{
    @Resource
    RedisUtils redisUtils;
    @Resource
    NfcBill nfcBill;
    @Resource
    BankBill bankBill;
    @Resource
    BankBillDao bankBillDao;
    @Resource
    NfcBillDao nfcBillDao;

    @Override
    public List<BankBill> getBankBill(String token) {
        String phone = redisUtils.getPhone(token);
        if(phone!=null) {
            return bankBillDao.selectBankBillByPhone(phone);
        } else {
            return null;
        }
    }

    @Override
    public List<NfcBill> getNfcBill(String token) {
        String phone = redisUtils.getPhone(token);
        if(phone!=null) {
            return nfcBillDao.selectNfcBillByPhone(phone);
        } else {
            return null;
        }
    }
}
