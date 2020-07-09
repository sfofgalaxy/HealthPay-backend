package com.g16.healthpay.controller;

import com.g16.healthpay.dto.BillMessage;
import com.g16.healthpay.intercepter.AuthToken;
import com.g16.healthpay.model.BankBill;
import com.g16.healthpay.model.NfcBill;
import com.g16.healthpay.service.BillService;
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
    @AuthToken
    BillMessage getBill(@RequestHeader("token") String token){
        BillMessage message = new BillMessage();
        List<BankBill> bankBillList = billService.getBankBill(token);
        List<NfcBill> nfcBillList = billService.getNfcBill(token);
        if(nfcBillList!=null||bankBillList!=null){
            message.setMessage("查询成功");
            message.setState(true);
            message.setNfcBillList(nfcBillList);
            message.setBankBillList(bankBillList);
        }else {
            message.setMessage("查询失败或无账单记录");
            message.setState(false);
        }
        return message;
    }

}
