package com.g16.healthpay.controller;

import com.g16.healthpay.dto.BillMessage;
import com.g16.healthpay.dto.GeneralMessage;
import com.g16.healthpay.dto.BankCardMessage;
import com.g16.healthpay.intercepter.AuthToken;
import com.g16.healthpay.model.BankBill;
import com.g16.healthpay.model.BankCard;
import com.g16.healthpay.service.NFCCardService;
import com.g16.healthpay.utils.EncrypteUtils;
import com.g16.healthpay.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/NFC")
public class NFCCardController {

    @Autowired
    NFCCardService nfcCardService;

    @ApiOperation("存储NFC tag")
    @RequestMapping(value = "/saveTag",method = RequestMethod.POST)
    public GeneralMessage login(@RequestHeader("token") String token,
                                @RequestParam("tag") String tag){
        GeneralMessage message=null;
        boolean result;
        result = nfcCardService.saveTag(token,tag);
        return message;
    }
}
