package com.g16.healthpay.controller;

import com.g16.healthpay.dto.BillMessage;
import com.g16.healthpay.model.BankBill;
import com.g16.healthpay.model.NfcBill;
import com.g16.healthpay.service.BillService;
import com.g16.healthpay.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Resource
    BillService billService;

    @ApiOperation("查看账单")
    @GetMapping()
    BillMessage getBill(@RequestHeader("token") String token){
        BillMessage message = new BillMessage();
        List<BankBill> bankBillList = billService.getBankBill(token);
        List<NfcBill> nfcBillList = billService.getNfcBill(token);
        if(nfcBillList!=null&&bankBillList!=null){
            message.setState(true);
            message.setNfcBillList(nfcBillList);
            message.setBankBillList(bankBillList);
        }else {
            message.setState(false);
        }
        return message;
    }

}
