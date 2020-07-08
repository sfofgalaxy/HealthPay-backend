package com.g16.healthpay.controller;

import com.g16.healthpay.dto.BillMessage;
import com.g16.healthpay.dto.GeneralMessage;
import com.g16.healthpay.dto.BankCardMessage;
import com.g16.healthpay.intercepter.AuthToken;
import com.g16.healthpay.model.BankBill;
import com.g16.healthpay.service.BankCardService;
import com.g16.healthpay.utils.EncrypteUtils;
import com.g16.healthpay.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankCard")
public class BankCardController {
    @Autowired
    BankCardService bankCardService;

    @ApiOperation("绑定银行卡")
    @RequestMapping(value = "/bindBankCard",method = RequestMethod.POST)
    @AuthToken
    public GeneralMessage sendCaptcha(@RequestParam("phone") String phone,
                                      @RequestParam("cardNumber") String cardNumber,
                                      @RequestParam("password") String password){
        GeneralMessage message = new GeneralMessage();
        boolean result = bankCardService.bindCard(phone,cardNumber,password);
        if(result){
            message.setState(true);
            message.setMessage("绑定成功");
        }
        else{
            message.setState(false);
            message.setMessage("绑定失败");
        }
        return message;
    }



    @ApiOperation("删除银行卡")
    @RequestMapping(value = "/deleteBankCard",method = RequestMethod.POST)
    @AuthToken
    public GeneralMessage sendCaptcha(@RequestParam("cardNumber") String cardNumber){
        GeneralMessage message = new GeneralMessage();
        boolean result = bankCardService.deleteCard(cardNumber);
        if(result){
            message.setState(true);
            message.setMessage("删除成功");
        }
        else{
            message.setState(false);
            message.setMessage("删除失败");
        }
        return message;
    }


    @ApiOperation("返回对应银行卡")
    @RequestMapping(value = "/getBankCard",method = RequestMethod.POST)
    @AuthToken
    public BankCardMessage getBankCard(@RequestHeader("token") String token){
        BankCardMessage message = new BankCardMessage();

        List<BankCardMessage> bankCardMessages = bankCardService.getBankCard(token);


    }



}
