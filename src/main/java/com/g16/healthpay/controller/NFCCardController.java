package com.g16.healthpay.controller;

import com.g16.healthpay.dto.BillMessage;
import com.g16.healthpay.dto.GeneralMessage;
import com.g16.healthpay.dto.BankCardMessage;
import com.g16.healthpay.dto.NFCCardMessage;
import com.g16.healthpay.intercepter.AuthToken;
import com.g16.healthpay.model.BankBill;
import com.g16.healthpay.model.BankCard;
import com.g16.healthpay.model.NfcCard;
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
    @AuthToken
    public GeneralMessage saveTag(@RequestHeader("token") String token,
                                @RequestParam("tag") String tag){
        GeneralMessage message=new GeneralMessage();
        boolean result;
        result = nfcCardService.saveTag(token,tag);
        if(result){
            message.setState(true);
            message.setMessage("Save Success");
        }else{
            message.setState(false);
            message.setMessage("Save failed");
        }
        return message;
    }

    @ApiOperation("返回对应NFC")
    @RequestMapping(value = "/getNFCCard",method = RequestMethod.POST)
    @AuthToken
    public NFCCardMessage getNFCCard(@RequestHeader("token") String token){
        NFCCardMessage message = new NFCCardMessage();
        List<NfcCard> nfcCardsMessage = nfcCardService.getNFCCard(token);
        if(nfcCardsMessage!=null){
            message.setState(true);
            message.setNfcCards(nfcCardsMessage);
        }else{
            message.setState(false);

        }
        return message;
    }



}
